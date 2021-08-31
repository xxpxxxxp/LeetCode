package com.ypwang.medium

class Solution1985 {
    private val comparator: Comparator<String> = Comparator<String> { s1, s2 ->
        if (s1.length != s2.length)
            s1.length.compareTo(s2.length)
        else {
            val pair = s1.zip(s2).firstOrNull { it.first != it.second }
            pair?.first?.compareTo(pair.second) ?: 0
        }
    }.reversed()

    fun kthLargestNumber(nums: Array<String>, k: Int): String {
        return nums.sortedWith(comparator)[k-1]

        // I can make it O(n) but I'm tired
        nums.shuffle()
        var i = 0
        var j = nums.lastIndex
        var c = k

        while (i != j) {
            var l = i
            var r = j

            while (l < r) {
                while (l < r && comparator.compare(nums[r], nums[i]) >= 0)
                    r--

                while (l < r && comparator.compare(nums[l], nums[i]) < 0)
                    l++

                // swap those 2
                val t = nums[l]
                nums[l] = nums[r]
                nums[r] = t
            }

            // swap classifier
            val t = nums[i]
            nums[i] = nums[l]
            nums[l] = t

            // now all elements in [i, l] >= i, all elements in (l, j] < i
            val len = l - i + 1
            if (c == len)
                return nums[l]
            else if (len < c) {
                c -= (l - i + 1)
                i = l+1
            } else {
                j = l-1
            }
        }

        return nums[i]
    }
}

fun main() {
    println(Solution1985().kthLargestNumber(arrayOf(
        "1","0","0"
    ), 2))
    println(Solution1985().kthLargestNumber(arrayOf(
        "0","1","1"
    ), 1))
    println(Solution1985().kthLargestNumber(arrayOf(
        "1","1"
    ), 1))
    println(Solution1985().kthLargestNumber(arrayOf(
        "3","6","7","10"
    ), 4))
    println(Solution1985().kthLargestNumber(arrayOf(
        "2","21","12","1"
    ), 3))
    println(Solution1985().kthLargestNumber(arrayOf(
        "0","0"
    ), 2))
}