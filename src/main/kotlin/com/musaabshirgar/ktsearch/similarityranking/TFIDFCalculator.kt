package com.musaabshirgar.ktsearch.similarityranking

import com.musaabshirgar.ktsearch.model.DocumentList
import com.musaabshirgar.ktsearch.model.StringList
import kotlin.math.log2

object TFIDFCalculator {

    /**
     *  Function to calculate TF of the given String List
     */
    private fun tf(
        doc: StringList,
        term: String
    ): Double {
        var result = 0.0
        for (word in doc) {
            if (term.equals(word, ignoreCase = true)) result++
        }
        return result / doc.size
    }

    /**
     *  Function to calculate IDF of the given DocumentList
     */
    private fun idf(
        docs: DocumentList,
        term: String
    ): Double {
        var n = 0.0
        for (doc in docs) {
            for (word in doc.wordList) {
                if (term.equals(word, ignoreCase = true)) {
                    n++
                    break
                }
            }
        }
        return log2(docs.size / n)
    }

    /**
     *  Function to calculate TF-IDF
     */
    fun tfIdf(
        doc: StringList,
        docs: DocumentList,
        term: String
    ): Double {
        return tf(doc, term) * idf(docs, term)
    }

}

