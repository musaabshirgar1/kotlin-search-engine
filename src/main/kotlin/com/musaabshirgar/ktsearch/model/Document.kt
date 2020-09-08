package com.musaabshirgar.ktsearch.model

/**
 *  Data Class Document which contains Id and preprocessed wordList
 */
data class Document(
    val id: String,
    val wordList: StringList
)

/**
 *  Data Class Corpus which contains a list of Documents
 */
data class Corpus(
    val documents: DocumentList
)

/**
 *  Data Class ProcessedDocument which contains processedDocument and cosineSimilarity of the processed document.
 */
data class ProcessedDocument(
    val processedDocument: Document,
    val cosineSimilarity: Double
)


typealias DocumentList = MutableList<Document>
typealias StringList = List<String>
typealias ProcessedDocumentList = MutableList<ProcessedDocument>