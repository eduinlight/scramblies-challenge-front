(ns scramblies-challenge-front.components.home
  (:require [reagent.core :as r]
            [react :as react]
            [scramblies-challenge-front.services.api :refer [scramble]]))

(defn home
  []
  (let [model (r/atom {:str1 ""
                       :str2 ""})
        ajax (r/atom {:loading false
                      :result nil})]

    (defn handle-change [key]
      (fn [event]
        (swap! ajax assoc-in [:loading] false)
        (swap! model assoc-in [key] (-> event .-target .-value))))

    (defn handle-submit [event]
      (.preventDefault event)
      (swap! ajax assoc-in [:loading] true)
      (scramble @model
                (fn [response]
                  (swap! ajax assoc-in [:loading] false)
                  (swap! ajax assoc-in [:result] response))))

    (fn []
      (let [loading (:loading @ajax)
            result (:result @ajax)
            str1 (:str1 @model)
            str2 (:str2 @model)
            isValid (and (re-matches #"[a-z]+" str1) (re-matches #"[a-z]+" str2))]

        [:form {:on-submit handle-submit}

         [:div.mb-2
          "Complete the function (scramble str1 str2) that returns true if a portion of str1 characters can be rearranged to match str2, otherwise returns false"]

         [:div.form-control-row.mb-2
          [:label {:for "input-str1"}
           "str1"]
          [:input#input-str1 {:type "text"
                              :placeholder "english lowercase letters text"
                              :value str1
                              :on-change (handle-change :str1)}]]

         [:div.form-control-row.mb-2
          [:label {:for "input-str2"}
           "str2"]
          [:input#input-str2 {:type "text"
                              :placeholder "english lowercase letters text"
                              :value str2
                              :on-change (handle-change :str2)}]]

         [:button.mb-2 {:type "submit"
                        :disabled (not isValid)}
          "See result"]

         [:div.result
          (when loading
            "loading...")
          (when (and (not loading) (nil? result))
            "please complete the data and press the button to see the result")
          (when (and (not loading) (not (nil? result)))
            result)]]))))
