;; This file is used to warn users when they attempt to load a plugin that
;; pulls in a dependency which conflicts with something already in use
;; by Leiningen itself.

;; This code regenerates the map
#_(do (require '[leiningen.core.project :as project])
      (require '[leiningen.core.classpath :as cp])
      (require '[clojure.pprint :as pp])

      (defn artifacts [h]
        (apply concat (keys h) (map artifacts (vals h))))

      (let [hierarchy (cp/managed-dependency-hierarchy :dependencies
                                                       :managed-dependencies
                                                       (project/read))]
        (-> (into {} (for [[a v] (artifacts hierarchy)]
                       [a v]))
            ;; Unhelpful to warn on these:
            (dissoc 'org.clojure/clojure)
            (dissoc 'leiningen-core)
            (pp/pprint))))
{clojure-complete "0.2.5"
 com.cemerick/pomegranate "1.1.0"
 com.google.guava/guava "27.1-jre"
 com.hypirion/io "0.3.1"
 commons-codec "1.9"
 commons-io "2.6"
 commons-lang "2.6"
 commons-logging "1.2"
 javax.inject "1"
 net.cgrand/parsley "0.9.3"
 net.cgrand/regex "1.1.0"
 net.cgrand/sjacket "0.1.1"
 nrepl "0.6.0"
 org.apache.commons/commons-lang3 "3.5"
 org.apache.httpcomponents/httpclient "4.5.3"
 org.apache.httpcomponents/httpcore "4.4.6"
 org.apache.maven.resolver/maven-resolver-api "1.1.1"
 org.apache.maven.resolver/maven-resolver-connector-basic "1.0.3"
 org.apache.maven.resolver/maven-resolver-impl "1.1.1"
 org.apache.maven.resolver/maven-resolver-spi "1.1.1"
 org.apache.maven.resolver/maven-resolver-transport-file "1.0.3"
 org.apache.maven.resolver/maven-resolver-transport-http "1.0.3"
 org.apache.maven.resolver/maven-resolver-transport-wagon "1.0.3"
 org.apache.maven.resolver/maven-resolver-util "1.1.1"
 org.apache.maven.wagon/wagon-http "3.0.0"
 org.apache.maven.wagon/wagon-http-shared "3.0.0"
 org.apache.maven.wagon/wagon-provider-api "3.0.0"
 org.apache.maven/maven-artifact "3.5.3"
 org.apache.maven/maven-builder-support "3.5.3"
 org.apache.maven/maven-model "3.5.3"
 org.apache.maven/maven-model-builder "3.5.3"
 org.apache.maven/maven-repository-metadata "3.5.3"
 org.apache.maven/maven-resolver-provider "3.5.3"
 org.clojure/core.specs.alpha "0.2.44"
 org.clojure/data.codec "0.1.0"
 org.clojure/data.xml "0.2.0-alpha5"
 org.clojure/spec.alpha "0.2.176"
 org.clojure/tools.macro "0.1.5"
 org.codehaus.plexus/plexus-component-annotations "1.7.1"
 org.codehaus.plexus/plexus-interpolation "1.24"
 org.codehaus.plexus/plexus-utils "3.1.0"
 org.flatland/classlojure "0.7.1"
 org.jsoup/jsoup "1.7.2"
 org.slf4j/slf4j-api "1.7.25"
 org.slf4j/slf4j-nop "1.7.25"
 org.tcrawley/dynapath "1.0.0"
 quoin "0.1.2"
 robert/hooke "1.3.0"
 scout "0.1.1"
 stencil "0.5.0"
 timofreiberg/bultitude "0.3.0"}
