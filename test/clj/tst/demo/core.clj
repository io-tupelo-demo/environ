(ns tst.demo.core
  (:use demo.core tupelo.core tupelo.test)
  (:require
    [environ.core :as environ]
    [tupelo.string :as str]
    ))

(dotest
  ; in "test" mode, this value from `profiles.clj` will be found
  (is=  (environ/env :database-url) "jdbc:postgresql://localhost/test")
)


