(ns caves.entities.lichen
  (:require [caves.entities.core :refer [Entity get-id add-aspect]]
            [caves.entities.aspects.receiver :refer [send-message-nearby]]
            [caves.entities.aspects.destructible :refer [Destructible]]
            [caves.world.core :refer [find-empty-neighbor]]))


(defrecord Lichen [id glyph color location hp max-hp name])

(defn make-lichen [location]
  (map->Lichen {:id (get-id)
                :name "lichen"
                :glyph "F"
                :color :green
                :location location
                :hp 6
                :max-hp 6}))

(defn should-grow []
  (< (rand) (/ 1 500)))

(defn grow [{:keys [location]} world]
  (if-let [target (find-empty-neighbor world location)]
    (let [new-lichen (make-lichen target)
          world (assoc-in world [:entities (:id new-lichen)] new-lichen)
          world (send-message-nearby location "The lichen grows." world)]
      world)
    world))


(extend-type Lichen Entity
  (tick [this world]
    (if (should-grow)
      (grow this world)
      world)))

(add-aspect Lichen Destructible)
