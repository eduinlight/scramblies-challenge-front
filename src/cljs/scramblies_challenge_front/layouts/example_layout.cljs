(ns scramblies-challenge-front.layouts.example-layout
  (:require [reagent.core :as r]
            [scramblies-challenge-front.components.shared.header :refer [header]]))

(defn example-layout
  "this is just an example for you guys"
  []
  (fn []
    [:<>
     [header]
     (into [:div.content] (r/children (r/current-component)))]))
