(ns scramblies-challenge-front.services.api
  (:require [ajax.core :as http]
            [scramblies-challenge-front.config :refer [config]]))

(defn error-handler [error]
  ; (aglobals/set-loading false)
  (println error))

(defn scramble [model success]
  (http/POST (str (:api-url config) "/api/scramble")
    {:params model
     :handler success
     :error-handler error-handler
     :with-credentials false
     :request-format :json
     :response-format :json
     :keywords? true}))
