package com.ypwang.medium

import java.util.*

class Solution1233 {
    class FolderTree(val path: String, var isFolder: Boolean = false, val subFolder: MutableMap<String, FolderTree> = mutableMapOf())

    fun removeSubfolders(folder: Array<String>): List<String> {
        val root = FolderTree("")

        for (f in folder) {
            var r = root
            for (p in f.split('/').filter { it.isNotEmpty() }) {
                if (p !in r.subFolder) r.subFolder[p] = FolderTree(p)
                r = r.subFolder[p]!!
                if (r.isFolder) break
            }
            r.isFolder = true
        }

        // bfs
        val bfs: Queue<Pair<String, FolderTree>> = LinkedList()
        for (sub in root.subFolder) bfs.offer("" to sub.value)
        val rst = mutableListOf<String>()

        while (bfs.isNotEmpty()) {
            val (pre, r) = bfs.poll()
            if (r.isFolder) rst.add("$pre/${r.path}")
            else {
                val cur = "$pre/${r.path}"
                for (sub in r.subFolder) {
                    bfs.offer(cur to sub.value)
                }
            }
        }

        return rst
    }
}

fun main() {
    println(Solution1233().removeSubfolders(arrayOf("/a","/a/b","/c/d","/c/d/e","/c/f")))
    println(Solution1233().removeSubfolders(arrayOf("/a","/a/b/c","/a/b/d")))
    println(Solution1233().removeSubfolders(arrayOf("/a/b/c","/a/b/ca","/a/b/d")))
}