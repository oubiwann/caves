(ns caves.ui.input
  (:require [caves.world.generation :refer [random-world smooth-world]]
        [caves.entities.player :refer [move-player]]
        [caves.ui.core :refer [->UI]]
        [lanterna.screen :as s]))


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
    :enter     (assoc game :uis [(->UI :win)])
    :backspace (assoc game :uis [(->UI :lose)])
    \Q         (assoc game :uis [])

    \a (update-in game [:world] move-player :w)
    \s (update-in game [:world] move-player :s)
    \w (update-in game [:world] move-player :n)
    \d (update-in game [:world] move-player :e)
    \q (update-in game [:world] move-player :nw)
    \e (update-in game [:world] move-player :ne)
    \z (update-in game [:world] move-player :sw)
    \c (update-in game [:world] move-player :se)

    \R (update-in game [:debug-flags :show-regions] not)

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
