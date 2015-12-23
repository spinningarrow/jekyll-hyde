(ns jekyll-hyde.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.json :as middleware]
            [ring.middleware.defaults :refer [wrap-defaults api-defaults]]
            [ring.util.response :refer [response]]))

(defroutes app-routes
  (GET "/" []
       (response
         {:data "Hello world"}))

  (GET "/posts" []
       (response
         {:data [{:id 1 :contents "Today went well"}
                 {:id 2 :contents "Today was not that great"}
                 {:id 3 :contents "Whatever"}]}))

  (GET "/config" []
       (response
         {:data {:highlighter :rouge
                 :markdown :kramdown
                 :watch true}}))

  (route/not-found "Not Found"))

(def app
  (-> app-routes
      (middleware/wrap-json-body)
      (middleware/wrap-json-response)
      (wrap-defaults api-defaults)))
