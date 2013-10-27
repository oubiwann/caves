(ns caves.entities.aspects.mobile
  (:require [caves.entities.core :refer [defaspect]]
            [caves.world.core :refer [is-empty?]]))


(defaspect Mobile
  (move [this dest world]
    {:pre [(can-move? this dest world)]}
    (assoc-in world [:entities (:id this) :location] dest))
  (can-move? [this dest world]
    (is-empty? world dest)))

