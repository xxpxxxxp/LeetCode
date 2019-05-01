package com.ypwang.medium

class Solution721 {
    class DSU(val id: Int) {
        var parent = this

        fun findRoot(): DSU {
            if (parent != this) parent = parent.findRoot()
            return parent
        }

        fun union(another: DSU) {
            findRoot().parent = another.findRoot()
        }
    }

    fun accountsMerge(accounts: List<List<String>>): List<List<String>> {
        val idUser = mutableMapOf<Int, String>()
        val mailDSU = mutableMapOf<String, DSU>()

        for ((id, account) in accounts.withIndex()) {
            val dsu = DSU(id)
            idUser[id] = account.first()

            for (mail in account.drop(1)) {
                if (mail in mailDSU) {
                    dsu.union(mailDSU[mail]!!)
                } else {
                    mailDSU[mail] = dsu
                }
            }
        }

        val rst = mutableMapOf<Int, MutableSet<String>>()

        for (account in accounts) {
            for (mail in account.drop(1)) {
                val id = mailDSU[mail]!!.findRoot().id
                if (id !in rst) rst[id] = mutableSetOf()
                rst[id]!!.add(mail)
            }
        }

        return rst.map { listOf(idUser[it.key]!!) + it.value.sorted() }
    }
}

fun main() {
    println(Solution721().accountsMerge(listOf(
            listOf("John","johnsmith@mail.com","john_newyork@mail.com"),
            listOf("John","johnsmith@mail.com","john00@mail.com"),
            listOf("Mary","mary@mail.com"),
            listOf("John","johnnybravo@mail.com")
    )))
}