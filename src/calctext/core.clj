(ns calctext.core
  (:require [clojure.string :as string])
  (:gen-class))

(defn parse-expression [[operation :as expression]]
  (case operation
    "ADD" [+ (map #(Integer/parseInt %) (rest expression))]
    "SUB" [- (map #(Integer/parseInt %) (rest expression))]))

(defn -main [& [filename]]
  (let [lines (string/split-lines (slurp filename))]
    (->> lines
         (map #(string/split % #"\s"))
         (map #(parse-expression %))
         (reduce (fn [acc [operator args]]
                   (apply operator args)) 0)
         print)))
