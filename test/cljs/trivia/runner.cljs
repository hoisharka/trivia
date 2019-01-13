(ns trivia.runner
  (:require  [cljs.test :as t]
             [doo.runner :refer-macros [doo-tests]]))

(doo-tests 'trivia.core-test)

