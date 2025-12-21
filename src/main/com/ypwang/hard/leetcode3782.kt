package com.ypwang.hard

class Solution3782 {
    fun lastInteger(n: Long): Long =
        1L + ((n-1L) and 0xAAAAAAAAAAAAAAAL)
}