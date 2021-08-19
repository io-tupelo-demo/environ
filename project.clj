(defproject demo "0.1.0-SNAPSHOT"
  :license {:name "Eclipse Public License"
            :url  "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [
                 [environ "1.2.0"] ; code reads values like `(environ.core/env :database-url)`
                 [org.clojure/clojure "1.10.3"]
                 [prismatic/schema "1.1.12"]
                 [tupelo "21.07.08"]
                ]

  :plugins [
    [com.jakemccrary/lein-test-refresh "0.24.1"]
    [lein-ancient "0.7.0"]
    [lein-environ "1.2.0"] ; causes `profiles.clj` to override `project.clj`
    [lein-pprint "1.3.2"]  ; allows display of project map
    ]

  :global-vars {*warn-on-reflection* false}
  :main ^:skip-aot demo.core

  :source-paths            ["src/clj"]
  :java-source-paths       ["src/java"]
  :test-paths              ["test/clj"]
  :target-path             "target/%s"
  :compile-path            "%s/class-files"
  :clean-targets           [:target-path]

  :profiles {; *** overwritten from profiles.clj ***
             :profiles/dev  {}  ; placeholder value
             :profiles/test {}  ; placeholder value

             ; *** default map values before merging ***
             :project/dev {:source-paths ["src" "tool-src"] }
             :project/test {:test-paths ["tool-test"]}

             ; maps are merged merge, last one wins (i.e. values from `profiles.clj`)
             :dev  [:project/dev  :profiles/dev]
             :test [:project/test :profiles/test]
           }

  :jvm-opts ["-Xms500m" "-Xmx2g" ]
  )
