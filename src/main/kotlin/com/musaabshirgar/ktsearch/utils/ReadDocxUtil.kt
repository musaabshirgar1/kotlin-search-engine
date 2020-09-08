package com.musaabshirgar.ktsearch.utils

import org.apache.poi.xwpf.usermodel.XWPFDocument
import java.io.File
import java.io.FileInputStream

object ReadDocxUtil {
    /**
     *  Function to read docx file
     */
    fun readDocxFile(fileName: String): String {
        var string = ""
        try {
            val file = File(fileName)
            val fis = FileInputStream(file.absolutePath)
            val document = XWPFDocument(fis)
            val paragraphsList = document.paragraphs
            for (para in paragraphsList) {
                string += para.text
            }
            fis.close()
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return string
    }
}