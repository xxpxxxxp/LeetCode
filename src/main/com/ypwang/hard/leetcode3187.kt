package com.ypwang.hard

class Solution3187 {
    fun countOfPeaks(nums: IntArray, queries: Array<IntArray>): List<Int> {
        val tree = makeTree(nums)
        val result = mutableListOf<Int>()
        for ((q, s, e) in queries) {
            if (q == 1) {
                var start = s
                var end = e
                start++
                end--

                if (start > end)
                    result.add(0)
                else
                    result.add(getSum(tree, start, end))
            } else {
                updateTree(tree, s, e, nums)
            }
        }

        return result
    }

    private fun getSum(tree: IntArray, start: Int, end: Int): Int {
        var start = start
        var end = end
        val leafStart = tree.size / 2

        start += leafStart
        end += leafStart
        var sum = 0
        while (start < end) {
            if (start % 2 == 1) {
                sum += tree[start]
                start++
            }
            if (end % 2 == 0) {
                sum += tree[end]
                end--
            }

            if (end < start) break

            start /= 2
            end /= 2
        }
        if (start == end)
            sum += tree[start]
        return sum
    }

    private fun makeTree(nums: IntArray): IntArray {
        var len = 1
        while (len < nums.size * 2)
            len = len shl 1

        val tree = IntArray(len)
        var treeIdx = len / 2

        for (i in nums.indices) {
            if (i - 1 >= 0 && i + 1 < nums.size && nums[i - 1] < nums[i] && nums[i] > nums[i + 1])
                tree[treeIdx] = 1
            treeIdx++
        }

        for (i in len / 2 - 1 downTo 1)
            tree[i] = tree[i * 2] + tree[i * 2 + 1]

        return tree
    }

    private fun check(tree: IntArray, idx: Int, `val`: Int, nums: IntArray) {
        val leafStart = tree.size / 2

        nums[idx] = `val`
        if (idx - 1 >= 0 && idx + 1 < nums.size) {
            if (nums[idx - 1] < nums[idx] && nums[idx] > nums[idx + 1]) {
                if (tree[idx + leafStart] == 1) return
                else {
                    var k = idx + leafStart
                    while (k > 0) {
                        tree[k]++
                        k /= 2
                    }
                }
            } else {
                if (tree[idx + leafStart] == 0) return
                var k = idx + leafStart
                while (k > 0) {
                    tree[k]--
                    k /= 2
                }
            }
        }
    }

    private fun updateTree(tree: IntArray, idx: Int, `val`: Int, nums: IntArray) {
        check(tree, idx, `val`, nums)
        if (idx - 1 >= 0) check(tree, idx - 1, nums[idx - 1], nums)
        if (idx + 1 < nums.size) check(tree, idx + 1, nums[idx + 1], nums)
    }
}
