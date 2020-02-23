#!/usr/bin/python
# coding: utf-8

'''
一个栈中元素的类型为整型，现在想将栈从顶到底按从大到小的顺序排序，只许申请一个栈。除此之外，可以申请新的变量，单不能申请额外的数据结构。
'''

def SortStackByStack(stack):
    help = []
    while stack:
        value = stack.pop()
        while help and help[-1] < value:
            stack.append(help.pop())
        help.append(value)

    while help:
        stack.append(help.pop())


def main():
    stack = [3, 1, 6, 2, 5, 4]
    SortStackByStack(stack)
    print(stack)


if __name__ == '__main__':
    main()