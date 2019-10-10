(ns app.components.circle
  (:require [re-frame.core :as rf]
            [app.utils.colors :as colors]))

(defn determine-content
  [is-winner? round-over?]
  (if (and is-winner? round-over?) "✔" ""))

(defn color-circle
  "A single, randomly colored circle. Subscribes to 
:chosen-color and :current-status."
  [color id]
  [:div
   {:style {:background-color color
            :color (colors/get-compliment color)
            :width "50px"
            :height "50px"
            :border-radius "100%"
            :line-height "50px"
            :text-align "center"
            :margin "10px"}
    :on-click #(rf/dispatch [:end-round])}
   (let [winner @(rf/subscribe [:chosen-color])
         round-over? (= @(rf/subscribe [:current-status]) :round-over)]
     (determine-content (= id winner) round-over?))])