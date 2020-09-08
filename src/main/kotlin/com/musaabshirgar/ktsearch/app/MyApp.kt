package com.musaabshirgar.ktsearch.app

import com.musaabshirgar.ktsearch.view.MainView
import javafx.stage.Stage
import tornadofx.App

class MyApp: App(MainView::class, Styles::class) {
    override fun start(stage: Stage) {

        with(stage) {
            width = 1200.0
            height = 800.0
        }
        super.start(stage)
    }
}