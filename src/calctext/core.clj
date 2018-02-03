(ns calctext.core
  (:require [clojure.string :as string])
  (:gen-class))

(defn parse-integer [s]
  (Integer/parseInt s))

(defn parse-expression [[operator & operands]]
  (case operator
    "ADD" [+ (map parse-integer operands)]
    "SUB" [- (map parse-integer operands)]))

(defn perform-operation [acc [operator operands]]
  (apply operator operands))

(defn -main [& [filename]]
  (->> (slurp filename)
       string/split-lines
       (map #(string/split % #"\s"))
       (map #(parse-expression %))
       (reduce perform-operation 0)
       print))
