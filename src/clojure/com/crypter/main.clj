(ns com.crypter.main
  (:use [neko.activity :only [defactivity set-content-view!]]
        [neko.threading :only [on-ui]]
        [neko.ui :only [make-ui]]))

(defactivity com.crypter.MainActivity
  :def a
  :on-create
  (fn [this bundle]
    (on-ui
     (set-content-view! a
      (make-ui [:linear-layout {:orientation :vertical
                                :gravity :center}
                [:text-view {:text "Crypter Application"}]
                [:text-view {:text "by Veljko Bogosavljevic"}]])))))
