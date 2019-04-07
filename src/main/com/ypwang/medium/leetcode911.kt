package com.ypwang.medium

class TopVotedCandidate(persons: IntArray, times: IntArray) {
    private val timeSeq = mutableListOf<Pair<Int, Int>>()    // time, leader
    init {
        val count = mutableMapOf<Int, Int>()        // person, count
        var leader = -1
        var leaderVote = 0

        for ((person, time) in persons.zip(times)) {
            val t = count.getOrDefault(person, 0) + 1

            if (t >= leaderVote) {
                if (leader != person) {
                    leader = person
                    timeSeq.add(Pair(time, person))
                }
                leaderVote = t
            }
            count[person] = t
        }
    }

    fun q(t: Int): Int {
        val index = timeSeq.binarySearch { Integer.compare(it.first, t) }
        return if (index < 0) timeSeq[-index - 2].second else timeSeq[index].second
    }
}

fun main() {
    val t = TopVotedCandidate(intArrayOf(0,0,0,0,1), intArrayOf(0,6,39,52,75))

    println(t.q(78))
}