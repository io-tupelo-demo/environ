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

  ; prints current value from execution environment 
  ;   "dev" mode => "jdbc:postgresql://localhost/dev"
  ;   "prod" mode => "jdbc:postgresql://localhost/prod"
  (spyx (environ/env :database-url))

  (newline))

