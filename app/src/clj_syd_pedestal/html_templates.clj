(ns clj-syd-pedestal.html-templates
  (:use [io.pedestal.app.templates :only [tfn dtfn tnodes]]))

(defmacro clj-syd-pedestal-templates
  []
  {:clj-syd-pedestal-page (dtfn (tnodes "clj-syd-pedestal.html" "hello") #{:id})})
