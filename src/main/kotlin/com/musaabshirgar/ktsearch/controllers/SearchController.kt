package com.musaabshirgar.ktsearch.controllers

import com.musaabshirgar.ktsearch.model.Corpus
import com.musaabshirgar.ktsearch.model.Document
import com.musaabshirgar.ktsearch.model.ProcessedDocument
import com.musaabshirgar.ktsearch.model.ProcessedDocumentList
import com.musaabshirgar.ktsearch.similarityranking.CosineSimilarity
import com.musaabshirgar.ktsearch.similarityranking.TFIDF
import com.musaabshirgar.ktsearch.textpreprocess.TextPreProcessingFunctions
import com.musaabshirgar.ktsearch.utils.AppUtils.precision
import com.musaabshirgar.ktsearch.utils.ReadDocxUtil
import javafx.beans.property.SimpleListProperty
import javafx.beans.property.SimpleObjectProperty
import tornadofx.*
import kotlin.collections.component1
import kotlin.collections.component2

class SearchController : Controller() {

    val processedDocumentListProperty = SimpleObjectProperty(
        SimpleListProperty<ProcessedDocument>()
    )
    private var processedDocumentList: SimpleListProperty<ProcessedDocument> by processedDocumentListProperty

    private val doc1Text = ReadDocxUtil.readDocxFile("corpus/Doc1.docx")
    private val doc2Text = ReadDocxUtil.readDocxFile("corpus/Doc2.docx")
    private val doc3Text = ReadDocxUtil.readDocxFile("corpus/Doc3.docx")
    private val doc4Text = ReadDocxUtil.readDocxFile("corpus/Doc4.docx")
    private val doc5Text = ReadDocxUtil.readDocxFile("corpus/Doc5.docx")
    private val doc6Text = ReadDocxUtil.readDocxFile("corpus/Doc6.docx")
    private val doc7Text = ReadDocxUtil.readDocxFile("corpus/Doc7.docx")
    private val doc8Text = ReadDocxUtil.readDocxFile("corpus/Doc8.docx")
    private val doc9Text = ReadDocxUtil.readDocxFile("corpus/Doc9.docx")
    private val doc10Text = ReadDocxUtil.readDocxFile("corpus/Doc10.docx")
    private val doc11Text = ReadDocxUtil.readDocxFile("corpus/Doc11.docx")
    private val doc12Text = ReadDocxUtil.readDocxFile("corpus/Doc12.docx")
    private val doc13Text = ReadDocxUtil.readDocxFile("corpus/Doc13.docx")
    private val doc14Text = ReadDocxUtil.readDocxFile("corpus/Doc14.docx")
    private val doc15Text = ReadDocxUtil.readDocxFile("corpus/Doc15.docx")
    private val doc16Text = ReadDocxUtil.readDocxFile("corpus/Doc16.docx")
    private val doc17Text = ReadDocxUtil.readDocxFile("corpus/Doc17.docx")
    private val doc18Text = ReadDocxUtil.readDocxFile("corpus/Doc18.docx")
    private val doc19Text = ReadDocxUtil.readDocxFile("corpus/Doc19.docx")
    private val doc20Text = ReadDocxUtil.readDocxFile("corpus/Doc20.docx")
    private val doc21Text = ReadDocxUtil.readDocxFile("corpus/Doc21.docx")
    private val doc22Text = ReadDocxUtil.readDocxFile("corpus/Doc22.docx")
    private val doc23Text = ReadDocxUtil.readDocxFile("corpus/Doc23.docx")
    private val doc24Text = ReadDocxUtil.readDocxFile("corpus/Doc24.docx")
    private val doc25Text = ReadDocxUtil.readDocxFile("corpus/Doc25.docx")
    private val doc26Text = ReadDocxUtil.readDocxFile("corpus/Doc26.docx")
    private val doc27Text = ReadDocxUtil.readDocxFile("corpus/Doc27.docx")
    private val doc28Text = ReadDocxUtil.readDocxFile("corpus/Doc28.docx")
    private val doc29Text = ReadDocxUtil.readDocxFile("corpus/Doc29.docx")
    private val doc30Text = ReadDocxUtil.readDocxFile("corpus/Doc30.docx")
    private val doc31Text = ReadDocxUtil.readDocxFile("corpus/Doc31.docx")
    private val doc32Text = ReadDocxUtil.readDocxFile("corpus/Doc32.docx")
    private val doc33Text = ReadDocxUtil.readDocxFile("corpus/Doc33.docx")
    private val doc34Text = ReadDocxUtil.readDocxFile("corpus/Doc34.docx")
    private val doc35Text = ReadDocxUtil.readDocxFile("corpus/Doc35.docx")
    private val doc36Text = ReadDocxUtil.readDocxFile("corpus/Doc36.docx")
    private val doc37Text = ReadDocxUtil.readDocxFile("corpus/Doc37.docx")
    private val doc38Text = ReadDocxUtil.readDocxFile("corpus/Doc38.docx")
    private val doc39Text = ReadDocxUtil.readDocxFile("corpus/Doc39.docx")
    private val doc40Text = ReadDocxUtil.readDocxFile("corpus/Doc40.docx")

    private val textPreProcessDoc1List = TextPreProcessingFunctions.textPreProcess(doc1Text)
    private val textPreProcessDoc2List = TextPreProcessingFunctions.textPreProcess(doc2Text)
    private val textPreProcessDoc3List = TextPreProcessingFunctions.textPreProcess(doc3Text)
    private val textPreProcessDoc4List = TextPreProcessingFunctions.textPreProcess(doc4Text)
    private val textPreProcessDoc5List = TextPreProcessingFunctions.textPreProcess(doc5Text)
    private val textPreProcessDoc6List = TextPreProcessingFunctions.textPreProcess(doc6Text)
    private val textPreProcessDoc7List = TextPreProcessingFunctions.textPreProcess(doc7Text)
    private val textPreProcessDoc8List = TextPreProcessingFunctions.textPreProcess(doc8Text)
    private val textPreProcessDoc9List = TextPreProcessingFunctions.textPreProcess(doc9Text)
    private val textPreProcessDoc10List = TextPreProcessingFunctions.textPreProcess(doc10Text)
    private val textPreProcessDoc11List = TextPreProcessingFunctions.textPreProcess(doc11Text)
    private val textPreProcessDoc12List = TextPreProcessingFunctions.textPreProcess(doc12Text)
    private val textPreProcessDoc13List = TextPreProcessingFunctions.textPreProcess(doc13Text)
    private val textPreProcessDoc14List = TextPreProcessingFunctions.textPreProcess(doc14Text)
    private val textPreProcessDoc15List = TextPreProcessingFunctions.textPreProcess(doc15Text)
    private val textPreProcessDoc16List = TextPreProcessingFunctions.textPreProcess(doc16Text)
    private val textPreProcessDoc17List = TextPreProcessingFunctions.textPreProcess(doc17Text)
    private val textPreProcessDoc18List = TextPreProcessingFunctions.textPreProcess(doc18Text)
    private val textPreProcessDoc19List = TextPreProcessingFunctions.textPreProcess(doc19Text)
    private val textPreProcessDoc20List = TextPreProcessingFunctions.textPreProcess(doc20Text)
    private val textPreProcessDoc21List = TextPreProcessingFunctions.textPreProcess(doc21Text)
    private val textPreProcessDoc22List = TextPreProcessingFunctions.textPreProcess(doc22Text)
    private val textPreProcessDoc23List = TextPreProcessingFunctions.textPreProcess(doc23Text)
    private val textPreProcessDoc24List = TextPreProcessingFunctions.textPreProcess(doc24Text)
    private val textPreProcessDoc25List = TextPreProcessingFunctions.textPreProcess(doc25Text)
    private val textPreProcessDoc26List = TextPreProcessingFunctions.textPreProcess(doc26Text)
    private val textPreProcessDoc27List = TextPreProcessingFunctions.textPreProcess(doc27Text)
    private val textPreProcessDoc28List = TextPreProcessingFunctions.textPreProcess(doc28Text)
    private val textPreProcessDoc29List = TextPreProcessingFunctions.textPreProcess(doc29Text)
    private val textPreProcessDoc30List = TextPreProcessingFunctions.textPreProcess(doc30Text)
    private val textPreProcessDoc31List = TextPreProcessingFunctions.textPreProcess(doc31Text)
    private val textPreProcessDoc32List = TextPreProcessingFunctions.textPreProcess(doc32Text)
    private val textPreProcessDoc33List = TextPreProcessingFunctions.textPreProcess(doc33Text)
    private val textPreProcessDoc34List = TextPreProcessingFunctions.textPreProcess(doc34Text)
    private val textPreProcessDoc35List = TextPreProcessingFunctions.textPreProcess(doc35Text)
    private val textPreProcessDoc36List = TextPreProcessingFunctions.textPreProcess(doc36Text)
    private val textPreProcessDoc37List = TextPreProcessingFunctions.textPreProcess(doc37Text)
    private val textPreProcessDoc38List = TextPreProcessingFunctions.textPreProcess(doc38Text)
    private val textPreProcessDoc39List = TextPreProcessingFunctions.textPreProcess(doc39Text)
    private val textPreProcessDoc40List = TextPreProcessingFunctions.textPreProcess(doc40Text)

    private val document1 = Document(
        id = "Doc1",
        wordList = textPreProcessDoc1List
    )
    private val document2 = Document(
        id = "Doc2",
        wordList = textPreProcessDoc2List
    )
    private val document3 = Document(
        id = "Doc3",
        wordList = textPreProcessDoc3List
    )
    private val document4 = Document(
        id = "Doc4",
        wordList = textPreProcessDoc4List
    )
    private val document5 = Document(
        id = "Doc5",
        wordList = textPreProcessDoc5List
    )

    private val document6 = Document(
        id = "Doc6",
        wordList = textPreProcessDoc6List
    )
    private val document7 = Document(
        id = "Doc7",
        wordList = textPreProcessDoc7List
    )
    private val document8 = Document(
        id = "Doc8",
        wordList = textPreProcessDoc8List
    )
    private val document9 = Document(
        id = "Doc9",
        wordList = textPreProcessDoc9List
    )
    private val document10 = Document(
        id = "Doc10",
        wordList = textPreProcessDoc10List
    )

    private val document11 = Document(
        id = "Doc11",
        wordList = textPreProcessDoc11List
    )
    private val document12 = Document(
        id = "Doc12",
        wordList = textPreProcessDoc12List
    )
    private val document13 = Document(
        id = "Doc13",
        wordList = textPreProcessDoc13List
    )
    private val document14 = Document(
        id = "Doc14",
        wordList = textPreProcessDoc14List
    )
    private val document15 = Document(
        id = "Doc15",
        wordList = textPreProcessDoc15List
    )

    private val document16 = Document(
        id = "Doc16",
        wordList = textPreProcessDoc16List
    )
    private val document17 = Document(
        id = "Doc17",
        wordList = textPreProcessDoc17List
    )
    private val document18 = Document(
        id = "Doc18",
        wordList = textPreProcessDoc18List
    )
    private val document19 = Document(
        id = "Doc19",
        wordList = textPreProcessDoc19List
    )
    private val document20 = Document(
        id = "Doc20",
        wordList = textPreProcessDoc20List
    )

    private val document21 = Document(
        id = "Doc21",
        wordList = textPreProcessDoc21List
    )
    private val document22 = Document(
        id = "Doc22",
        wordList = textPreProcessDoc22List
    )
    private val document23 = Document(
        id = "Doc23",
        wordList = textPreProcessDoc23List
    )
    private val document24 = Document(
        id = "Doc24",
        wordList = textPreProcessDoc24List
    )
    private val document25 = Document(
        id = "Doc25",
        wordList = textPreProcessDoc25List
    )

    private val document26 = Document(
        id = "Doc26",
        wordList = textPreProcessDoc26List
    )
    private val document27 = Document(
        id = "Doc27",
        wordList = textPreProcessDoc27List
    )
    private val document28 = Document(
        id = "Doc28",
        wordList = textPreProcessDoc28List
    )
    private val document29 = Document(
        id = "Doc29",
        wordList = textPreProcessDoc29List
    )
    private val document30 = Document(
        id = "Doc30",
        wordList = textPreProcessDoc30List
    )

    private val document31 = Document(
        id = "Doc31",
        wordList = textPreProcessDoc31List
    )
    private val document32 = Document(
        id = "Doc32",
        wordList = textPreProcessDoc32List
    )
    private val document33 = Document(
        id = "Doc33",
        wordList = textPreProcessDoc33List
    )
    private val document34 = Document(
        id = "Doc34",
        wordList = textPreProcessDoc34List
    )
    private val document35 = Document(
        id = "Doc35",
        wordList = textPreProcessDoc35List
    )

    private val document36 = Document(
        id = "Doc36",
        wordList = textPreProcessDoc36List
    )
    private val document37 = Document(
        id = "Doc37",
        wordList = textPreProcessDoc37List
    )
    private val document38 = Document(
        id = "Doc38",
        wordList = textPreProcessDoc38List
    )
    private val document39 = Document(
        id = "Doc39",
        wordList = textPreProcessDoc39List
    )
    private val document40 = Document(
        id = "Doc40",
        wordList = textPreProcessDoc40List
    )

    /**
     *  Function to generate a corpus
     */
    private fun createCorpus(queryDocument: Document): Corpus {
        return Corpus(
            documents = listOf(
                document1,
                document2,
                document3,
                document4,
                document5,
                document6,
                document7,
                document8,
                document9,
                document10,
                document11,
                document12,
                document13,
                document14,
                document15,
                document16,
                document17,
                document18,
                document19,
                document20,
                document21,
                document22,
                document23,
                document24,
                document25,
                document26,
                document27,
                document28,
                document29,
                document30,
                document31,
                document32,
                document33,
                document34,
                document35,
                document36,
                document37,
                document38,
                document39,
                document40,
                queryDocument,
            ).asObservable()
        )
    }

    /**
     *  Function which takes input query as a parameter and
     *  displays output in MainView.kt
     */
    fun search(inputValue: String) {
        runLater {
            processedDocumentList.value = emptyList<ProcessedDocument>().asObservable()
        }

        /**
         * Perform Text Pre Processing on Query Term
         */
        val queryTextPreProcess = TextPreProcessingFunctions.textPreProcess(inputValue)
        val queryDocument = Document(
            id = "query",
            wordList = queryTextPreProcess
        )

        /**
         *  Create a corpus
         */
        val corpus = createCorpus(queryDocument)

        /**
         * Generate Vocabulary
         */
        val vocabulary = TextPreProcessingFunctions
            .generateVocabulary(corpus)

        /**
         *  Generate a tfIdfHashmap using corpus and vocabulary
         */
        val tfIdfHashMap = TFIDF
            .generateTFIDFHashMap(
                corpus,
                vocabulary
            )

        /**
         *  Generate Ranked Documents Map using tfIdfHasMap and queryDocument
         */
        val rankedDocumentsMap = CosineSimilarity
            .computeRankedDocuments(
                tfIdfHashMap,
                queryDocument
            )

        runLater {
            val resultList: ProcessedDocumentList = mutableListOf()
            rankedDocumentsMap.forEach { (key, value) ->
                if (value != 0.0) {
                    resultList.add(
                        ProcessedDocument(
                            processedDocument = key,
                            cosineSimilarity = value.precision
                        )
                    )
                }
            }
            processedDocumentList.value = resultList.asObservable()
        }
    }
}