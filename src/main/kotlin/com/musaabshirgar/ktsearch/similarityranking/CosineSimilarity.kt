package com.musaabshirgar.ktsearch.similarityranking

import com.musaabshirgar.ktsearch.model.Document
import javafx.collections.ObservableMap
import tornadofx.asObservable
import java.util.*
import kotlin.math.pow
import kotlin.math.sqrt


object CosineSimilarity {

    /**
     * Function to compute similarity of two vectors
     */
    private fun computeSimilarity(
        vectorA: DoubleArray,
        vectorB: DoubleArray
    ): Double {
        if (vectorA.size != vectorB.size) throw IllegalStateException(
            "Document Vectors Should Have The Same Length"
        )
        var dotProduct = 0.0
        var normA = 0.0
        var normB = 0.0
        for (i in vectorA.indices) {
            dotProduct += vectorA[i] * vectorB[i]
            normA += vectorA[i].pow(2.0)
            normB += vectorB[i].pow(2.0)
        }
        return dotProduct / (sqrt(normA) * sqrt(normB))
    }

    /**
     *  Function to Compute Similarity index of tfidf hashmap
     *  (returned from generateTfIdfHashMap function in TFIDF.kt).
     *  Returns a ObservableMap<Document, Double> in descending order
     */
    fun computeRankedDocuments(
        hashMap: Map<Document, DoubleArray>,
        queryDocument: Document
    ): ObservableMap<Document, Double> {
        val map = HashMap<Document, Double>()
        hashMap.forEach { (document, documentVector) ->
            if (document != queryDocument) {
                map[document] = computeSimilarity(
                    documentVector,
                    hashMap[queryDocument] ?: error("")
                )
            }
        }
        return map
            .toList().sortedByDescending { (_, value) -> value }
            .toMap()
            .asObservable()
    }
}