;; (ns clojureApplet1.core)
;; Mon 21 Mar 2016 12:27:37 EST 
;; added to git as an example of java Interop - 
;; not finished or even working but a reminder to learn 
;; note -paint   , :extends   #^JApplet 

(ns applet
  (:import (java.awt Graphics Color Font RenderingHints)
           (javax.swing JApplet JButton))
  (:gen-class
     :extends javax.swing.JApplet))
 
(defn -paint [#^JApplet applet #^Graphics g]  ;type hint avoids Reflection, then it works without signing
  (let [width (.getWidth applet)
        height (.getHeight applet)]
    (doto g
      (.setColor (. Color YELLOW))
      (.fillRect 0 0 width height)
      (.setColor (. Color BLACK))
      (.drawRect 0 0 (dec width) (dec height))
      (.setFont (Font. "Serif" (. Font PLAIN) 24))
      (.drawString "Hello World!" 20 40))))
