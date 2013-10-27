(ns caves.config)


;; Determine the nature of the caves
;;  0-2:    These give one huge cave with no features.
;;  3:      Gives the slightest hints of features.
;;  4:      A few interesting features here and there, still mostly open.
;;  5:      Lots of solid features, about 50/50 with open space.
;;  6:      Almost all closed spaces; most of the game will be digging.
;;  7+:     Unplayable! you don't want to use these numbers; there won't be
;;              enough space to place all the entities, and the game will
;;              hang :-/
(def smoothness 5)

;; Key bindings for player movement
(def key-west \a)
(def key-south \s)
(def key-north \w)
(def key-east \d)
(def key-north-west \q)
(def key-north-east \e)
(def key-south-west \z)
(def key-south-east \c)

;; Key bindings for game controls
(def key-insta-win :enter)
(def key-insta-lose :backspace)
(def key-quit \Q)
(def key-reveal-zones \R)

;; Tile representations
(def tile-floor [" " :white])
(def tile-wall ["#" :white])
(def tile-up ["^" :magenta])
(def tile-down ["v" :magenta])
(def tile-bound ["X" :black])

;; Player options
(def player-char "@")
(def player-color :white)
(def player-hit-points 40)
(def player-max-hit-points 40)
(def player-attack-power 10)
