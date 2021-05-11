(ns scramblies-challenge-front.prod
  (:require [scramblies-challenge-front.core :as core]))

;;ignore println statements in prod
(set! *print-fn* (fn [& _]))

(core/init!)
