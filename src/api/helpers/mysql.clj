(ns api.helpers.mysql
  (require [clojure.java.jdbc :as j]))

;; you can also specify a full connection string if you'd prefer:
(def connection
  {:connection-uri (str "jdbc:mysql://127.0.0.1:3306/tasks"
                        "?user=root&password=q1w2e3&zeroDateTimeBehavior=convertToNull")})
;
;(j/insert-multi! mysql-db :fruit
;                 [{:name "Apple" :appearance "rosy" :cost 24}
;                  {:name "Orange" :appearance "round" :cost 49}])
;; ({:generated_key 1} {:generated_key 2})

;(j/query mysql-db
;         ["select * from fruit where appearance = ?" "rosy"]
;         {:row-fn :cost})
;; (24)