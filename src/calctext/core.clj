(ns calctext.core
  (:require [clojure.string :as string])
  (:gen-class))

(defn parse-integer [s]
  (Integer/parseInt s))

(defmulti parse-expression (fn [[operator]]
                             operator))

(defmethod parse-expression "ADD"
  ([[operator & operands]]
   [+ (map parse-integer operands)]))

(defmethod parse-expression "SUB"
  ([[operator & operands]]
   [- (map parse-integer operands)]))

(defmethod parse-expression "MULT"
  ([[operator & operands]]
   [* (map parse-integer operands)]))

(defmethod parse-expression "DIV"
  ([[operator & operands]]
   [/ (map parse-integer operands)]))

(defn perform-operation [acc [operator operands]]
  (apply operator (into [acc] operands)))

(defn -main [& [filename]]
  (->> (slurp filename)
       string/split-lines
       (map #(string/split % #"\s"))
       (map #(parse-expression %))
       (reduce perform-operation 0)
       print))
