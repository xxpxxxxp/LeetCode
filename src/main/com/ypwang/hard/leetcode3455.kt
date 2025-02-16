package com.ypwang.hard

class Solution3455 {
    fun shortestMatchingSubstring(s: String, p: String): Int {
        val firstStar = p.indexOf('*')
        val secondStar = p.indexOf('*', firstStar + 1)

        val prefix = p.substring(0, firstStar)
        val middle = p.substring(firstStar + 1, secondStar)
        val suffix = p.substring(secondStar + 1)

        if (prefix.isEmpty() && middle.isEmpty() && suffix.isEmpty())
            return 0

        val lenPre = prefix.length
        val lenMid = middle.length
        val lenSuf = suffix.length

        var mini = Int.MAX_VALUE

        fun findOccurrences(part: String): List<Int> {
            val positions = mutableListOf<Int>()
            var pos = s.indexOf(part)
            while (pos != -1) {
                positions.add(pos)
                pos = s.indexOf(part, pos + 1)
            }
            return positions
        }

        val listP = if (prefix.isNotEmpty()) findOccurrences(prefix) else listOf()
        val listM = if (middle.isNotEmpty()) findOccurrences(middle) else listOf()
        val listS = if (suffix.isNotEmpty()) findOccurrences(suffix) else listOf()

        if (prefix.isNotEmpty() && middle.isNotEmpty() && suffix.isNotEmpty()) {
            for (i in listP) {
                val mStart = listM.binarySearch(i + lenPre).let { if (it < 0) -it-1 else it }
                if (mStart >= listM.size)
                    continue
                val mStartPos = listM[mStart]
                val sStart = listS.binarySearch(mStartPos + lenMid).let { if (it < 0) -it-1 else it }
                if (sStart >= listS.size)
                    continue
                val sStartPos = listS[sStart]
                mini = minOf(mini, sStartPos + lenSuf - i)
            }
        } else if (prefix.isEmpty() && middle.isNotEmpty() && suffix.isNotEmpty()) {
            for (mStart in listM) {
                val sStart = listS.binarySearch(mStart + lenMid).let { if (it < 0) -it-1 else it }
                if (sStart >= listS.size)
                    continue
                val sStartPos = listS[sStart]
                mini = minOf(mini, sStartPos + lenSuf - mStart)
            }
        } else if (prefix.isNotEmpty() && middle.isEmpty() && suffix.isNotEmpty()) {
            for (i in listP) {
                val sStart = listS.binarySearch(i + lenPre).let { if (it < 0) -it-1 else it }
                if (sStart >= listS.size)
                    continue
                val sStartPos = listS[sStart]
                mini = minOf(mini, sStartPos + lenSuf - i)
            }
        } else if (prefix.isNotEmpty() && middle.isNotEmpty() && suffix.isEmpty()) {
            for (i in listP) {
                val mStart = listM.binarySearch(i + lenPre).let { if (it < 0) -it-1 else it }
                if (mStart >= listM.size)
                    continue
                val mStartPos = listM[mStart]
                mini = minOf(mini, mStartPos + lenMid - i)
            }
        } else if (prefix.isNotEmpty() && middle.isEmpty() && suffix.isEmpty()) {
            if (listP.isNotEmpty()) mini = lenPre
        } else if (prefix.isEmpty() && middle.isNotEmpty() && suffix.isEmpty()) {
            if (listM.isNotEmpty()) mini = lenMid
        } else if (prefix.isEmpty() && middle.isEmpty() && suffix.isNotEmpty()) {
            if (listS.isNotEmpty()) mini = lenSuf
        }

        return if (mini == Int.MAX_VALUE) -1 else mini
    }
}

fun main() {
    println(Solution3455().shortestMatchingSubstring("abaacbaecebce", "ba*c*ce"))
}