#!/usr/bin/python
# coding: utf-8

'''
实现一个特殊的栈，在实现栈的基本功能的基础上，再实现返回栈中最小元素的操作
'''

class MinStack1(object):
    def __init__(self):
        self._data = []
        self._min = []

    def push(self, value):
        if not self._data:
            self._min.append(value)
        elif value <= self.getmin():
            self._min.append(value)
        self._data.append(value)

    def pop(self):
        if not self._data:
            raise Exception("Stack is empty")
        value = self._data.pop()
        if value == self.getmin():
            self._min.pop()
        return value

    def getmin(self):
        if not self._min:
            raise Exception("Stack is empty")
        return self._min[-1]


class MinStack2(object):
    def __init__(self):
        self._data = []
        self._min = []

    def push(self, value):
        if not self._data:
            self._min.append(value)
        elif value < self.getmin():
            self._min.append(value)
        else:
            self._min.append(self.getmin())
        self._data.append(value)

    def pop(self):
        if not self._data:
           raise Exception("Stack is empty") 
        self._min.pop()
        return self._data.pop()

    def getmin(self):
        if not self._min:
            raise Exception("Stack is empty")
        return self._min[-1]


def main():
    stack1 = MinStack1()
    stack1.push(3)
    print(stack1.getmin())
    stack1.push(4)
    print(stack1.getmin())
    stack1.push(1)
    print(stack1.getmin())
    print(stack1.pop())
    print(stack1.getmin())

	print('-----------------------')
	
    stack2 = MinStack2()
    stack2.push(3)
    print(stack2.getmin())
    stack2.push(4)
    print(stack2.getmin())
    stack2.push(1)
    print(stack2.getmin())
    print(stack2.pop())
    print(stack2.getmin())


if __name__ == '__main__':
    main()