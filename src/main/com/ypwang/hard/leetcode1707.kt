package com.ypwang.hard

import com.ypwang.TreeNode
import java.lang.StringBuilder

class Solution1707 {
    private fun insert(word: String, len: Int, head: TreeNode) {
        var h = head
        for (i in len downTo word.length+1) {
            if (h.left == null)
                h.left = TreeNode(i)

            h = h.left!!
        }

        var idx = word.length
        for (c in word) {
            if (c == '0') {
                if (h.left == null)
                    h.left = TreeNode(idx)

                h = h.left!!
            } else {
                if (h.right == null)
                    h.right = TreeNode(idx)

                h = h.right!!
            }
            idx--
        }
    }

    private fun findMax(pre: String, x: Int, head: TreeNode): Int {
        val bin = x.toString(2)
        var h = head
        val sb = StringBuilder(pre)
        for (i in head.`val`-1 downTo bin.length+1) {
            h = if (h.right != null) {
                sb.append("1")
                h.right!!
            } else {
                sb.append("0")
                h.left!!
            }
        }

        val start = bin.length - h.`val` + 1
        for (i in start until bin.length) {
            h =
                if (bin[i] == '0') {
                    if (h.right != null) {
                        sb.append("1")
                        h.right!!
                    } else {
                        sb.append("0")
                        h.left!!
                    }
                } else {
                    if (h.left != null) {
                        sb.append("0")
                        h.left!!
                    } else {
                        sb.append("1")
                        h.right!!
                    }
                }
        }

        return sb.toString().toInt(2) xor x
    }

    fun maximizeXor(nums: IntArray, queries: Array<IntArray>): IntArray {
        // build trie
        val dummy = TreeNode()
        val max = nums.maxOrNull()!!.toString(2)
        insert(max, max.length, dummy)

        nums.map { it.toString(2) }.forEach { insert(it, max.length, dummy) }

        return queries.map { (x, m) ->
            val bin = m.toString(2)
            if (bin.length > max.length) {
                var t = -1
                if (dummy.left != null)
                    t = maxOf(t, findMax("0", x, dummy.left!!))
                if (dummy.right != null)
                    t = maxOf(t, findMax("1", x, dummy.right!!))
                return@map t
            }

            val prefix = StringBuilder()
            var head = dummy
            for (i in max.length - bin.length downTo 1) {
                prefix.append('0')
                head = head.left ?: return@map -1
            }

            var t = -1
            for (c in bin) {
                if (c == '0') {
                    head = head.left ?: return@map t
                } else {
                    if (head.left != null) {
                        t = maxOf(t, findMax(prefix.toString() + "0", x, head.left!!))
                    }
                    head = head.right ?: return@map t
                }
                prefix.append(c)
            }

            return@map maxOf(t, x xor m)
        }.toIntArray()
    }
}

fun main() {
    println(Solution1707().maximizeXor(intArrayOf(4096,4096,4096,4096,4194304,2418321,3409704,4194304,73823843,153051173,1115013,2324970,3945210,4194304,164298917,4096,4194304,2809722,416675649,4194304), arrayOf(
        intArrayOf(173201834,1000000000),intArrayOf(262144,864491623),intArrayOf(21632356,131583634),intArrayOf(262144,232483643),intArrayOf(40493,1000000000),intArrayOf(6300390,479136595),intArrayOf(444547695,1000000000),intArrayOf(580546245,649442080),intArrayOf(262144,1000000000),intArrayOf(51688080,1000000000),intArrayOf(28086769,1000000000),intArrayOf(12497,33554432),intArrayOf(8747180,672735286),intArrayOf(97256,1000000000),intArrayOf(204112,1000000000),intArrayOf(779241301,33554432),intArrayOf(262144,1000000000),intArrayOf(74833,33554432),intArrayOf(262144,33554432),intArrayOf(6515092,1000000000)
    )).toList())
    println(Solution1707().maximizeXor(intArrayOf(760625198,15138539,61033,267654046,133000577,229497,155443,109330,13340119,8260519,981126373,441631490,498767021,171522247,503991705,11276686,176397,23247190,472734721,243117401), arrayOf(
        intArrayOf(31380566,64633365), intArrayOf(171815678,403214196)
    )).toList())
    println(Solution1707().maximizeXor(intArrayOf(536870912,0,534710168,330218644,142254206), arrayOf(
        intArrayOf(558240772,1000000000)
    )).toList())
    println(Solution1707().maximizeXor(intArrayOf(5,2,4,6,6,3), arrayOf(
        intArrayOf(6,3), intArrayOf(12,4), intArrayOf(8,1)
    )).toList())
    println(Solution1707().maximizeXor(intArrayOf(0,1,2,3,4), arrayOf(
        intArrayOf(5,6), intArrayOf(3,1), intArrayOf(1,3)
    )).toList())
}