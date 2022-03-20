package com.ypwang.medium

class Solution2207 {
    fun maximumSubsequenceCount(text: String, pattern: String): Long {
        if (pattern[0] == pattern[1]) {
            val c = text.count { it == pattern[0] }
            return (c + 1L) * c / 2
        }

        val t = text.filter { it == pattern[0] || it == pattern[1] }
        var sum = 0L
        var c1 = 0
        for (c in t) {
            when (c) {
                pattern[0] ->
                    c1++
                pattern[1] ->
                    sum += c1
            }
        }

        c1 = 0
        var c2 = t.count{ it == pattern[1] }
        var max = 0
        for (c in t) {
            max = maxOf(
                max,
                c2,     // put pattern[0]
                c1      // put pattern[1]
            )

            when (c) {
                pattern[0] ->
                    c1++
                pattern[1] ->
                    c2--
            }
        }

        max = maxOf(max, c1)

        return sum + max
    }
}

fun main() {
    println(Solution2207().maximumSubsequenceCount("abdcdbc", "ac"))
    println(Solution2207().maximumSubsequenceCount("aabb", "ab"))
    println(Solution2207().maximumSubsequenceCount("vnedkpkkyxelxqptfwuzcjhqmwagvrglkeivowvbjdoyydnjrqrqejoyptzoklaxcjxbrrfmpdxckfjzahparhpanwqfjrpbslsyiwbldnpjqishlsuagevjmiyktgofvnyncizswldwnngnkifmaxbmospdeslxirofgqouaapfgltgqxdhurxljcepdpndqqgfwkfiqrwuwxfamciyweehktaegynfumwnhrgrhcluenpnoieqdivznrjljcotysnlylyswvdlkgsvrotavnkifwmnvgagjykxgwaimavqsxuitknmbxppgzfwtjdvegapcplreokicxcsbdrsyfpustpxxssnouifkypwqrywprjlyddrggkcglbgcrbihgpxxosmejchmzkydhquevpschkpyulqxgduqkqgwnsowxrmgqbmltrltzqmmpjilpfxocflpkwithsjlljxdygfvstvwqsyxlkknmgpppupgjvfgmxnwmvrfuwcrsadomyddazlonjyjdeswwznkaeaasyvurpgyvjsiltiykwquesfjmuswjlrphsdthmuqkrhynmqnfqdlwnwesdmiiqvcpingbcgcsvqmsmskesrajqwmgtdoktreqssutpudfykriqhblntfabspbeddpdkownehqszbmddizdgtqmobirwbopmoqzwydnpqnvkwadajbecmajilzkfwjnpfyamudpppuxhlcngkign"
        , "rr"))
}