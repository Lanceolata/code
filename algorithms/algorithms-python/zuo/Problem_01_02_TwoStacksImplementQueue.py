#!/usr/bin/python
# coding: utf-8

'''
用两个栈实现队列,支持队列的基本操作(push pop peek)
'''

class TwoStacksQueue(object):
    def __init__(self):
        self.data_ = []
        self.help_ = []

    def push(self, value):
        self.data_.append(value)

    def pop(self):
        if not self.data_ and not self.help_:
            raise Exception("Queue is empty")
        if not self.help_:
            while self.data_:
                self.help_.append(self.data_.pop())
        return self.help_.pop()

    def peek(self):
        if not self.data_ and not self.help_:
            raise Exception("Queue is empty")
        if not self.help_:
            while self.data_:
                self.help_.append(self.data_.pop())
        return self.help_[-1]


def main():
    queue = TwoStacksQueue()
    queue.push(1)
    print(queue.peek())
    print(queue.pop())
    queue.push(2)
    queue.push(3)
    print(queue.peek())
    print(queue.pop())
    print(queue.peek())
    print(queue.pop())


if __name__ == '__main__':
    main()