(ns fileupload.core
    (:use [net.cgrand.enlive-html
              :only [deftemplate defsnippet content clone-for
                     nth-of-type first-child do-> set-attr sniptest at emit*]]
          [compojure.core]
          [ring.adapter.jetty])
    (:require (compojure [route :as route])
            (ring.util [response :as response])
            (ring.middleware [multipart-params :as mp])
            (clojure.contrib [duck-streams :as ds]))
    (:gen-class))

(defn render [t]
      (apply str t))

(deftemplate index "fileupload/index.html" [])
(deftemplate upload-success "fileupload/success.html" [])

(defn upload-file
  [file]
  (ds/copy (file :tempfile) (ds/file-str "file.out"))
  (render (upload-success)))

(defroutes public-routes
            (GET  "/" [] (render (index)))
            (mp/wrap-multipart-params 
              (POST "/file" {params :params} (upload-file (get params "file")))))

(defn start-app []
      (future (run-jetty (var public-routes) {:port 8000})))