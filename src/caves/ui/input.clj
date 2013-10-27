(ns caves.ui.input
  (:require [lanterna.screen :as s]
            [caves.world.generation :refer [random-world smooth-world]]
            [caves.entities.player :refer [move-player]]
            [caves.ui.core :refer [->UI]]
            [caves.config :as config]))


(defn reset-game [game]
  (let [fresh-world (random-world)]
    (-> game
      (assoc :world fresh-world)
      (assoc :uis [(->UI :play)]))))


(defmulti process-input
  (fn [game input]
    (:kind (last (:uis game)))))

(defmethod process-input :start [game input]
  (reset-game game))


(defmethod process-input :play [game input]
  (case input
    :enter (assoc game :uis [(->UI :win)])
    :backspace (assoc game :uis [(->UI :lose)])
    config/key-quit (assoc game :uis [])

    config/key-west (update-in game [:world] move-player :w)
    config/key-south (update-in game [:world] move-player :s)
    config/key-north (update-in game [:world] move-player :n)
    config/key-east (update-in game [:world] move-player :e)
    config/key-north-west (update-in game [:world] move-player :nw)
    config/key-north-east (update-in game [:world] move-player :ne)
    config/key-south-west (update-in game [:world] move-player :sw)
    config/key-south-east (update-in game [:world] move-player :se)

    config/key-reveal-zones (update-in game [:debug-flags :show-regions] not)

    game))

(defmethod process-input :win [game input]
  (if (= input :escape)
    (assoc game :uis [])
    (assoc game :uis [(->UI :start)])))

(defmethod process-input :lose [game input]
  (if (= input :escape)
    (assoc game :uis [])
    (assoc game :uis [(->UI :start)])))


(defn get-input [game screen]
  (assoc game :input (s/get-key-blocking screen)))
