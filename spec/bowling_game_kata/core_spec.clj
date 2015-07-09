(ns bowling-game-kata.core-spec
  (:require [speclj.core :refer :all]
            [bowling-game-kata.core :refer :all]))

(describe "score"
  (it "gutter game results in a score of zero"
    (should= 0 (score (repeat 0))))

  (it "one pin rolls game results in a score of twenty"
    (should= 20 (score (repeat 1))))

  (it "spare frame adds next roll to score"
    (should= 12 (score (concat [5 5 1] (repeat 0)))))

  (it "strike frame adds next 2 rolls to score"
    (should= 14 (score (concat [10 1 1] (repeat 0)))))

  (it "perfect game results in score of three hundred"
    (should= 300 (score (repeat 10)))))




