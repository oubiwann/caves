(ns caves.entities.bunny
  (:require [caves.entities.core :refer [Entity get-id add-aspect]]
            [caves.entities.aspects.destructible :refer [Destructible]]
            [caves.entities.aspects.mobile :refer [Mobile move]]
            [caves.world.core :refer [find-empty-neighbor]]))


(defrecord Bunny [id glyph color location hp max-hp name])

(defn make-bunny [location]
  (map->Bunny {:id (get-id)
               :name "bunny"
               :glyph "v"
               :color :yellow
               :location location
               :hp 4
               :max-hp 4}))


(extend-type Bunny Entity
  (tick [this world]
    (if-let [target (find-empty-neighbor world (:location this))]
      (move this target world)
      world)))

(add-aspect Bunny Mobile)
(add-aspect Bunny Destructible)
