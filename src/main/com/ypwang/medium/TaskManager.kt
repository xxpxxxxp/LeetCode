package com.ypwang.medium

import java.util.TreeMap

class TaskManager(tasks: List<List<Int>>) {
    data class Task(val userId: Int, val taskId: Int, var priority: Int) : Comparable<Task> {
        override fun compareTo(other: Task): Int =
            if (this.priority != other.priority)
                other.priority.compareTo(this.priority)
            else other.taskId.compareTo(this.taskId)
    }

    private val tasks = TreeMap<Task, Int>()
    private val map = mutableMapOf<Int, Task>()

    init {
        for ((u, t, p) in tasks)
            add(u, t, p)
    }

    fun add(userId: Int, taskId: Int, priority: Int) {
        val task = Task(userId, taskId, priority)
        tasks.put(task, userId)
        map.put(taskId, task)
    }

    fun edit(taskId: Int, newPriority: Int) {
        val task = map[taskId]
        if (task != null) {
            tasks.remove(task)
            task.priority = newPriority
            tasks.put(task, task.userId)
        }
    }

    fun rmv(taskId: Int) {
        val task = map[taskId]
        if (task != null) {
            tasks.remove(task)
            map.remove(taskId)
        }
    }

    fun execTop(): Int {
        if (tasks.isEmpty())
            return -1

        val top = tasks.firstKey()
        tasks.remove(top)
        map.remove(top.taskId)
        return top.userId
    }
}
