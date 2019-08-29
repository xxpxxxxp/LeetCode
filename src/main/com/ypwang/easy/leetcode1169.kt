package com.ypwang.easy

class Solution1169 {
    data class Transaction(val record: String) {
        val name: String
        val time: Int
        val amount: Int
        val city: String
        var placeholder = false

        init {
            val (n, t, a, c) = record.split(',')
            name = n
            time = t.toInt()
            amount = a.toInt()
            city = c
        }
    }

    fun invalidTransactions(transactions: Array<String>): List<String> {
        val accounts = mutableMapOf<String, MutableList<Transaction>>()

        val rst = mutableListOf<String>()
        for (transaction in transactions) {
            val t = Transaction(transaction)
            if (t.amount > 1000) {
                t.placeholder = true
                rst.add(transaction)
            }

            if (t.name in accounts) {
                var hit = false

                for (e in accounts[t.name]!!) {
                    if (Math.abs(e.time - t.time) <= 60 && e.city != t.city) {
                        hit = true
                        if (!e.placeholder) {
                            e.placeholder = true
                            rst.add(e.record)
                        }
                    }
                }

                if (hit && !t.placeholder) {
                    t.placeholder = true
                    rst.add(transaction)
                }
            } else {
                accounts[t.name] = mutableListOf()
            }
            accounts[t.name]!!.add(t)
        }

        return rst
    }
}

fun main() {
    println(Solution1169().invalidTransactions(arrayOf("lee,886,1785,beijing","alex,763,1157,amsterdam","lee,277,129,amsterdam","bob,770,105,amsterdam","lee,603,926,amsterdam","chalicefy,476,50,budapest","lee,924,859,barcelona","alex,302,590,amsterdam","alex,397,1464,barcelona","bob,412,1404,amsterdam","lee,505,849,budapest")))
}