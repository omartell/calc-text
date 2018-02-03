(ns calctext.core-test
  (:require [clojure.test :refer :all]
            [calctext.core :refer :all]
            [clojure.java.io :as io]))

(deftest calculates-result-from-operations-in-file
  (let [result (with-out-str
                 (-main "resources/example-all-operations.txt"))]
    (is (= 81 result))))

(deftest supports-adding-numbers
  (let [result (with-out-str
                 (-main "resources/example-only-adding.txt"))]
    (is (= "5" result))))

(deftest supports-substracting-numbers
  (let [result (with-out-str
                 (-main "resources/example-only-substracting.txt"))]
    (is (= "-5" result))))

(deftest supports-multiplicating-numbers
  (let [result (with-out-str
                 (-main "resources/example-only-multiplicating.txt"))]
    (is (= "6" result))))
