package com.ypwang.hard

class Solution1948 {
    private class Node(
        val name: String,
        var subs: MutableMap<String, Node> = mutableMapOf(),
        var deleted: Boolean = false
    )

    private fun addPath(node: Node, path: List<String>) {
        var cur = node
        for (p in path) {
            if (p !in cur.subs)
                cur.subs[p] = Node(p)

            cur = cur.subs[p]!!
        }
    }

    private fun getPath(node: Node, path: MutableList<String>, rst: MutableList<List<String>>) {
        if (node.deleted)
            return

        path.add(node.name)
        rst.add(path.toList())

        for (n in node.subs)
            getPath(n.value, path, rst)

        path.removeAt(path.lastIndex)
    }

    private val seen = mutableMapOf<String, Node>()
    private fun dedup(node: Node): String {
        val subFolder = StringBuilder()
        for ((_, n) in node.subs) {
            subFolder.append(dedup(n))
            subFolder.append("+")
        }

        val s = subFolder.toString()
        if (node.subs.isNotEmpty()) {
            if (s in seen) {
                seen[s]!!.deleted = true
                node.deleted = true
            } else {
                seen[s] = node
            }
        }

        return node.name + s
    }

    fun deleteDuplicateFolder(paths: List<List<String>>): List<List<String>> {
        val root = Node("")
        for (ps in paths)
            addPath(root, ps)

        dedup(root)

        val path = mutableListOf<String>()
        val rst = mutableListOf<List<String>>()
        for (sub in root.subs)
            getPath(sub.value, path, rst)

        return rst
    }
}