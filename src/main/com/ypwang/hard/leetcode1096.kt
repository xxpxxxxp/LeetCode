package com.ypwang.hard

import java.lang.StringBuilder
import java.util.*

class Solution1096 {
    interface WordSet {
        fun sortedWords(): List<String>
    }

    class SingleWord(val word: String): WordSet {
        override fun sortedWords(): List<String> = listOf(word)
    }

    class SequenceWordSet(val subset: List<WordSet>): WordSet {
        override fun sortedWords(): List<String> = subset.flatMap { it.sortedWords() }.toSortedSet().toList()
    }

    class CrossWordSet(val subset: List<WordSet>): WordSet {
        override fun sortedWords(): List<String> = subset.map { it.sortedWords() }.reduce { acc, list -> acc.flatMap { a -> list.map { b -> a + b } } }.sorted()
    }

    private fun parseSingle(source: Queue<Char>): WordSet {
        val sb = StringBuilder()
        while (source.peek() != null && source.peek() in 'a'..'z') sb.append(source.poll())
        return SingleWord(sb.toString())
    }

    private fun parseSequence(source: Queue<Char>): WordSet {
        assert(source.poll() == '{')
        val inner = mutableListOf<WordSet>()
        do {
            inner.add(parse(source))
        } while (source.poll() != '}')
        return SequenceWordSet(inner)
    }

    private fun parse(source: Queue<Char>): WordSet {
        // 递归下降
        val cross = mutableListOf<WordSet>()
        label@while (true) {
            when (source.peek()) {
                null, ',', '}' -> break@label
                in 'a'..'z' -> cross.add(parseSingle(source))
                '{' -> cross.add(parseSequence(source))
            }
        }

        return if (cross.size == 1) cross.first() else CrossWordSet(cross)
    }

    fun braceExpansionII(expression: String): List<String> =
        parse(LinkedList(expression.toList())).sortedWords()
}

fun main() {
    println(Solution1096().braceExpansionII("n{{c,g},{h,j},l}a{{a,{x,ia,o},w},er,a{x,ia,o}w}n"))
}