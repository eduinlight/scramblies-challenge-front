(ns scramblies-challenge-front.pages.home-page
  (:require [reagent.core :as r]
            [scramblies-challenge-front.components.home :refer [home]]
            [scramblies-challenge-front.layouts.example-layout :refer [example-layout]]))

(defn home-page []
  (fn []
    [example-layout
     [home]]))
