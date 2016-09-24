package com.example

import scalafx.Includes._
import scalafx.application.JFXApp
import scalafx.scene.Scene
import scalafx.scene.control.Button
import scalafx.scene.input.MouseEvent
import scalafx.scene.layout.VBox
import scalafx.scene.web.WebView

/**
  * Created by hiro on 2016/09/24.
  */
class GuiApp extends JFXApp {
  stage = new JFXApp.PrimaryStage {
    title = "Hello ScalaFX"
    width = 800
    height = 600
    scene = new Scene {
      root = new VBox {
        val browser: WebView = new WebView

        val bt = new Button("Hello World") {
          onMouseClicked = handle {
            println("Clicked!")
            browser.engine.load("http://google.com")
          }

          onMouseReleased = (t: MouseEvent) => println("Released!")
        }

        children += browser
        children += bt
      }
    }
  }

}

