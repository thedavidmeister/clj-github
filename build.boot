(def project 'thedavidmeister/clj-github)
(def description "Simple wrapper around github endpoints")
(def version "0.1.0-SNAPSHOT")
(def url "https://github.com/thedavidmeister/clj-github")

(set-env!
 :source-paths #{"src"}
 :dependencies
 '[[org.clojure/clojure "1.9.0-alpha19"]
   [adzerk/bootlaces "0.1.13" :scope "test"]
   [adzerk/boot-test "1.2.0"]
   [com.taoensso/timbre "4.10.0"]])

(task-options!
 pom {:project project
      :version version
      :description description
      :url url
      :scm {:url url}})

(require
 '[adzerk.bootlaces :refer :all])
(bootlaces! version)

(deftask tests
 []
 (comp
  (test)))

(deftask deploy
 []
 (comp
  (build-jar)
  (push-snapshot)))
