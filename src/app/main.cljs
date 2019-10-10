(ns app.main
  (:require [reagent.core :as reagent]
            [re-frame.core :as rf]
            [app.utils.colors :as colors]
            [app.components.circle :as circle]))

;; A detailed walk-through of this source code is provided in the docs:
;; https://github.com/Day8/re-frame/blob/master/docs/CodeWalkthrough.md


;; -- Domino 2 - Event Handlers -----------------------------------------------

(rf/reg-event-db
 :reset
 (fn [_ _]
   {:colors (take 20 (repeatedly colors/rand-color))
    :chosen (rand-int 20)
    :status :new-round}))

(rf/reg-event-db
 :end-round
 (fn [db _]
   (assoc db :status :round-over)))

;; -- Domino 4 - Query  -------------------------------------------------------

(rf/reg-sub
  :colors
  (fn [db _]     ;; db is current app state. 2nd unused param is query vector
    (:colors db))) ;; return a query computation over the application state

(rf/reg-sub
 :chosen-color
 (fn [db _]
   (:chosen db)))

(rf/reg-sub
  :current-status
  (fn [db _]
    (:status db)))


;; -- Domino 5 - View Functions ----------------------------------------------

(defn color-grid
  "return an grid of colored circles with random colors"
  []
  [:div
   {:style
    {:display "flex"
     :flex-wrap "wrap"
     :width "500px"}}
   (for [[id color] (map-indexed vector @(rf/subscribe [:colors]))]
     [circle/color-circle color id])])

(defn ui
  []
  [:div
   [:h1 "Hexual 2.0"]
   [:h2 (nth @(rf/subscribe [:colors]) @(rf/subscribe [:chosen-color]))]
   [:button {:style {:display (if (= @(rf/subscribe [:current-status]) :round-over) "inline-block" "none")}
             :on-click #(rf/dispatch [:reset])}
    "New round"]
   [color-grid]])

;; -- Entry Point -------------------------------------------------------------

(defn main!
  []
  (rf/dispatch-sync [:reset])     ;; puts a value into application state
  (reagent/render [ui]              ;; mount the application's ui into '<div id="app" />'
                  (js/document.getElementById "app"))
  (println "App Loaded"))

(defn reload!
  []
  (println "Reloaded.")
  (main!))
