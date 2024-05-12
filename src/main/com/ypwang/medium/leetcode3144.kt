package com.ypwang.medium

class Solution3144 {
    fun minimumSubstringsInPartition(s: String): Int {
        val dp = IntArray(s.length) { -1 }

        fun task(idx: Int): Int {
            if (idx < 0)
                return 0

            if (dp[idx] == -1) {
                val count = IntArray(26)
                var rst = Int.MAX_VALUE
                for (j in idx downTo 0) {
                    count[s[j] - 'a'] += 1

                    var cur = 0
                    var equals = true
                    for (c in count) {
                        if (c > 0) {
                            if (cur == 0)
                                cur = c
                            else if (c != cur) {
                                equals = false
                                break
                            }
                        }
                    }

                    if (equals)
                        rst = minOf(rst, 1 + task(j - 1))
                }
                dp[idx] = rst
            }

            return dp[idx]
        }

        return task(s.length - 1)
    }
}

fun main() {
    println(Solution3144().minimumSubstringsInPartition("nuuihglllgpsmnzznxmawbalzhyidqnpikkemvzjyyjtclszxwlbbtfedjvarmmylamakgfuhtifhazfppkwnwdjxlssdlfiavdmmevmtgeamyeysbgxvsqxduhnfffesxfgfebjgzvxfclekzdlzvasqhxddrowkkmluythqhomowvsixzumgofymbuqozmqfxxrgedkkzctlpufjdbegivuozofjorgpvolrwhsqlhtttojanbgluttltyfmskbdjgcqddxkzjxsqslavjysjpjwroajmvylwdlwnrsfccaadnfqvaqbggcbbortkgkhfgpnqlvgawnsufbnggghrpggasflznnzxppmhktzqtkfcgvymvxwffevlxqvhvnjjajnnpclgazffoyzxttmwywrkajdtlayynmmhytbtuhklsedshewuzuzlfgbyhnvkkdpglkxjdamyymshstytgcufkvvxalrdmmiurzrwafqwwngrgftnzzbgnmdvlpjyycuqrwgfvfxdznqwmjbhxuavypbximkyogwfgwyxzeobmgbnqliwyydwgrtfulcqbzbvvqukkfljynjrohukxbuuvbemwqgfmizyynzzzgvrzdhmaxqzquxtjrpmtxglqwxpaanywbhufisgvlgdhvvqdnnpxwwllsglvymmkmbcyqdpjhqeapdydwpqswccagldfatxbjfrofibdlmedwwfarkviuueuladgzpltlimoytdtdxyybszumftjqqdlstuugrfsnhxxspiqkvolcpqbzbioejcqqxwijommrytthpnvorowfgosprfxsdqvwwjkoxdtwwohyqkcmgricmxqvubzvxqpefpydhztkzijmaofbowdadaaylfkgfgfzccbekzucuuttalwbfsoavodqgdipnyrdxhwbmsoswumhajtuerxwcwpcjkluyjelaansxyaftglazauisksvqxzdgvjmisgytck"))
    println(Solution3144().minimumSubstringsInPartition("fabccddg"))
}
