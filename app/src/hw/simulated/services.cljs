(ns hw.simulated.services
  (:require [io.pedestal.app.protocols :as p]
            [io.pedestal.app.messages :as msg]
            [io.pedestal.app.util.platform :as platform]))

(defn increment-counter [new-greeting input-queue]
  (p/put-message input-queue {msg/type :set-value
                              msg/topic [:greeting ]
                              :value new-greeting}))

(defn receive-messages [input-queue]
  (increment-counter "Clojure rocks" input-queue)
  (platform/create-timeout 3000 #(increment-counter "so does..." input-queue))
  (platform/create-timeout 5000 #(increment-counter "Clojurescript!" input-queue)))

(defrecord MockServices [app]
  p/Activity
  (start [this]
    (receive-messages (:input app)))
  (stop [this]))