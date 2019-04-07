package com.ypwang.medium

class Solution468 {
    private fun validIPv4(IP: String): Boolean {
        val seg = IP.split('.')
        if (seg.size != 4)
            return false

        for (s in seg) {
            if (s.startsWith('0')) {
                if (s.length > 1)
                    return false
            }
            else {
                if (s.any { !it.isDigit() })
                    return false

                val t = s.toIntOrNull()
                if (t == null || t < 0 || t > 255)
                    return false
            }
        }
        return true
    }

    fun validIPAddress(IP: String): String {
        if (IP.contains('.')) {
            if (validIPv4(IP))
                return "IPv4"
        }
        if (IP.contains(':')) {
            if (validIPv6(IP))
                return "IPv6"
        }

        return "Neither"
    }

    private fun validIPv6(IP: String): Boolean {
        val seg = IP.split(':')
        if (seg.size != 8)
            return false

        for (s in seg) {
            if (s.isEmpty() || s.length > 4)
                return false
            if (!s.all { it.isDigit() || it in 'a'..'f' || it in 'A'..'F' })
                return false
        }
        return true
    }
}

fun main() {
    println(Solution468().validIPAddress("2001:db8:85a3:0::8a2E:0370:7334"))
}