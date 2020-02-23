#!/usr/bin/python
# coding: utf-8

class MinStack(object):
    def __init__(self):
        """
        initialize your data structure here.
        """
        self.stack = []
        self.min = 0

    def push(self, x):
        """
        :type x: int
        :rtype: void
        """
        if not self.stack:
            self.stack.append(0)
            self.min = x
        else:
            self.stack.append(x - self.min)
            if x < self.min:
                self.min = x
                                                                                            

    def pop(self):
        """
        :rtype: void
        """
        if not self.stack:
            return
        pop = self.stack.pop();
        if pop < 0:
            self.min = self.min - pop


    def top(self):
        """
        :rtype: int
        """
        top = self.stack[-1]
        if top > 0:
            return top + self.min
        else:
            return self.min
                                            

    def getMin(self):
        """
        :rtype: int
        """
        return self.min
