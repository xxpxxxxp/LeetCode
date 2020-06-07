package com.ypwang.medium

class BrowserHistory(homepage: String) {
    private val history = mutableListOf<String>(homepage)
    private var idx = 1
    private var cap = 1

    fun visit(url: String) {
        if (history.size == idx) {
            history.add(url)
        } else {
            history[idx] = url
        }
        idx++
        cap = idx
    }

    fun back(steps: Int): String {
        return if (steps >= idx) {
            idx = 1
            history[0]
        } else {
            idx -= steps
            history[idx-1]
        }
    }

    fun forward(steps: Int): String {
        if (idx + steps >= cap)
            idx = cap
        else
            idx += steps

        return history[idx-1]
    }
}