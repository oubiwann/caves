(ns caves.config)

;; Determine the nature of the caves
;;  0-2:    give one huge cave with no features
;;  3:      gives the slightest hints of features
;;  4:      a few interesting features here and there, still mostly open
;;  5:      lots of solid features, about 50/50 with open space
;;  6:      almost all closed spaces; most of the game will be digging
;;  7+:     unplayable! you don't want to use these numbers; there won't be
;;          enough space to place all the entities, and the game will hang :-/
(def smoothness 4)

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
