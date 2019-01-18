package com.ypwang.medium

class Solution950 {
    fun deckRevealedIncreasing(deck: IntArray): IntArray {
        val indices = MutableList(deck.size){it}
        val reorder = mutableListOf<Int>()

        while (indices.isNotEmpty()) {
            reorder.add(indices.first())
            indices.removeAt(0)
            if (indices.isNotEmpty()) {
                indices.add(indices.first())
                indices.removeAt(0)
            }
        }

        return reorder.zip(deck.sorted()).sortedBy { it.first }.map { it.second }.toIntArray()
    }
}