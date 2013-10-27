(ns caves.entities.player
  (:require [caves.entities.core :refer [Entity add-aspect]]
            [caves.entities.aspects.receiver :refer [Receiver]]
            [caves.entities.aspects.mobile :refer [Mobile move can-move?]]
            [caves.entities.aspects.digger :refer [Digger dig can-dig?]]
            [caves.entities.aspects.attacker :refer [Attacker attack]]
            [caves.entities.aspects.destructible :refer [Destructible]]
            [caves.coords :refer [destination-coords]]
            [caves.world.core :refer [get-entity-at]]))


(defrecord Player [id glyph color location hp max-hp attack name])

(extend-type Player Entity
  (tick [this world]
    world))

(add-aspect Player Mobile)
(add-aspect Player Digger)
(add-aspect Player Attacker)
(add-aspect Player Destructible)
(add-aspect Player Receiver)

(defn make-player [location]
  (map->Player {:id :player
                :name "player"
                :glyph "@"
                :color :white
                :location location
                :hp 40
                :max-hp 40
                :attack 10}))

(defn move-player [world dir]
  (let [player (get-in world [:entities :player])
        target (destination-coords (:location player) dir)
        entity-at-target (get-entity-at world target)]
    (cond
      entity-at-target (attack player entity-at-target world)
      (can-move? player target world) (move player target world)
      (can-dig? player target world) (dig player target world)
      :else world)))
