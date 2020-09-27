package com.ypwang.medium

class ThroneInheritance(val kingName: String) {
    private val relations = mutableMapOf<String, MutableList<String>>()
    private val reversed = mutableMapOf<String, String>()
    private val deaths = mutableSetOf<String>()

    fun birth(parentName: String, childName: String) {
        relations.getOrPut(parentName, { mutableListOf() }).add(childName)
        reversed[childName] = parentName
    }

    fun death(name: String) {
        deaths.add(name)
    }

    fun getInheritanceOrder(): List<String> {
        val rst = mutableListOf<String>()
        val set = mutableSetOf<String>()

        fun successor(x: String, order: Set<String>): String? {
            val childrenNotIn = relations[x]?.subtract(order)

            if (childrenNotIn != null && childrenNotIn.isNotEmpty())
                return childrenNotIn.first()

            return if (x == kingName) null else successor(reversed[x]!!, order)
        }

        var current: String? = kingName
        while (current != null) {
            rst.add(current)
            set.add(current)

            current = successor(current, set)
        }

        return rst.filter { it !in deaths }
    }
}