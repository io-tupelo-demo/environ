(ns demo.core
  (:use tupelo.core)
  (:require
    [environ.core :as environ]
    [schema.core :as s])
  )

(defn -main
  [& args]
  (newline)
  (println "Running in demo.core/-main")
  (spyx (environ/env :database-url))  ; => "jdbc:postgresql://localhost/dev"
  (newline)
)

