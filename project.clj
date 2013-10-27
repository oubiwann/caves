(defproject caves "0.1.0-SNAPSHOT"
  :description "The Caves of Clojure"
  :url "http://stevelosh.com/blog/2012/07/caves-of-clojure-01/"
  :license {:name "MIT/X11"}
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [org.clojure/math.numeric-tower "0.0.2"]
                 [clojure-lanterna "0.9.4"]]
  :main ^{:skip-aot true} caves.core)
