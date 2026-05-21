(ns calculadora-trastes.server
  (:require
   [compojure.core :refer [GET defroutes]]
   [compojure.route :as route]
   [ring.adapter.jetty :refer [run-jetty]]
   [ring.middleware.json :refer [wrap-json-response]]
   [ring.middleware.params :refer [wrap-params]]
   [ring.util.response :refer [response]]
   [calculadora-trastes.core :refer [calcular-trastes]])
  (:gen-class))

(defroutes app-routes

  (GET "/api/trastes" [escala]
    (response
     (calcular-trastes
      (Double/parseDouble escala))))

  (route/resources "/")
  (route/not-found "Página não encontrada"))

(def app
  (-> app-routes
      wrap-params
      wrap-json-response))

(defn -main []
  (run-jetty app {:port 3000 :join? false}))