(defproject trivia "0.0.1-SNAPSHOT"
  :description "Trivia Game"
  :url "https://www.example.com"
  :licences {:name "GPLv3"
             :url "https://choosealicense.com/licences/gpl-3.0/#"}

  :dependencies [[org.clojure/clojure "1.9.0"]
                 [org.clojure/clojurescript "1.10.238"]
                 [org.clojure/core.async "0.4.490"]
                 [reagent "0.9.0-SNAPSHOT"]]

  :plugins [[lein-cljsbuild "1.1.7"]]

  :min-lein-version "2.6.1"
  :main ^:skip-aot trivia.core

  :target-path "target/%s"

  :source-paths ["src/clj" "src/cljs"]
  :test-paths ["test/clj"]
  
  :clean-targets ^{:protect false} ["resources/public/js/compiled"
                                    "target"
                                    "test/js"]
  :profiles {:uberjar {:aot :all}
             :dev {:dependencies [[cider/piggieback "0.3.10"]
                                  [org.clojure/tools.nrepl "0.2.13"]
                                  [figwheel-sidecar "0.5.16"]
                                  [binaryage/devtools "0.8.0"]]
                   :repl-options {:nrepl-middleware [cider.piggieback/wrap-cljs-repl]}
                   :plugins [[lein-figwheel "0.5.18"]
                             [lein-doo "0.1.7"]]}}
  
  :cljsbuild {:builds [{:id "dev"
                        :source-paths ["src/cljs"]
                        :figwheel {:on-jsload "trivia.core/mount-root"}
                        :compiler {:main trivia.core
                                   :output-to "resources/public/js/compiled/app.js"
                                   :output-dir "resources/public/js/compiled/out"
                                   :asset-path "js/compiled/out"
                                   :source-map-timestamp true}}
                       {:id "test"
                        :source-paths ["src/cljs" "test/cljs"]
                        :compiler {:output-to "resources/public/js/compiled/test.js"
                                   :main trivia.runner
                                   :optimization :none}}]}
 
  )
