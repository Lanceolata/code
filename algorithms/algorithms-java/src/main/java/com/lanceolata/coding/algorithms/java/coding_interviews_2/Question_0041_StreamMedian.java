package com.lanceolata.coding.algorithms.java.coding_interviews_2;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Question_0041_StreamMedian {
    PriorityQueue<Integer> min = new PriorityQueue<Integer>(20, new Comparator<Integer>(){
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1 - o2;
        }
    });
    PriorityQueue<Integer> max = new PriorityQueue<Integer>(20, new Comparator<Integer>(){
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    });

    public void Insert(Integer num) {
        if(max.size() == min.size()) {
            if(min.size() != 0 && num > min.peek()) {
                int tmp = min.remove();
                max.add(tmp);
                min.add(num);
            }
            else {
                max.add(num);
            }
        }
        else {
            if(num < max.peek()) {
                int tmp = max.remove();
                min.add(tmp);
                max.add(num);
            }
            else {
                min.add(num);
            }
        }
    }

    public Double GetMedian() {
        if(min.size() < max.size()) {
            return (double)max.peek();
        }
        return (min.peek() + max.peek()) / 2.0;
    }

    LinkedList<Integer> list = new LinkedList<Integer>();

    public void Insert2(Integer num) {
        if (list.size()==0||num < list.getFirst()) {
            list.addFirst(num);
        } else {
            boolean insertFlag = false;
            for (Integer e : list) {
                if (num < e) {
                    int index = list.indexOf(e);
                    list.add(index, num);
                    insertFlag = true;
                    break;
                }
            }
            if (!insertFlag) {
                list.addLast(num);
            }
        }

    }

    public Double GetMedian2() {
        if (list.size() == 0) {
            return null;
        }

        if (list.size() % 2 == 0) {
            int i = list.size() / 2;
            Double a = Double.valueOf(list.get(i - 1) + list.get(i));
            return a / 2;
        }
        list.get(0);
        Double b = Double.valueOf(list.get((list.size() + 1) / 2 - 1));
        return Double.valueOf(list.get((list.size() + 1) / 2 - 1));
    }
}
