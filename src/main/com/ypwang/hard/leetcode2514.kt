package com.ypwang.hard

class Solution2514 {
    private val mod = 1000000007L

    fun countAnagrams(s: String): Int =
        s.split(' ').map {
            val t = it.length
            val cnt = it.groupBy { c -> c }.map { kv -> kv.value.size }.filter { l -> l > 1 }.sorted().toIntArray()

            var rst = 1L
            var i = 0       // idx in cnt
            var j = 2       // idx in [0, cnt[i]]
            var k = 2       // idx in [2, t]

            while (k <= t) {
                while (i < cnt.size && rst % j == 0L) {
                    rst /= j
                    j++
                    if (j > cnt[i]) {
                        i++
                        j = 2
                    }
                }

                if (i < cnt.size)
                    rst *= k++
                else
                    rst = (rst * k++) % mod
            }

            while (i < cnt.size) {
                rst /= j
                j++
                if (j > cnt[i]) {
                    i++
                    j = 2
                }
            }

            rst % mod
        }.fold(1L) { i, c -> i * c % mod }.toInt()
}

fun main() {
    println(Solution2514().countAnagrams("eoblsuqjnpsrfawprqcqxykbududpvimwtvfyvdsgpcn wmyikoakqwjsutgrucubmpatibfzjoewubqgfinxcznzemjckfacxikbfjygaamsidynhjrwjftneeujuymvznxdu fqaeeqcrlvjj hrqhhqrjbeijmicpdmayeybcedzhicvsfdgrakbaxesjzguqfprcgkgybgzwhxccljpxxjlrjjnddplklqfcsuunt qzbmkqbrhxpasniftpkviphnhfbacfifxkfsjmbgmpzd fanh dous"))
    println(Solution2514().countAnagrams("smuiquglfwdepzuyqtgujaisius ithsczpelfqp rjm"))
    println(Solution2514().countAnagrams("b okzojaporykbmq tybq zrztwlolvcyumcsq jjuowpp"))
    println(Solution2514().countAnagrams("too hot"))
    println(Solution2514().countAnagrams("aa"))
}