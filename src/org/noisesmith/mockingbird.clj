(ns org.noisesmith.mockingbird
  (:gen-class))

(defn -main
  "birbs"
  [& args]
  (doto :chirp-chirp
    println))

(defn validator-one
  [datum]
  (let [mdtau (set (take 3 (shuffle datum)))]
    (assert (and (contains? mdtau :red)
                 (contains? mdtau :yellow))
            "no bad flower bed")
    (contains? mdtau :blue)))

(defn has?
  [color a b c]
  (contains? (hash-set a b c) color))

(defn pick-three
  [a b c]
  {:pre [(has? :red a b c)
         (has? :yellow a b c)]}
  (has? :blue a b c))

(defn all-possible-beds
  [flowers]
  (let [next-flowers (mapcat (fn [flower-list]
                               [(cons :red flower-list)
                                (cons :blue flower-list)
                                (cons :yellow flower-list)])
                             flowers)]
    (println "generated" next-flowers)
    (lazy-seq
     (concat next-flowers
           (all-possible-beds
            next-flowers)))))

(defn puzzle-one
  "the answer"
  []
  )
