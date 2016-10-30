(ns api.routes.tasks
  (:require
    [compojure.core :refer :all]
    [compojure.route :as route]
    [api.helpers.mysql :as db]
    [cheshire.core :refer :all]
    [api.helpers.jsonResponse :as JSONR]
    [clojure.java.jdbc :as j]))


(defn get-all []
 (def response (j/query db/connection ["select * from tasks"]))
  (JSONR/ok response))

(defn get-task [id]
  (def response (j/query db/connection ["select * from tasks where id = ?" id]))
  (JSONR/ok response))

(defn create-task [body]
  (def response (j/insert-multi! db/connection :tasks [(parse-string  body)]))
  (JSONR/ok response))

(defn update-task [id body]
  (def response (j/update! db/connection  :tasks (parse-string body) ["id=?" id]))
  (JSONR/ok response))

(defn delete-task [id]
  (def response (j/delete! db/connection :tasks ["id=?" id]))
  (JSONR/ok response))

(def task-routes
  (routes
    (GET  "/" [] (get-all))
    (POST "/" {body :body} (create-task (slurp body)))
    (context "/:id" [id] (routes
      (GET    "/" [] (get-task id))
      (PUT    "/" {body :body} (update-task id (slurp body)))
      (DELETE "/" [] (delete-task id))))))
