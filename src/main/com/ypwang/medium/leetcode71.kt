package com.ypwang.medium

import java.util.*

class Solution71 {
    fun simplifyPath(path: String): String {
        val ps = path.split("/")

        val stack = Stack<String>()

        for (p in ps) {
            when (p) {
                "" -> {} // do nothing
                "." -> {}
                ".." -> if (stack.isNotEmpty()) {
                    stack.pop()
                }
                else -> stack.add(p)
            }
        }

        val can = stack.joinToString("/")
        return "/$can"
    }
}

fun main(args: Array<String>) {
    println(Solution71().simplifyPath("/home/"))
    println(Solution71().simplifyPath("/../"))
    println(Solution71().simplifyPath("/home//foo/"))
    println(Solution71().simplifyPath("/a/./b/../../c/"))
    println(Solution71().simplifyPath("/a/../../b/../c//.//"))
    println(Solution71().simplifyPath("/a//b////c/d//././/.."))
}