(defproject demo "0.1.0-SNAPSHOT"
  :license {:name "Eclipse Public License"
            :url  "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [
                 [environ "1.2.0"]
                 [org.clojure/clojure "1.10.3"]
                 [prismatic/schema "1.1.12"]
                 [tupelo "21.07.08"]
                ]

  :plugins [
    [com.jakemccrary/lein-test-refresh "0.24.1"]
    [lein-ancient "0.7.0"]
    [lein-environ "1.2.0"]
    ]

  :global-vars {*warn-on-reflection* false}
  :main ^:skip-aot demo.core

  :source-paths            ["src/clj"]
  :java-source-paths       ["src/java"]
  :test-paths              ["test/clj"]
  :target-path             "target/%s"
  :compile-path            "%s/class-files"
  :clean-targets           [:target-path]

  :profiles {
             :profiles/dev  {} ; *** overwritten from profiles.clj ***
             :profiles/test {} ; *** overwritten from profiles.clj ***

             :project/dev {:source-paths ["src" "tool-src"] }
             :project/test {}

             ; merge, last one wins
             :dev  [:project/dev :profiles/dev]
             :test [:project/test :profiles/test]
           }

  :jvm-opts ["-Xms500m" "-Xmx2g" ]
  )
