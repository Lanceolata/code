#!/usr/bin/python
# coding: utf-8

'''
有一个数组arr和一个大小为w的窗口从数组的最左边滑到最右边，窗口每次向右边滑一个位置。
如果数组长度为n，窗口大小为w，则一共产生n-w+1个窗口的最大值。
'''

from collections import deque


def getMaxWindow(arr, w):
    if not arr or w < 0 or len(arr) < w:
        return None

    qmax = deque()
    res = []
    for i, v in enumerate(arr):
        while qmax and arr[qmax[-1]] <= arr[i]:
            qmax.pop()
        qmax.append(i)
        if qmax[0] == i - w:
            qmax.popleft()
        if i >= w - 1:
            res.append(arr[qmax[0]])
    return res


def main():
    arr = [4, 3, 5, 4, 3, 3, 6, 7]
    w = 3
    print(getMaxWindow(arr, w))


if __name__ == "__main__":
    main()