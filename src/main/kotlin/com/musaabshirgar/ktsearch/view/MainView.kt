package com.musaabshirgar.ktsearch.view

import com.musaabshirgar.ktsearch.controllers.SearchController
import javafx.beans.property.SimpleStringProperty
import javafx.geometry.Pos
import javafx.scene.paint.Color
import javafx.scene.text.FontWeight
import tornadofx.*

class MainView : View() {

    private val model = ViewModel()
    private val inputQuery = model.bind { SimpleStringProperty() }
    private val searchController: SearchController by inject()

    override val root = borderpane {
        style {
            backgroundColor += Color.WHITE
        }
        bottom = listview(searchController.processedDocumentListProperty.value) {
            cellFormat { processedDocument ->
                style {
                    padding = box(15.px)
                    backgroundColor += Color.WHITE
                    borderColor += box(
                        top = Color.RED,
                        right = Color.DARKGREEN,
                        left = Color.ORANGE,
                        bottom = Color.PURPLE
                    )
                }
                graphic = vbox {
                    hbox {
                        alignment = Pos.TOP_LEFT
                        spacing = 10.0
                        label("Document Id: ") {
                            style {
                                fontSize = 15.px
                                fontWeight = FontWeight.BOLD
                            }
                        }
                        label(processedDocument.processedDocument.id) {
                            style {
                                fontSize = 15.px
                                fontWeight = FontWeight.MEDIUM
                            }
                        }
                    }
                    hbox {
                        alignment = Pos.TOP_LEFT
                        spacing = 10.0
                        label("Processed Document: ") {
                            style {
                                fontSize = 15.px
                                fontWeight = FontWeight.BOLD
                            }
                        }
                        label(processedDocument.processedDocument.wordList.toString()) {
                            style {
                                fontSize = 15.px
                                fontWeight = FontWeight.MEDIUM
                            }
                        }
                    }
                    hbox {
                        alignment = Pos.TOP_LEFT
                        spacing = 10.0
                        label("Cosine Similarity:") {
                            style {
                                fontSize = 15.px
                                fontWeight = FontWeight.BOLD
                            }
                        }
                        label(processedDocument.cosineSimilarity.toString()) {
                            style {
                                fontSize = 15.px
                                fontWeight = FontWeight.MEDIUM
                            }
                        }
                    }
                }
            }
        }
        center = vbox {
            alignment = Pos.CENTER
            spacing = 20.0
            label("kSearch") {
                style {
                    padding = box(15.px)
                    fontSize = 30.px
                    fontWeight = FontWeight.BOLD
                    borderColor += box(
                        top = Color.RED,
                        right = Color.DARKGREEN,
                        left = Color.ORANGE,
                        bottom = Color.PURPLE
                    )
                }
            }
            hbox {
                alignment = Pos.CENTER
                textfield(inputQuery) {
                    required()
                    promptText = "Search Here"
                    parent.requestFocus()
                    style {
                        fontWeight = FontWeight.EXTRA_BOLD
                        borderColor += box(
                            top = Color.RED,
                            right = Color.DARKGREEN,
                            left = Color.ORANGE,
                            bottom = Color.PURPLE
                        )
                    }
                }
            }
            hbox {
                alignment = Pos.CENTER
                button("Search") {
                    style {
                        backgroundColor += Color.ANTIQUEWHITE
                        borderColor += box(
                            top = Color.RED,
                            right = Color.DARKGREEN,
                            left = Color.ORANGE,
                            bottom = Color.PURPLE
                        )
                    }
                    enableWhen(model.valid)
                    isDefaultButton = true
                    action {
                        runAsyncWithProgress {
                            searchController.search(inputQuery.value)
                        }
                    }
                }
            }
        }
    }
}