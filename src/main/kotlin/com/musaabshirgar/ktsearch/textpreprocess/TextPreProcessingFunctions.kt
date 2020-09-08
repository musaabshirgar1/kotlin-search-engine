package com.musaabshirgar.ktsearch.textpreprocess


import com.musaabshirgar.ktsearch.model.Corpus
import com.musaabshirgar.ktsearch.model.StringList
import com.musaabshirgar.ktsearch.utils.StopWords
import opennlp.tools.lemmatizer.DictionaryLemmatizer
import opennlp.tools.postag.POSModel
import opennlp.tools.postag.POSTaggerME
import opennlp.tools.stemmer.PorterStemmer
import opennlp.tools.stemmer.snowball.SnowballStemmer
import opennlp.tools.tokenize.SimpleTokenizer
import opennlp.tools.tokenize.TokenizerME
import opennlp.tools.tokenize.TokenizerModel
import opennlp.tools.tokenize.WhitespaceTokenizer
import java.io.FileInputStream
import java.io.InputStream

/**
 *  Singleton class which contains all the important text pre processing methods
 */
object TextPreProcessingFunctions {

    private var posModelIn = FileInputStream("opennlpmodels/en-pos-maxent.bin")
    private var dictLemmatizer = FileInputStream("opennlpmodels/en-lemmatizer.dict")
    private var posModel: POSModel
    private var posTagger: POSTaggerME
    private var lemmatizer: DictionaryLemmatizer

    init {
        posModel = POSModel(posModelIn)
        posTagger = POSTaggerME(posModel)
        lemmatizer = DictionaryLemmatizer(dictLemmatizer)
    }

    private fun openNLPSimpleTokenizer(
        string: String
    ): StringList {
        val simpleTokenizer = SimpleTokenizer.INSTANCE
        return simpleTokenizer.tokenize(string).toList()
    }

    private fun openNLPWhiteSpaceTokenizer(
        string: String
    ): StringList {
        val whiteSpaceTokenizer = WhitespaceTokenizer.INSTANCE
        return whiteSpaceTokenizer.tokenize(string).toList()
    }

    private fun openNLPTokenizerME(
        string: String
    ): StringList {
        val inputStream: InputStream = FileInputStream("opennlpmodels/en-token.bin")
        val tokenModel = TokenizerModel(inputStream)
        val tokenizer = TokenizerME(tokenModel)
        return tokenizer.tokenize(string).toList()
    }

    private fun postPunctuation(
        list: StringList
    ): StringList {
        val re = Regex("[^A-Za-z0-9 ]")
        val result: MutableList<String> = mutableListOf()
        list.forEach {
            result.add(re.replace(it, "").toLowerCase())
        }
        return result
    }

    private fun removeStopWords(
        list: StringList
    ): StringList {
        val resultList: MutableList<String> = mutableListOf()
        val stopWords = StopWords()
        list.forEach {
            if (stopWords.isStopWord(it)) return@forEach
            resultList.add(it)
        }
        return resultList
    }

    private fun openNLPPorterStemmer(
        list: StringList
    ): StringList {
        val resultList: MutableList<String> = mutableListOf()
        val porterStemmer = PorterStemmer()
        list.forEach {
            resultList.add(porterStemmer.stem(it))
        }
        return resultList
    }

    private fun openNLPSnowBallStemmer(
        list: StringList
    ): StringList {
        val resultList: MutableList<String> = mutableListOf()
        val snowballStemmer = SnowballStemmer(SnowballStemmer.ALGORITHM.ENGLISH)
        list.forEach {
            resultList.add(snowballStemmer.stem(it).toString())
        }
        return resultList
    }

    private fun openNLPLemmatizer(
        list: StringList
    ): StringList {
        val resultList: MutableList<String> = mutableListOf()
        val tokens = list.toTypedArray()
        val tags = posTagger.tag(tokens)
        val lemmas = lemmatizer.lemmatize(tokens, tags)
        lemmas.indices.forEach { i ->
            if (lemmas[i] == "O") {
                resultList.add(tokens[i])
            } else {
                resultList.add(lemmas[i])
            }
        }
        return resultList
    }


    private fun caseConversion(
        list: List<String>
    ): StringList {
        val resultList: MutableList<String> = mutableListOf()
        list.forEach {
            resultList.add(it.toLowerCase())
        }
        return resultList
    }

    /**
     *  Function to Pre Process A String
     */
    fun textPreProcess(
        string: String
    ): StringList {
        return openNLPPorterStemmer(
            caseConversion(
                removeStopWords(
                    postPunctuation(
                        openNLPWhiteSpaceTokenizer(string)
                    )
                )
            )
        )
    }

    /**
     *  Function to generate a vocabulary based on the corpus
     */
    fun generateVocabulary(
        corpus: Corpus
    ): MutableSet<String> {
        val mutableSet: MutableSet<String> = mutableSetOf()
        corpus.documents.forEach { document ->
            document.wordList.forEach { word ->
                mutableSet.add(word)
            }
        }
        return mutableSet.sortedBy { value -> value }.toMutableSet()
    }
}
