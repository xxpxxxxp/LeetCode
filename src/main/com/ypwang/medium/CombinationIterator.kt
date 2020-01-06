package com.ypwang.medium

class SingleStringIterator(val s: String): Iterator<String> {
    private var visited = false
    override fun hasNext(): Boolean = !visited
    override fun next(): String {
        visited = true
        return s;
    }
}

class CharStringIterator(val s: String): Iterator<String> {
    private var idx = 0
    override fun hasNext() = idx < s.length
    override fun next(): String = s[idx++].toString()
}

class CombinationIterator(val characters: String, val combinationLength: Int): Iterator<String> {
    private val left by lazy { makeIterator(characters.substring(1), combinationLength-1) }
    private val right by lazy { makeIterator(characters.substring(1), combinationLength) }

    companion object {
        fun makeIterator(characters: String, combinationLength: Int): Iterator<String> {
            if (combinationLength == 0) return SingleStringIterator("")
            if (characters.length == combinationLength) return SingleStringIterator(characters)
            if (combinationLength == 1) return CharStringIterator(characters)
            return CombinationIterator(characters, combinationLength)
        }
    }

    override fun hasNext(): Boolean = left.hasNext() || right.hasNext()
    override fun next(): String = if (left.hasNext()) "${characters[0]}${left.next()}" else right.next()
}

fun main() {
    val iterator = CombinationIterator("chp", 1) // creates the iterator.
    println(iterator.hasNext()) // returns "ab"
    println(iterator.next()) // returns "ab"
    println(iterator.hasNext()) // returns true
    println(iterator.hasNext()) // returns true
    println(iterator.next()) // returns "ac"
    println(iterator.next()) // returns "ac"
    println(iterator.hasNext()) // returns true
    println(iterator.hasNext()) // returns true
    println(iterator.hasNext()) // returns true
    println(iterator.hasNext()) // returns true
}