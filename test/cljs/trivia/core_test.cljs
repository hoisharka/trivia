(ns trivia.core-test
  (:require [trivia.core :as sut]
            [cljs.test :as t]))

(t/deftest testing-clojurescript
  (t/is (= (sut/add-numbers 1 2) 3)))




