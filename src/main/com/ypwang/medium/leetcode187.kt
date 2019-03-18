package com.ypwang.medium

class Solution187 {
    fun findRepeatedDnaSequences(s: String): List<String> {
        if (s.length < 11) {
            return listOf()
        }

        val m = mapOf('A' to 0b00, 'C' to 0b01, 'G' to 0b10, 'T' to 0b11)

        val appeared = mutableSetOf<Int>()
        val catched = mutableSetOf<Int>()

        var dna = 0
        // the first one
        for (i in 0 until 10) {
            dna = (dna shl 2) or m.getValue(s[i])
        }
        appeared.add(dna)

        for (i in 10 until s.length) {
            dna = ((dna shl 2) or m.getValue(s[i])) and 0xFFFFF
            if (dna in appeared)
                catched.add(dna)

            appeared.add(dna)
        }

        return catched.map {
            val t = Array(10){'0'}
            for (i in 9 downTo 0) {
                t[9 - i] =
                when ((it shr i * 2) and 0x3) {
                    0b00 -> 'A'
                    0b01 -> 'C'
                    0b10 -> 'G'
                    0b11 -> 'T'
                    else -> '0'
                }
            }
            t.joinToString("")
        }
    }
}

fun main() {
    println(Solution187().findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"))
}