(ns com.crypter.main
  (:use [neko.activity :only [defactivity set-content-view!]]
        [neko.threading :only [on-ui]]
        [neko.ui :only [make-ui]]
        [neko.notify])
  (:import android.widget.EditText
           android.content.Intent
           android.widget.Toast))

(declare exit-application login-notification)


(def main-layout [:linear-layout {:orientation :vertical
                                  :gravity :center
                                  :id-holder true}
                  [:edit-text {:hint "Username"
                               :id ::username}]
                  [:edit-text {:hint "Password"
                               :id ::password}]
                  [:linear-layout {:orientation :horizontal
                                  :gravity :center
                                  :id-holder true}
                   [:button {:text "Login"
                             :on-click (fn [_] (login-notification))}]
                   [:button {:text "Exit"
                             :on-click (fn [_] (exit-application))}]]])


(defactivity com.crypter.MainActivity
  :def a
  :on-create
  (fn [this bundle]
    (on-ui
     (set-content-view! a
      (make-ui main-layout)))))

(defn exit-application []
  (.finish a))


 (defn login-notification []
  (fire :mynotification
      (notification :icon com.crypter.R$drawable/ic_launcher
                    :ticker-text "Crypter - Login successful !"
                    :content-title "Crypter"
                    :content-text "Login successful !"
                    :action [:activity Intent/CATEGORY_HOME])))

; (exit-application)
; (.startActivity a (.getIntent a))
