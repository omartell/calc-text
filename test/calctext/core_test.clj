(ns calctext.core-test
  (:require [clojure.test :refer :all]
            [calctext.core :refer :all]
            [clojure.java.io :as io]))

(deftest calculates-result-from-operations-in-file
  (let [result (with-out-str
                 (-main "resources/example-all-operations.txt"))]
    (is (= 81 result))))
