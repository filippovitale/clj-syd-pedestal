(ns ^:shared hw.behavior
  (:require [clojure.string :as string]
            [io.pedestal.app :as app]
            [io.pedestal.app.messages :as msg]))

(defn init-main [_]
  [[:transform-enable [:greeting ] :set-value [{msg/topic :set-value}]]])

(def example-app
  {:version 2
   :transform [[:set-value [:greeting ] set-value-transform]]
   :emit [{:init init-main}
          [#{[:* ]} (app/default-emitter [])]]
   })