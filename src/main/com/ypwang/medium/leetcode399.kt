package com.ypwang.medium

class Solution399 {
    fun calcEquation(equations: Array<Array<String>>, values: DoubleArray, queries: Array<Array<String>>): DoubleArray {
        val connections = mutableMapOf<String, Pair<String, Double>>()
        val appears = mutableSetOf<String>()

        for ((factor, dvs) in values.zip(equations)) {
            appears.addAll(dvs)
            var tail = dvs[0]
            var head = dvs[1]

            // tail = factor * head
            var f = factor
            while (head in connections && head != connections[head]!!.first) {
                f *= connections[head]!!.second
                head = connections[head]!!.first
            }

            while (tail in connections && tail != connections[tail]!!.first) {
                f /= connections[tail]!!.second
                tail = connections[tail]!!.first
            }

            connections[tail] = Pair(head, f)
        }

        return queries.map {
            var tail = it[0]
            var head = it[1]

            if (tail !in appears && head !in appears) -1.0
            else {
                var ft = 1.0
                var fh = 1.0

                while (head in connections && head != connections[head]!!.first) {
                    fh *= connections[head]!!.second
                    head = connections[head]!!.first
                }

                while (tail in connections && tail != connections[tail]!!.first) {
                    ft *= connections[tail]!!.second
                    tail = connections[tail]!!.first
                }

                if (head == tail) ft / fh
                else -1.0
            }
        }.toDoubleArray()
    }
}

fun main() {
    println(Solution399().calcEquation(
            arrayOf(arrayOf("a", "b"), arrayOf("b", "c")), doubleArrayOf(2.0, 3.0),
            arrayOf(
                    arrayOf("a", "c"), arrayOf("b", "a"), arrayOf("a", "e"), arrayOf("a", "a"), arrayOf("x", "x")
            )
    ).toList())
}