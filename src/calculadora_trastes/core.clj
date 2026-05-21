(ns calculadora-trastes.core)

(def total-trastes 24)

(defn arredondar [valor]
  (/ (Math/round (* valor 100.0)) 100.0))

(defn distancia-pestana [escala n]
  (* escala (- 1 (/ 1 (Math/pow 2 (/ n 12.0))))))

(defn calcular-traste [escala n distancia-anterior]
  (let [pestana (distancia-pestana escala n)
        rastilho (- escala pestana)
        espacamento (- pestana distancia-anterior)]

    {:traste n
     :espacamento_mm (arredondar espacamento)
     :distancia_rastilho_mm (arredondar rastilho)
     :distancia_pestana_mm (arredondar pestana)}))

(defn calcular-trastes [escala]

  (loop [n 1
         anterior 0
         resultado []]

    (if (> n total-trastes)

      resultado

      (let [pestana (distancia-pestana escala n)
            traste (calcular-traste escala n anterior)]

        (recur
         (inc n)
         pestana
         (conj resultado traste))))))

(defn imprimir-tabela [escala]

  (println "\n==============================================")
  (println "       CALCULADORA DE TRASTES")
  (println "==============================================")
  (println (str "Escala: " escala " mm"))
  (println "==============================================")

  (printf "%-8s %-18s %-22s %-22s\n"
          "Traste"
          "Espacamento"
          "Dist. Rastilho"
          "Dist. Pestana")

  (println "----------------------------------------------------------------------------")

  (doseq [traste (calcular-trastes escala)]

    (printf "%-8d %-18.2f %-22.2f %-22.2f\n"

            (:traste traste)
            (:espacamento_mm traste)
            (:distancia_rastilho_mm traste)
            (:distancia_pestana_mm traste)))

  (println "----------------------------------------------------------------------------"))