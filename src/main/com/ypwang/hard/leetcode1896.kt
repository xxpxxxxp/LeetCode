package com.ypwang.hard

import java.util.*

class Solution1896 {
    abstract class BooleanExpr {
        private var asBoolean: Optional<Boolean> = Optional.empty<Boolean>()

        fun toBoolean(): Boolean {
            if (!asBoolean.isPresent)
                asBoolean = Optional.of(evaluate())

            return asBoolean.get()
        }

        abstract fun evaluate(): Boolean
        abstract fun flip(): Int
    }

    class Primitive(private val `val`: Boolean): BooleanExpr() {
        override fun evaluate(): Boolean = `val`
        override fun flip(): Int = 1
    }

    class OrExpr(private val left: BooleanExpr, private val right: BooleanExpr): BooleanExpr() {
        override fun evaluate(): Boolean = left.toBoolean() || right.toBoolean()
        override fun flip(): Int {
            val bl = left.toBoolean()
            val br = right.toBoolean()

            return if (!bl && !br)
                minOf(left.flip(), right.flip())
            else if (bl && br)
                1 + minOf(left.flip(), right.flip())
            else 1
        }
    }

    class AndExpr(private val left: BooleanExpr, private val right: BooleanExpr): BooleanExpr() {
        override fun evaluate(): Boolean = left.toBoolean() && right.toBoolean()
        override fun flip(): Int {
            val bl = left.toBoolean()
            val br = right.toBoolean()

            return if (!bl && !br)
                1 + minOf(left.flip(), right.flip())
            else if (bl && br)
                minOf(left.flip(), right.flip())
            else 1
        }
    }

    class CharIterator(private val str: String): Iterator<Char> {
        private var idx = 0

        override fun hasNext(): Boolean = idx < str.length

        override fun next(): Char = str[idx++]

        fun peek(): Char = str[idx]
    }

    private fun parse(exp: CharIterator): BooleanExpr {
        var cur: BooleanExpr? = null
        var op = 0      // 0 or, 1 and
        while (exp.hasNext()) {
            when (exp.peek()) {
                '(' -> {
                    exp.next()
                    val n = parse(exp)
                    cur = if (cur == null)
                        n
                    else if (op == 0)
                        OrExpr(cur, n)
                    else
                        AndExpr(cur, n)
                }
                ')' -> {
                    exp.next()
                    return cur!!
                }
                in '0'..'1' -> {
                    val n = Primitive(exp.next() == '1')
                    cur = if (cur == null)
                        n
                    else if (op == 0)
                        OrExpr(cur, n)
                    else
                        AndExpr(cur, n)
                }
                '&' -> {
                    exp.next()
                    op = 1
                }
                '|' -> {
                    exp.next()
                    op = 0
                }
            }
        }

        return cur!!
    }

    fun minOperationsToFlip(expression: String): Int {
        return parse(CharIterator(expression)).flip()
    }
}

fun main() {
    println(Solution1896().minOperationsToFlip("1&(0|1)"))
    println(Solution1896().minOperationsToFlip("(0&0)&(0&0&0)"))
    println(Solution1896().minOperationsToFlip("(0|(1|0&1))"))
}