package com.ypwang.medium

class FrequencyTracker {
    private val count = mutableMapOf<Int, Int>()
    private val freq = mutableMapOf<Int, Int>()

    fun add(number: Int) {
        if (number in count) {
            val c = count[number]!!
            count[number] = c+1
            freq[c] = freq[c]!! - 1
            if (freq[c] == 0)
                freq.remove(c)
            freq[c+1] = freq.getOrDefault(c+1, 0) + 1
        } else {
            count[number] = 1
            freq[1] = freq.getOrDefault(1, 0) + 1
        }
    }

    fun deleteOne(number: Int) {
        if (number in count) {
            val c = count[number]!!
            if (c == 1) {
                count.remove(number)
                freq[1] = freq[1]!! - 1
                if (freq[1] == 0)
                    freq.remove(1)
            } else {
                count[number] = c - 1
                freq[c] = freq[c]!! - 1
                if (freq[c] == 0)
                    freq.remove(c)
                freq[c-1] = freq.getOrDefault(c-1, 0) + 1
            }
        }
    }

    fun hasFrequency(frequency: Int): Boolean =
        frequency in freq
}

fun main() {
    val f = FrequencyTracker()
    f.add(5)
    f.add(5)
}