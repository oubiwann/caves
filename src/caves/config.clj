(ns caves.config)

;; Determine the nature of the caves
;;  0-2:    give one huge cave with no features
;;  3:      gives the slightest hints of features
;;  4:      a little features here and there, still mostly open
;;  5:      lots of solid features, about 50/50 with open space
;;  6:      almost all closed spaces; most of the game will be digging
;;  7+:     unplayable! you don't want to use these numbers; there won't be
;;          enough space to place all the entities
(def smoothness 6)

