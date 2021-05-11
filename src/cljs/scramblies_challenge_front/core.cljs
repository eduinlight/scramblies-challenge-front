(ns scramblies-challenge-front.core
  (:require [reagent.core :as reagent :refer [atom]]
            [reagent.dom :as rdom]
            [scramblies-challenge-front.pages.home-page :refer [home-page]]))

(defn mount-root []
  (rdom/render [home-page] (.getElementById js/document "app")))

(defn init! []
  (mount-root))
