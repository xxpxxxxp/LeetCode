package com.ypwang.easy

class Solution414 {
    object heap3 {
        val ns = arrayListOf(Int.MIN_VALUE, Int.MIN_VALUE, Int.MIN_VALUE)

        fun store(n: Int) {
            if (n < ns[0]) {
                return
            }

            ns[0] = n
            var root= 0
            while (2 * root + 1 < 3) {
                val child = 2 * root + 1
                var swap = root
                if (ns[swap] > ns[child]) {
                    swap = child
                }
                if (child + 1 <= 3 && ns[swap] > ns[child + 1]) {
                    swap = child + 1
                }
                if (swap == root) {
                    return
                } else {
                    val tmp = ns[root]
                    ns[root] = ns[swap]
                    ns[swap] = tmp
                    root = swap
                }
            }
        }

        fun get() = ns[0]
    }

    fun thirdMax(nums: IntArray): Int {
        val ns = nums.toSet()
        if (ns.size < 3) {
            return ns.max()!!
        }

        ns.forEach { heap3.store(it) }
        return heap3.get()
    }
}

fun main() {
    println(Solution414().thirdMax(intArrayOf(2,2,3,1)))
}