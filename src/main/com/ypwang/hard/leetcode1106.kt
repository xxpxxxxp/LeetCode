package com.ypwang.hard

import java.util.*

class Solution1106 {
    interface BoolOp {
        fun eval(): Boolean
    }

    class True: BoolOp {
        override fun eval(): Boolean = true
    }

    class False: BoolOp {
        override fun eval(): Boolean = false
    }

    class NoOp(private val inner: BoolOp): BoolOp {
        override fun eval(): Boolean = !inner.eval()
    }

    class AndOp(private val inner: List<BoolOp>): BoolOp {
        override fun eval(): Boolean = inner.all { it.eval() }
    }

    class OrOp(private val inner: List<BoolOp>): BoolOp {
        override fun eval(): Boolean = inner.any { it.eval() }
    }

    fun parseExpr(q: Queue<Char>): BoolOp {
        // 递归下降法
        return when (q.poll()) {
            't' -> True()
            'f' -> False()
            '!' -> {
                assert(q.poll() == '(')
                val t = NoOp(parseExpr(q))
                assert(q.poll() == ')')
                t
            }
            '|' -> {
                assert(q.poll() == '(')
                val t = mutableListOf<BoolOp>()
                do {
                    t.add(parseExpr(q))
                } while (q.poll() == ',')

                OrOp(t)
            }
            '&' -> {
                assert(q.poll() == '(')
                val t = mutableListOf<BoolOp>()
                do {
                    t.add(parseExpr(q))
                } while (q.poll() == ',')

                AndOp(t)
            }
            else -> throw Exception("invalid")
        }
    }

    fun parseBoolExpr(expression: String): Boolean = parseExpr(LinkedList(expression.toList())).eval()
}

fun main() {
    println(Solution1106().parseBoolExpr("!(f)"))
    println(Solution1106().parseBoolExpr("|(f,t)"))
    println(Solution1106().parseBoolExpr("&(t,f)"))
    println(Solution1106().parseBoolExpr("|(&(t,f,t),!(t))"))
}