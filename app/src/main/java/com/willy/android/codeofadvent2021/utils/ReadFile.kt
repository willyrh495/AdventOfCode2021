package com.willy.android.codeofadvent2021.utils

import java.io.File

class ReadFile {

    companion object {

        fun read(fileName: String): String
                = File(fileName).readText(Charsets.UTF_8)
    }
}