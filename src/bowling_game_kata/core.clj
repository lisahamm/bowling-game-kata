(ns bowling-game-kata.core)

(defn- sum [rolls]
  (reduce + rolls))

(defn- spare? [rolls]
  (= 10 (sum (take 2 rolls))))

(defn- strike? [rolls]
  (= 10 (first rolls)))

(defn- rolls-for-frame [rolls]
  (if (or (strike? rolls)(spare? rolls))
    (take 3 rolls)
    (take 2 rolls)))

(defn- rest-of-rolls [rolls]
  (if (strike? rolls)
    (drop 1 rolls)
    (drop 2 rolls)))

(defn- to-frames [rolls]
  (lazy-seq (cons (rolls-for-frame rolls)
    (to-frames (rest-of-rolls rolls)))))

(defn score [rolls]
  (sum (map sum (take 10 (to-frames rolls)))))

