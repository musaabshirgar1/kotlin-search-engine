package com.musaabshirgar.ktsearch.similarityranking

import com.musaabshirgar.ktsearch.similarityranking.TFIDFCalculator.tfIdf
import com.musaabshirgar.ktsearch.model.Corpus
import com.musaabshirgar.ktsearch.model.Document
import javafx.collections.ObservableMap
import tornadofx.asObservable

object TFIDF {


    /**
     *  Function to generate TFIDF Vector for all the documents in the Corpus.
     *  Returns a ObservableMap<Document, DoubleArray>
     */
    fun generateTFIDFHashMap(
        corpus: Corpus,
        vocabulary: MutableSet<String>
    ): ObservableMap<Document, DoubleArray> {
        val vocabularyList = vocabulary.toMutableList()
        val vocabularySize = vocabularyList.size
        val hashmap = HashMap<Document, DoubleArray>()
        corpus.documents.forEach { document ->
            val processedDocument = document.wordList
            val documentVector = DoubleArray(vocabularySize)
            vocabularyList.indices.forEach { i ->
                val word = vocabularyList[i]
                if (processedDocument.contains(word)) {
                    documentVector[i] = tfIdf(processedDocument, corpus.documents, word)
                } else {
                    documentVector[i] = 0.0
                }
            }
            hashmap[document] = documentVector
        }
        return hashmap.asObservable()
    }
}