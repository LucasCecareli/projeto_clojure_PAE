(ns calculadora-trastes.server
  (:require
   [compojure.core :refer [GET defroutes]]
   [compojure.route :as route]
   [ring.adapter.jetty :refer [run-jetty]]
   [ring.middleware.json :refer [wrap-json-response]]
   [ring.middleware.params :refer [wrap-params]]
   [ring.util.response :refer [response file-response]]
   [calculadora-trastes.core :refer [calcular-trastes]])
  (:gen-class))

(defroutes app-routes
  (GET "/" []
    (file-response "public/index.html"))

  (GET "/api/trastes" [escala]
    (response
     (calcular-trastes
      (Double/parseDouble escala))))

  (route/files "/" {:root "public"})
  (route/not-found "Página não encontrada"))

(def app
  (-> app-routes
      wrap-params
      wrap-json-response))

(defn -main []
  (println "Servidor rodando em http://localhost:3000")
  (run-jetty app {:port 3000 :join? false}))