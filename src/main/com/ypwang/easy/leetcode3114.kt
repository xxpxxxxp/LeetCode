package com.ypwang.easy

class Solution3114 {
    fun findLatestTime(s: String): String {
        val arr = s.toCharArray()
        if (arr[0] == '?') {
            if (arr[1] == '?') {
                arr[0] = '1'
                arr[1] = '1'
            }
            if (arr[1] > '1')
                arr[0] = '0'
            else
                arr[0] = '1'
        }

        if (arr[1] == '?') {
            if (arr[0] == '0')
                arr[1] = '9'
            else
                arr[1] = '1'
        }

        if (arr[3] == '?')
            arr[3] = '5'
        if (arr[4] == '?')
            arr[4] = '9'

        return String(arr)
    }
}
