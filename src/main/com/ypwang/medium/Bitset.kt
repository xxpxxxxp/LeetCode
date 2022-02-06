package com.ypwang.medium

class Bitset(val size: Int) {
    private val arr = BooleanArray(size)
    private var cnt:Int = 0
    private var flipAll = false

    fun fix(idx: Int) {
        if (!(arr[idx] xor flipAll)) {
            arr[idx] = arr[idx] xor true
            cnt += 1
        }
    }

    fun unfix(idx: Int) {
        if (arr[idx] xor flipAll) {
            arr[idx] = arr[idx] xor true
            cnt -= 1
        }
    }

    fun flip() {
        flipAll = flipAll xor true
        cnt = this.size - cnt
    }

    fun all(): Boolean {
        return cnt == this.size
    }

    fun one(): Boolean {
        return cnt > 0
    }

    fun count(): Int {
        return cnt
    }

    override fun toString(): String {
        val sb = StringBuilder()
        for (b in arr) {
            sb.append(if (b xor flipAll) '1' else '0')
        }
        return sb.toString()
    }
}
