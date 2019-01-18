package com.ypwang.easy;

import java.util.*;

// Employee info
class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
};

class Solution690 {
    public int getImportanceHelper(Employee e, Map<Integer, Employee> employees) {
        int importance = e.importance;
        if (e.subordinates != null) {
            for (Integer sub : e.subordinates) {
                importance += getImportanceHelper(employees.get(sub), employees);
            }
        }

        return importance;
    }

    public int getImportance(List<Employee> employees, int id) {
        if (employees == null) {
            return 0;
        }

        Map<Integer, Employee> eps = new HashMap<>();
        for (Employee e : employees) {
            eps.put(e.id, e);
        }

        return getImportanceHelper(eps.get(id), eps);
    }
}