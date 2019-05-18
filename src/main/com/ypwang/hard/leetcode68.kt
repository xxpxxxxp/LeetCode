package com.ypwang.hard

class Solution68 {
    fun fullJustify(words: Array<String>, maxWidth: Int): List<String> {
        val rst = mutableListOf<String>()

        val buffer = mutableListOf<String>()
        var count = 0


        for (word in words) {
            if (count + word.length > maxWidth) {
                val builder = StringBuilder()
                // let's build the string
                var spaces = maxWidth - count + buffer.size
                var split = buffer.size - 1
                for (w in buffer) {
                    builder.append(w)
                    if (split != 0) {
                        val sp = (spaces + split - 1) / split
                        for (j in 0 until sp) builder.append(' ')
                        spaces -= sp
                        split -= 1
                    }
                }

                if (spaces != 0) (0 until spaces).forEach { _ -> builder.append(' ') }

                rst.add(builder.toString())

                buffer.clear()
                count = 0
            }

            buffer.add(word)
            count += word.length + 1
        }

        val builder = StringBuilder()
        count = 0
        if (buffer.isNotEmpty()) {
            for (word in buffer) {
                builder.append(word)
                count += word.length
                if (count < maxWidth) {
                    builder.append(' ')
                    count += 1
                }
            }

            for (i in count until maxWidth)
                builder.append(' ')

            rst.add(builder.toString())
        }

        return rst
    }
}

fun main() {
    println(Solution68().fullJustify(arrayOf("ask","not","what","your","country","can","do","for","you","ask","what","you","can","do","for","your","country"), 16))
}