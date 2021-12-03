package com.willy.android.codeofadvent2021

import com.willy.android.codeofadvent2021.utils.ReadFile

class Day2 {

    fun calculateTrajectory() {
        val data = ReadFile.read("src/day2sample").split("\n")
        var horizontalPosition = 0
        var depth = 0
        var aim = 0

        data.forEach {
            val direction = it.split(" ")

            when (direction.first()) {
                "forward" -> {
                    horizontalPosition += direction.last().toInt()
                    depth += aim * direction.last().toInt()
                }
                "down" -> {
                    aim += direction.last().toInt()
                }
                "up" -> {
                    aim -= direction.last().toInt()
                }
            }
        }
        println(horizontalPosition * depth)
    }
}