package com.musaabshirgar.ktsearch.app

import javafx.scene.text.FontWeight
import tornadofx.Stylesheet
import tornadofx.box
import tornadofx.cssclass
import tornadofx.px

class Styles : Stylesheet() {
    companion object {
        val heading by cssclass()
    }

    init {
        label and heading {
            padding = box(15.px)
            fontSize = 30.px
            fontWeight = FontWeight.BOLD
        }
    }
}