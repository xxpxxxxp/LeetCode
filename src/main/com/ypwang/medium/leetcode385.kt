package com.ypwang.medium

import java.util.*

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation*/
class NestedInteger {
    var int: Int? = null
    var inner: MutableList<NestedInteger>? = null
    var isInt: Boolean = false

    // Constructor initializes an empty nested list.
    constructor()

    // Constructor initializes a single integer.
    constructor(value: Int)

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    fun isInteger(): Boolean = isInt

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    fun getInteger(): Int? = int

    // Set this NestedInteger to hold a single integer.
    fun setInteger(value: Int): Unit {
        isInt = true
        int = value
    }

    // Set this NestedInteger to hold a nested list and adds a nested integer to it.
    fun add(ni: NestedInteger): Unit {
        if (inner == null) {
            inner = mutableListOf()
        }
        inner!!.add(ni)
        isInt = false
    }

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    fun getList(): List<NestedInteger>? = inner

    override fun toString(): String {
        return "Is int: $isInt\nInt val: $int\nList val: $inner\n"
    }
}

class Solution385 {
    fun deserialize(s: String): NestedInteger {
        fun readPositiveInt(q: Queue<Char>): Int {
            var rst = 0
            while (q.peek().isDigit()) {
                rst = rst * 10 + (q.poll() - '0')
            }
            return rst
        }

        fun readInt(q: Queue<Char>): Int {
            return if (q.peek() == '-') {
                q.poll()
                -readPositiveInt(q)
            } else {
                readPositiveInt(q)
            }
        }

        fun helper(q: Queue<Char>): NestedInteger {
            val c = q.peek()
            if (c.isDigit() || c == '-') {
                val n = NestedInteger()
                n.setInteger(readInt(q))
                return n
            } else if (c == '[') {
                q.poll()    // pop
                val r = NestedInteger()
                while (q.isNotEmpty()) {
                    when (q.peek()) {
                        ',' -> q.poll()
                        ']' -> {
                            q.poll()
                            return r
                        }
                        else -> r.add(helper(q))
                    }
                }

                return r
            }

            throw Exception("cannot happen")
        }

        return helper(LinkedList(("[$s]").toList())).getList()!!.first()
    }
}

fun main() {
    println(Solution385().deserialize("[]"))
    println(Solution385().deserialize("-1"))
}