package com.ypwang.medium

class Solution332 {
    fun findItinerary(tickets: Array<Array<String>>): List<String> {
        data class Itinerary(var arriveTime: Int, val to: MutableSet<String>)

        val its = mutableMapOf<String, Itinerary>()

        for (t in tickets) {
            val from = t[0]
            val to = t[1]

            if (from !in its) {
                its[from] = Itinerary(0, mutableSetOf())
            }
            if (to !in its) {
                its[to] = Itinerary(0, mutableSetOf())
            }

            its[to]!!.arriveTime += 1
            its[from]!!.to.add(to)
        }

        val first = its.filter { it.value.arriveTime < it.value.to.size }.keys.first()
        // back-tracing
        val line = mutableListOf<String>()
        fun from(port: String): Boolean {
            line.add(port)

            if (line.size == tickets.size + 1)
                return true

            for (to in its[port]!!.to.toList().sorted()) {
                its[port]!!.to.remove(to)
                if (from(to)) {
                    return true
                }
                its[port]!!.to.add(to)
            }

            line.removeAt(line.lastIndex)
            return false
        }

        from(first)
        return line
    }
}

fun main() {
    println(Solution332().findItinerary(
            arrayOf(
                    arrayOf("JFK","KUL"),
                    arrayOf("JFK","NRT"),
                    arrayOf("NRT","JFK")
            )
    ))
}