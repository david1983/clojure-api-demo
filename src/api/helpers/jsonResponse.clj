(ns api.helpers.jsonResponse
  (:require [cheshire.core :refer :all]))


(defn res [status raw-response]
  {:status 200
   :headers {"Content-Type" "application/json"}
   :body (generate-string  raw-response)})

(defn ok [raw-response]
  {:status 200
   :headers {"Content-Type" "application/json"}
   :body (generate-string  raw-response)})

(defn BadRquest [raw-response]
  {:status 400
   :headers {"Content-Type" "application/json"}
   :body (generate-string  raw-response)})

(defn NotFound [raw-response]
  {:status 404
   :headers {"Content-Type" "application/json"}
   :body (generate-string  raw-response)})

(defn Unauthorized [raw-response]
  {:status 401
   :headers {"Content-Type" "application/json"}
   :body (generate-string  raw-response)})

(defn Forbidden [raw-response]
  {:status 403
   :headers {"Content-Type" "application/json"}
   :body (generate-string  raw-response)})

(defn InternalServerError [raw-response]
  {:status 500
   :headers {"Content-Type" "application/json"}
   :body (generate-string  raw-response)})
