(ns calculadora-trastes.server
  (:require
   [compojure.core :refer [GET defroutes]]
   [compojure.route :as route]
   [ring.adapter.jetty :refer [run-jetty]]
   [ring.middleware.json :refer [wrap-json-response]]
   [ring.middleware.params :refer [wrap-params]]
   [ring.util.response :refer [response file-response status]]
   [calculadora-trastes.core :refer [calcular-trastes]])
  (:gen-class))

(defn numero-valido? [valor]
  (try
    (let [numero (Double/parseDouble valor)]
      (pos? numero))
    (catch Exception _
      false)))

(defn calcular-handler [escala]
  (if (numero-valido? escala)
    (response
     (calcular-trastes
      (Double/parseDouble escala)))

    (-> (response
         {:erro "Informe uma escala válida em milímetros."})
        (status 400))))

(defroutes app-routes
  (GET "/" []
    (file-response "public/index.html"))

  (GET "/api/trastes" [escala]
    (calcular-handler escala))

  (route/files "/" {:root "public"})

  (route/not-found "Página não encontrada"))

(def app
  (-> app-routes
      wrap-params
      wrap-json-response))

(defn -main []
  (println "Servidor rodando em http://localhost:3000")
  (run-jetty app {:port 3000 :join? false}))