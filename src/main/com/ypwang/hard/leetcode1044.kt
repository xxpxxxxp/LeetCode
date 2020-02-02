package com.ypwang.hard

class Solution1044 {
    private data class suffix(var index: Int = 0, var rank0: Int = 0, var rank1: Int = 0)
    private val comparator = compareBy<suffix> { it.rank0 }.thenBy { it.rank1 }

    fun buildSuffixArray(S: String): IntArray {
        val suffixes = Array(S.length) { suffix() }
        for (i in S.indices) {
            suffixes[i].index = i
            suffixes[i].rank0 = S[i] - 'a'
            suffixes[i].rank1 = if (i + 1 < S.length) S[i+1] - 'a' else -1
        }

        suffixes.sortWith(comparator)
        val ind = IntArray(S.length)

        var k = 4
        while (k < 2 * S.length) {
            var rank = 0
            var preRank = suffixes[0].rank0
            suffixes[0].rank0 = rank
            ind[suffixes[0].index] = 0

            for (i in 1 until S.length) {
                if (suffixes[i].rank0 == preRank && suffixes[i].rank1 == suffixes[i-1].rank1)
                    suffixes[i].rank0 = rank
                else {
                    preRank = suffixes[i].rank0
                    suffixes[i].rank0 = ++rank
                }
                ind[suffixes[i].index] = i
            }

            for (i in S.indices) {
                val nextIndex = suffixes[i].index + k / 2
                suffixes[i].rank1 = if (nextIndex < S.length) suffixes[ind[nextIndex]].rank0 else -1
            }

            suffixes.sortWith(comparator)
            k *= 2
        }

        return suffixes.map { it.index }.toIntArray()
    }

    fun kasai(S: String, suffixArray: IntArray): IntArray {
        val lcp = IntArray(S.length)
        val inv = IntArray(S.length)

        for (i in S.indices)
            inv[suffixArray[i]] = i

        var k = 0
        for (i in S.indices) {
            if (inv[i] == S.lastIndex) {
                k = 0
                continue
            }

            val j = suffixArray[inv[i] + 1]
            while (i + k < S.length && j + k < S.length && S[i+k] == S[j+k])
                k++

            lcp[inv[i]] = k
            if (k > 0)
                k--
        }

        return lcp
    }

    fun longestDupSubstring(S: String): String {
        val suffixArray = buildSuffixArray(S)
        val lcp = kasai(S, suffixArray)

        val (i, l) = lcp.withIndex().maxBy { it.value }!!
        return S.substring(suffixArray[i], suffixArray[i] + l)
    }
}

fun main() {
    println(Solution1044().longestDupSubstring("ababdaebdabedeabbdddbcebaccececbccccebbcaaabaadcadccddaedaacaeddddeceedeaabbbbcbacdaeeebaabdabdbaebadcbdebaaeddcadebedeabbbcbeadbaacdebceebceeccddbeacdcecbcdbceedaeebdaeeabccccbcccbceabedaedaacdbbdbadcdbdddddcdebbcdbcabbebbeabbdccccbaaccbbcecacaebebecdcdcecdeaccccccdbbdebaaaaaaeaaeecdecedcbabedbabdedbaebeedcecebabedbceecacbdecabcebdcbecedccaeaaadbababdccedebeccecaddeabaebbeeccabeddedbeaadbcdceddceccecddbdbeeddabeddadaaaadbeedbeeeaaaeaadaebdacbdcaaabbacacccddbeaacebeeaabaadcabdbaadeaccaecbeaaabccddabbeacdecadebaecccbabeaceccaaeddedcaecddaacebcaecebebebadaceadcaccdeebbcdebcedaeaedacbeecceeebbdbdbaadeeecabdebbaaebdddeeddabcbaaebeabbbcaaeecddecbbbebecdbbbaecceeaabeeedcdecdcaeacabdcbcedcbbcaeeebaabdbaadcebbccbedbabeaddaecdbdbdccceeccaccbdcdadcccceebdabccaebcddaeeecddddacdbdbeebdabecdaeaadbadbebecbcacbbceeabbceecaabdcabebbcdecedbacbcccddcecccecbacddbeddbbbadcbdadbecceebddeacbeeabcdbbaabeabdbbbcaeeadddaeccbcdabceeabaacbeacdcbdceebeaebcceeebdcdcbeaaeeeadabbecdbadbebbecdceaeeecaaaedeceaddedbedbedbddbcbabeadddeccdaadaaeaeeadebbeabcabbdebabeedeeeccadcddaebbedadcdaebabbecedebadbdeacecdcaebcbdababcecaecbcbcdadacaebdedecaadbaaeeebcbeeedaaebbabbeeadadbacdedcbabdaabddccedbeacbecbcccdeaeeabcaeccdaaaddcdecadddabcaedccbdbbccecacbcdecbdcdcbabbeaacddaeeaabccebaaaebacebdcdcbbbdabadeebbdccabcacaacccccbadbdebecdaccabbecdabdbdaebeeadaeecbadedaebcaedeedcaacabaccbbdaccedaedddacbbbdbcaeedbcbecccdbdeddcdadacccdbcdccebdebeaeacecaaadccbbaaddbeebcbadceaebeccecabdadccddbbcbaebeaeadacaebcbbbdbcdaeadbcbdcedebabbaababaacedcbcbceaaabadbdcddadecdcebeeabaadceecaeccdeeabdbabebdcedceaeddaecedcdbccbbedbeecabaecdbba"))
    println(Solution1044().longestDupSubstring("banana"))
    println(Solution1044().longestDupSubstring("abcd"))
}