(ns helpers.mongo
  (:require [monger.core :as mg])
  (:import [com.mongodb MongoOptions ServerAddress]
           (com.sun.corba.se.spi.ior ObjectId)))

(let [uri               "mongodb://127.0.0.1/monger-test4"
      {:keys [conn db]} (mg/connect-via-uri uri)])

;
;(mc/insert-and-return db "documents" {:name "John" :age 30})
;
;;; with explicit document id (recommended)
;(mc/insert db "documents" {:_id (ObjectId.) :first_name "John" :last_name "Lennon"})
;
;;; multiple documents at once
;(mc/insert-batch db "documents" [{ :first_name "John" :last_name "Lennon" }
;                                 { :first_name "Paul" :last_name "McCartney" }])
;
;;; without document id (when you don't need to use it after storing the document)
;(mc/insert db "documents" { :first_name "John" :last_name "Lennon" })
;
;;; with a different write concern
;(mc/insert db "documents" { :_id (ObjectId.) :first_name "John" :last_name "Lennon" } WriteConcern/JOURNAL_SAFE))