package com.ypwang.medium

class Solution886 {
    fun possibleBipartition(N: Int, dislikes: Array<IntArray>): Boolean {
        val t = dislikes.map { it[0] to it[1] }
        val dislike = (t + (t.map { it.second to it.first })).groupBy { it.first }.mapValues { it.value.map { it.second } }
        val visited = IntArray(N){-1}

        fun helper(index: Int, flag: Int): Boolean = when (visited[index - 1]) {
            flag -> true
            -1 -> {
                visited[index - 1] = flag
                if (index !in dislike) true
                else dislike.getValue(index).all { helper(it, (flag + 1) % 2) }
            }
            else -> false
        }

        return (1..N).all { visited[it - 1] != -1 || helper(it, 0) }
    }
}

fun main() {
    println(Solution886().possibleBipartition(50, arrayOf(
            intArrayOf(21,47),intArrayOf(4,41),intArrayOf(2,41),intArrayOf(36,42),intArrayOf(32,45),intArrayOf(26,28),intArrayOf(32,44),intArrayOf(5,41),intArrayOf(29,44),intArrayOf(10,46),intArrayOf(1,6),intArrayOf(7,42),intArrayOf(46,49),intArrayOf(17,46),intArrayOf(32,35),intArrayOf(11,48),intArrayOf(37,48),intArrayOf(37,43),intArrayOf(8,41),intArrayOf(16,22),intArrayOf(41,43),intArrayOf(11,27),intArrayOf(22,44),intArrayOf(22,28),intArrayOf(18,37),intArrayOf(5,11),intArrayOf(18,46),intArrayOf(22,48),intArrayOf(1,17),intArrayOf(2,32),intArrayOf(21,37),intArrayOf(7,22),intArrayOf(23,41),intArrayOf(30,39),intArrayOf(6,41),intArrayOf(10,22),intArrayOf(36,41),intArrayOf(22,25),intArrayOf(1,12),intArrayOf(2,11),intArrayOf(45,46),intArrayOf(2,22),intArrayOf(1,38),intArrayOf(47,50),intArrayOf(11,15),intArrayOf(2,37),intArrayOf(1,43),intArrayOf(30,45),intArrayOf(4,32),intArrayOf(28,37),intArrayOf(1,21),intArrayOf(23,37),intArrayOf(5,37),intArrayOf(29,40),intArrayOf(6,42),intArrayOf(3,11),intArrayOf(40,42),intArrayOf(26,49),intArrayOf(41,50),intArrayOf(13,41),intArrayOf(20,47),intArrayOf(15,26),intArrayOf(47,49),intArrayOf(5,30),intArrayOf(4,42),intArrayOf(10,30),intArrayOf(6,29),intArrayOf(20,42),intArrayOf(4,37),intArrayOf(28,42),intArrayOf(1,16),intArrayOf(8,32),intArrayOf(16,29),intArrayOf(31,47),intArrayOf(15,47),intArrayOf(1,5),intArrayOf(7,37),intArrayOf(14,47),intArrayOf(30,48),intArrayOf(1,10),intArrayOf(26,43),intArrayOf(15,46),intArrayOf(42,45),intArrayOf(18,42),intArrayOf(25,42),intArrayOf(38,41),intArrayOf(32,39),intArrayOf(6,30),intArrayOf(29,33),intArrayOf(34,37),intArrayOf(26,38),intArrayOf(3,22),intArrayOf(18,47),intArrayOf(42,48),intArrayOf(22,49),intArrayOf(26,34),intArrayOf(22,36),intArrayOf(29,36),intArrayOf(11,25),intArrayOf(41,44),intArrayOf(6,46),intArrayOf(13,22),intArrayOf(11,16),intArrayOf(10,37),intArrayOf(42,43),intArrayOf(12,32),intArrayOf(1,48),intArrayOf(26,40),intArrayOf(22,50),intArrayOf(17,26),intArrayOf(4,22),intArrayOf(11,14),intArrayOf(26,39),intArrayOf(7,11),intArrayOf(23,26),intArrayOf(1,20),intArrayOf(32,33),intArrayOf(30,33),intArrayOf(1,25),intArrayOf(2,30),intArrayOf(2,46),intArrayOf(26,45),intArrayOf(47,48),intArrayOf(5,29),intArrayOf(3,37),intArrayOf(22,34),intArrayOf(20,22),intArrayOf(9,47),intArrayOf(1,4),intArrayOf(36,46),intArrayOf(30,49),intArrayOf(1,9),intArrayOf(3,26),intArrayOf(25,41),intArrayOf(14,29),intArrayOf(1,35),intArrayOf(23,42),intArrayOf(21,32),intArrayOf(24,46),intArrayOf(3,32),intArrayOf(9,42),intArrayOf(33,37),intArrayOf(7,30),intArrayOf(29,45),intArrayOf(27,30),intArrayOf(1,7),intArrayOf(33,42),intArrayOf(17,47),intArrayOf(12,47),intArrayOf(19,41),intArrayOf(3,42),intArrayOf(24,26),intArrayOf(20,29),intArrayOf(11,23),intArrayOf(22,40),intArrayOf(9,37),intArrayOf(31,32),intArrayOf(23,46),intArrayOf(11,38),intArrayOf(27,29),intArrayOf(17,37),intArrayOf(23,30),intArrayOf(14,42),intArrayOf(28,30),intArrayOf(29,31),intArrayOf(1,8),intArrayOf(1,36),intArrayOf(42,50),intArrayOf(21,41),intArrayOf(11,18),intArrayOf(39,41),intArrayOf(32,34),intArrayOf(6,37),intArrayOf(30,38),intArrayOf(21,46),intArrayOf(16,37),intArrayOf(22,24),intArrayOf(17,32),intArrayOf(23,29),intArrayOf(3,30),intArrayOf(8,30),intArrayOf(41,48),intArrayOf(1,39),intArrayOf(8,47),intArrayOf(30,44),intArrayOf(9,46),intArrayOf(22,45),intArrayOf(7,26),intArrayOf(35,42),intArrayOf(1,27),intArrayOf(17,30),intArrayOf(20,46),intArrayOf(18,29),intArrayOf(3,29),intArrayOf(4,30),intArrayOf(3,46)
    )))
}