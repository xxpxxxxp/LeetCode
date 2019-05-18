package com.ypwang.hard

class Solution1001 {
    fun gridIllumination(N: Int, lamps: Array<IntArray>, queries: Array<IntArray>): IntArray {
        fun hash(m: Int, n: Int): Int = m * 20011 + n

        val hashPair = lamps.map { it to hash(it[0], it[1]) }
        val hor = hashPair.groupBy { it.first[0] }.mapValues { it.value.map { kv -> kv.second }.toMutableSet() }.toMutableMap()
        val ver = hashPair.groupBy { it.first[1] }.mapValues { it.value.map { kv -> kv.second }.toMutableSet() }.toMutableMap()
        val dia1 = hashPair.groupBy { it.first[1] - it.first[0] }.mapValues { it.value.map { kv -> kv.second }.toMutableSet() }.toMutableMap()
        val dia2 = hashPair.groupBy { it.first[1] + it.first[0] }.mapValues { it.value.map { kv -> kv.second }.toMutableSet() }.toMutableMap()

        fun remove(m: Int, n: Int) {
            val h = hash(m, n)
            if (m in hor) {
                hor[m]!!.remove(h)
                if (hor[m]!!.isEmpty()) hor.remove(m)
            }
            if (n in ver) {
                ver[n]!!.remove(h)
                if (ver[n]!!.isEmpty()) ver.remove(n)
            }
            if (n - m in dia1) {
                dia1[n-m]!!.remove(h)
                if (dia1[n-m]!!.isEmpty()) dia1.remove(n - m)
            }

            if (n + m in dia2) {
                dia2[n+m]!!.remove(h)
                if (dia2[n+m]!!.isEmpty()) dia2.remove(n+m)
            }
        }

        val rst = IntArray(queries.size)
        val pos = arrayOf(
                -1 to -1, -1 to 0, -1 to 1,
                0 to -1, 0 to 0, 0 to 1,
                1 to -1, 1 to 0, 1 to 1
        )
        for ((i, query) in queries.withIndex()) {
            if (query[0] in hor || query[1] in ver || (query[1] - query[0]) in dia1 || (query[1] + query[0]) in dia2) {
                rst[i] = 1
                for (p in pos) {
                    if (query[0] + p.first in 0 until N && query[1] + p.second in 0 until N) {
                        remove(query[0] + p.first, query[1] + p.second)
                    }
                }
            }
        }

        return rst
    }
}

fun main() {
    println(Solution1001().gridIllumination(
        100,
        arrayOf(intArrayOf(7,55),intArrayOf(53,61),intArrayOf(2,82),intArrayOf(67,85),intArrayOf(81,75),intArrayOf(38,91),intArrayOf(68,0),intArrayOf(60,43),intArrayOf(40,19),intArrayOf(12,75),intArrayOf(26,2),intArrayOf(24,89),intArrayOf(42,81),intArrayOf(60,58),intArrayOf(77,72),intArrayOf(33,24),intArrayOf(19,93),intArrayOf(7,16),intArrayOf(58,54),intArrayOf(78,57),intArrayOf(97,49),intArrayOf(65,16),intArrayOf(42,75),intArrayOf(90,50),intArrayOf(89,34),intArrayOf(76,97),intArrayOf(58,23),intArrayOf(62,47),intArrayOf(94,28),intArrayOf(88,65),intArrayOf(3,87),intArrayOf(81,10),intArrayOf(12,81),intArrayOf(44,81),intArrayOf(54,92),intArrayOf(90,54),intArrayOf(17,54),intArrayOf(27,82),intArrayOf(48,15),intArrayOf(8,46),intArrayOf(4,99),intArrayOf(15,13),intArrayOf(90,77),intArrayOf(2,87),intArrayOf(18,33),intArrayOf(52,90),intArrayOf(4,95),intArrayOf(57,61),intArrayOf(31,22),intArrayOf(32,8),intArrayOf(49,26),intArrayOf(24,65),intArrayOf(88,55),intArrayOf(88,38),intArrayOf(64,76),intArrayOf(94,76),intArrayOf(59,12),intArrayOf(41,46),intArrayOf(80,28),intArrayOf(38,36),intArrayOf(65,67),intArrayOf(75,37),intArrayOf(56,97),intArrayOf(83,57),intArrayOf(2,4),intArrayOf(44,43),intArrayOf(71,90),intArrayOf(62,40),intArrayOf(79,94),intArrayOf(81,11),intArrayOf(96,34),intArrayOf(38,11),intArrayOf(22,3),intArrayOf(54,96),intArrayOf(78,33),intArrayOf(54,54),intArrayOf(79,98),intArrayOf(1,28),intArrayOf(0,32),intArrayOf(37,11)),
        arrayOf(intArrayOf(24,84),intArrayOf(95,68),intArrayOf(80,35),intArrayOf(31,53),intArrayOf(69,45),intArrayOf(85,29),intArrayOf(87,25),intArrayOf(42,47),intArrayOf(7,59),intArrayOf(99,3),intArrayOf(31,70),intArrayOf(64,62),intArrayOf(44,91),intArrayOf(55,25),intArrayOf(15,52),intArrayOf(95,33),intArrayOf(21,29),intArrayOf(61,34),intArrayOf(93,34),intArrayOf(79,27),intArrayOf(30,86),intArrayOf(52,0),intArrayOf(18,10),intArrayOf(5,1),intArrayOf(40,21),intArrayOf(11,48),intArrayOf(55,94),intArrayOf(22,42),intArrayOf(81,0),intArrayOf(39,43),intArrayOf(5,25),intArrayOf(43,29),intArrayOf(45,47),intArrayOf(83,93),intArrayOf(77,70),intArrayOf(22,63),intArrayOf(30,73),intArrayOf(18,48),intArrayOf(39,88),intArrayOf(91,47))
    ).toList())
}