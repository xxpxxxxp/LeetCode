package com.ypwang.medium

class Solution3365 {
    fun isPossibleToRearrange(s: String, t: String, k: Int): Boolean =
        s.chunked(s.length/k).sorted() == t.chunked(t.length/k).sorted()
}
