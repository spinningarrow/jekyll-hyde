(ns jekyll-hyde.handler-test
  (:require [clojure.test :refer :all]
            [ring.mock.request :as mock]
            [jekyll-hyde.handler :refer :all]))

(deftest test-app
  (testing "main route"
    (let [response (app (mock/request :get "/"))]
      (is (= (:status response) 200))
      (is (= (:body response) "{\"data\":\"Hello world\"}"))))

  (testing "not-found route"
    (let [response (app (mock/request :get "/invalid"))]
      (is (= (:status response) 404)))))
