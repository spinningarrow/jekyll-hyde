(defproject jekyll-hyde "0.1.0-SNAPSHOT"
  :description "An HTTP API for Jekyll"
  :url "http://example.com/FIXME"
  :min-lein-version "2.0.0"
  :dependencies [[org.clojure/clojure "1.7.0"]
                 [compojure "1.4.0"]
                 [ring/ring-defaults "0.1.5"]
                 [ring/ring-json "0.4.0"]
                 [cheshire "5.5.0"]]
  :plugins [[lein-ring "0.9.7"]]
  :ring {:handler jekyll-hyde.handler/app}
  :profiles
  {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                        [ring/ring-mock "0.3.0"]]}})
