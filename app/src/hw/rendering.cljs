(ns hw.rendering
  (:require [domina :as dom]
            [io.pedestal.app.render.push :as render]
            [io.pedestal.app.render.events :as events]
            [io.pedestal.app.messages :as msg]
            [io.pedestal.app.render.push.templates :as templates]
            [io.pedestal.app.render.push.handlers.automatic :as d])
  (:require-macros [hw.html-templates :as html-templates]))

(defn button-enable [r [_ path transform-name messages] d]
  (events/send-on-click (dom/by-id "msg-button")
                          d
                          transform-name
                          [{msg/type :set-value msg/topic [:greeting] :value "Pedestal Rocks!"}]))

(defn render-config []
  [[:node-create  [:greeting] render-page]
   [:node-destroy   [:greeting] d/default-exit]
   [:value [:greeting] render-message]
   [:transform-enable [:greeting] button-enable]])