(ns app.utils.colors
  (:require [clojure.string :as str]
            [goog.string :as gstring]
            [goog.string.format]))

;; ------------- Utility functions for dealing with colors ----
(defn to-hex-string
  [rgb-values]
  (->> rgb-values
       (map #(-> (.toString % 16) (.padStart 2 "0")))
       (apply str "#")))

(defn rand-color
  []
  (->>
   (repeatedly #(rand-int 0xff))
   (take 3)
   (to-hex-string)))

(defn get-compliment
  [color]
  (->> (subs color 1)
       (re-seq #".{1,2}")
       (map #(-> (js/parseInt % 16) (- 0xff) (js/Math.abs)))
       (to-hex-string)))

;; ----------------------------------------------------------------