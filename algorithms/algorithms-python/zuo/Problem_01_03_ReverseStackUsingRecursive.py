#!/usr/bin/python
# coding: utf-8

'''
一个栈一次压入1,2,3,4,5，那么从栈顶到栈底分别为5,4,3,2,1。将这个栈转置后，从栈顶到栈底为1,2,3,4,5，也就是实现栈中元素的逆序，但是只能用递归函数来实现，不能用其他数据结构。
'''

def get_and_remove_last(stack):
    value = stack.pop()
    if not stack:
        return value
    else:
        last = get_and_remove_last(stack)
        stack.append(value)
        return last


def reverse(stack):
    if not stack:
        return None

    last = get_and_remove_last(stack)
    reverse(stack)
    stack.append(last)


def main():
    stack = [1, 2, 3, 4, 5]
    reverse(stack)
    print(stack)


if __name__ == '__main__':
    main()
