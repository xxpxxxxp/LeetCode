package com.ypwang.medium

class Bank(private val balance: LongArray) {
    fun transfer(account1: Int, account2: Int, money: Long): Boolean {
        val a1 = account1-1
        val a2 = account2-1
        if (a1 !in balance.indices || balance[a1] < money || a2 !in balance.indices)
            return false

        balance[a1] -= money
        balance[a2] += money

        return true
    }

    fun deposit(account: Int, money: Long): Boolean {
        val a = account-1
        if (a !in balance.indices)
            return false

        balance[a] += money
        return true
    }

    fun withdraw(account: Int, money: Long): Boolean {
        val a = account-1
        if (a !in balance.indices || balance[a] < money)
            return false

        balance[a] -= money
        return true
    }
}