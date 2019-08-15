package com.ypwang.hard

import java.lang.StringBuilder
import java.util.*

class Solution736 {
    private fun readInt(iter: Queue<Char>): Int {
        var positive = true
        if (iter.peek() == '-') {
            iter.poll()
            positive = false
        }

        var v = 0
        while (iter.peek().isDigit()) {
            v = v * 10 + (iter.poll() - '0')
        }

        return v.let { if (positive) it else -it }
    }

    private fun readOp(iter: Queue<Char>): String {
        val sb = StringBuilder()
        while (iter.peek().isLetterOrDigit()) {
            sb.append(iter.poll())
        }

        return sb.toString()
    }

    private fun eval(expr: Queue<Char>, variable: MutableMap<String, Int>): Int {
        return when (expr.peek()) {
            '(' -> {
                expr.poll()
                val op = readOp(expr)
                assert(expr.poll() == ' ')
                when (op) {
                    "let" -> {
                        val rst = fun(): Int {
                            while (expr.peek().isLetter()) {
                                val name = readOp(expr)
                                when (expr.poll()) {
                                    ' ' -> {
                                        val value = eval(expr, variable.toMutableMap())
                                        variable[name] = value
                                        assert(expr.poll() == ' ')
                                    }
                                    ')' -> return variable[name]!!
                                }
                            }

                            val r = eval(expr, variable.toMutableMap())
                            assert(expr.poll() == ')')
                            return r
                        }()

                        rst
                    }
                    else -> {
                        val l = eval(expr, variable.toMutableMap())
                        assert(expr.poll() == ' ')
                        val r = eval(expr, variable.toMutableMap())
                        assert(expr.poll() == ')')
                        when (op) {
                            "add" -> l + r
                            "mult" -> l * r
                            else -> 0
                        }
                    }
                }
            }
            else -> {
                if (expr.peek().isLetter()) variable[readOp(expr)]!!
                else readInt(expr)
            }
        }
    }

    fun evaluate(expression: String): Int {
        if (expression.isEmpty()) return 0
        return eval(LinkedList(expression.toList()), mutableMapOf())
    }
}

fun main() {
    println(Solution736().evaluate("(add 1 2)"))
    println(Solution736().evaluate("(mult 3 (add 2 3))"))
    println(Solution736().evaluate("(let x 2 (mult x 5))"))
    println(Solution736().evaluate("(let x 2 (mult x (let x 3 y 4 (add x y))))"))
    println(Solution736().evaluate("(let x 3 x 2 x)"))
    println(Solution736().evaluate("(let x 1 y 2 x (add x y) (add x y))"))
    println(Solution736().evaluate("(let x 2 (add (let x 3 (let x 4 x)) x))"))
    println(Solution736().evaluate("(let a1 3 b2 (add a1 1) b2) "))
}