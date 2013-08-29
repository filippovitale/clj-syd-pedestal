(ns hw.simulated.start
  (:require [io.pedestal.app.render.push.handlers.automatic :as d]
            [hw.start :as start]
            [hw.rendering :as rendering]
            [hw.simulated.services :as services]
            [goog.Uri]
            ;; This needs to be included somewhere in order for the
            ;; tools to work.
            [io.pedestal.app-tools.tooling :as tooling]
            [io.pedestal.app.protocols :as p]))

(defn param [name]
  (let [uri (goog.Uri. (.toString (.-location js/document)))]
    (.getParameterValue uri name)))

(defn ^:export main []
  (let [app (start/create-app (if (= "auto" (param "renderer"))
                                d/data-renderer-config
                                (rendering/render-config)))
        services (services/->MockServices (:app app))
        ]
    (p/start services)
    app))