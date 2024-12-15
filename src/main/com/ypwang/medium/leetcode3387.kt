package com.ypwang.medium

import java.util.LinkedList
import java.util.Queue

class Solution3387 {
    fun maxAmount(initialCurrency: String, pairs1: List<List<String>>, rates1: DoubleArray, pairs2: List<List<String>>, rates2: DoubleArray): Double {
        val day1Amounts = getMaxAmounts(buildGraph(pairs1, rates1), mutableMapOf(initialCurrency to 1.0))
        val day2Amounts = getMaxAmounts(buildGraph(pairs2, rates2), day1Amounts)

        return day2Amounts.getOrDefault(initialCurrency, 0.0)
    }

    private fun buildGraph(pairs: List<List<String>>, rates: DoubleArray): Map<String, MutableMap<String, Double>> {
        val graph = mutableMapOf<String, MutableMap<String, Double>>()
        for (i in pairs.indices) {
            val (start, target) = pairs[i]
            val rate = rates[i]

            graph.getOrPut(start) { mutableMapOf() }[target] = rate
            graph.getOrPut(target) { mutableMapOf() }[start] = 1 / rate
        }
        return graph
    }

    private fun getMaxAmounts(graph: Map<String, MutableMap<String, Double>>, initialAmounts: MutableMap<String, Double>): MutableMap<String, Double> {
        val maxAmounts = initialAmounts
        val queue: Queue<String> = LinkedList(initialAmounts.keys)

        while (queue.isNotEmpty()) {
            val current = queue.poll()
            val currentAmount = maxAmounts.getOrDefault(current, 0.0)

            for ((neighbor, rate) in graph.getOrDefault(current, mutableMapOf())) {
                val newAmount = currentAmount * rate

                if (newAmount > maxAmounts.getOrDefault(neighbor, 0.0)) {
                    maxAmounts[neighbor] = newAmount
                    queue.offer(neighbor)
                }
            }
        }

        return maxAmounts
    }
}
