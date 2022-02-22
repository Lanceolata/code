package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Question_0690_Employee_Importance {
    // Definition for Employee.
    class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    };

    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> m = new HashMap<>();
        for (Employee e : employees) {
            m.put(e.id, e);
        }
        return help(id, m);
    }

    private int help(int id, Map<Integer, Employee> m) {
        Employee employee = m.get(id);
        int res = employee.importance;
        for (int i : employee.subordinates) {
            res += help(i, m);
        }
        return res;
    }
}
