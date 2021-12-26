package com.ypwang.medium

import java.util.*

class Solution2115 {
    fun findAllRecipes(recipes: Array<String>, ingredients: List<List<String>>, supplies: Array<String>): List<String> {
        val rps = recipes.toSet()
        val map = recipes.withIndex().associate { it.value to it.index }
        val deps = Array(recipes.size) { mutableSetOf<Int>() }
        val depsLookup = Array(recipes.size) { mutableSetOf<Int>() }

        val queue: Queue<Int> = LinkedList()
        for ((i, l) in ingredients.withIndex()) {
            val needs = l.intersect(rps)
            if (needs.isEmpty())
                queue.add(i)
            else {
                for (r in needs) {
                    deps[i].add(map[r]!!)
                    depsLookup[map[r]!!].add(i)
                }
            }
        }

        val sps = supplies.toMutableSet()
        val rst = mutableListOf<String>()
        while (queue.isNotEmpty()) {
            val i = queue.poll()
            if (ingredients[i].subtract(sps).isEmpty()) {
                rst.add(recipes[i])
                sps.add(recipes[i])

                for (j in depsLookup[i]) {
                    deps[j].remove(i)
                    if (deps[j].isEmpty())
                        queue.offer(j)
                }
            }
        }

        return rst
    }
}