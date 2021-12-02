package com.willy.android.codeofadvent2021

import com.willy.android.codeofadvent2021.utils.ReadFile

class Day1 {

    fun countDepthMeasurements() {
        val data = ReadFile.read("src/day1sample").split("\n")

        var increasedDepthMeasurements = 0
        for (i in data.indices) {
            if (i > 0) {
                if (data[i].toInt() > data[i - 1].toInt())
                    increasedDepthMeasurements++
            }
        }
        println(increasedDepthMeasurements)
    }

    fun countDepthMeasurementsPart2() {
        val data = ReadFile.read("src/day1part2sample").split("\n")
        val dataWithMeasurementWindows = buildMeasurementWindows(data.toMutableList())

        val depthsByLetter = mutableMapOf<String, Int>()

        dataWithMeasurementWindows.forEach { depthInput ->
            val entryDepthInput = depthInput.split(" ")

            for (i in entryDepthInput.indices) {
                if (i > 0) {
                    if (depthsByLetter.containsKey(entryDepthInput[i])) {
                        val depthSum = depthsByLetter[entryDepthInput[i]]!!.toInt()
                        depthsByLetter[entryDepthInput[i]] =
                            depthSum + entryDepthInput.first().toInt()
                    } else {
                        depthsByLetter[entryDepthInput[i]] = entryDepthInput.first().toInt()
                    }
                }
            }
        }

        countIncreasedDepthMap(depthsByLetter)
    }

    private fun buildMeasurementWindows(data: MutableList<String>): List<String> {
        val windowSize = 3
        var index = 0
        var windowIndex = 0

        var depthKey = 'A'

        while (index < data.size) {
            if (index == 0) {
                while (windowIndex < windowSize) {
                    data[windowIndex] = "${data[windowIndex]} $depthKey"
                    windowIndex++
                }
                depthKey++
            } else {
                windowIndex = index
                val maxPositionForWindow = index + (windowSize - 1)
                if (maxPositionForWindow < data.size) {
                    while (windowIndex <= maxPositionForWindow) {
                        data[windowIndex] = "${data[windowIndex]} $depthKey"
                        windowIndex++
                    }
                    depthKey++
                }
            }
            index++
        }
        return data
    }

    private fun countIncreasedDepthMap(map: Map<String, Int>) {
        var increasedDepthMeasurements = 0
        val listOfSumDepths = map.values.toList()
        for (i in listOfSumDepths.indices) {
            if (i > 0) {
                if (listOfSumDepths[i] > listOfSumDepths[i - 1])
                    increasedDepthMeasurements++
            }
        }
        println(increasedDepthMeasurements)
    }
}