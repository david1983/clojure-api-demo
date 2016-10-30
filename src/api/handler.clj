(ns api.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [api.helpers.jsonResponse :as JSONR]
            [api.routes.tasks :as tasks]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]))

(defroutes app-routes
           (context "/tasks" [] tasks/task-routes)
           (route/not-found (JSONR/NotFound {:error "Not Found"})))

(def app app-routes)
