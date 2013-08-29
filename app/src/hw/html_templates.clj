(ns hw.html-templates
  (:use [io.pedestal.app.templates :only [tfn dtfn tnodes]]))

(defmacro hw-templates
  []
  {:hw-page (dtfn (tnodes "hw.html" "hello") #{:id})})
