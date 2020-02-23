#!/usr/bin/python
# coding: utf-8

def readBinaryWatch(self, num):
    # bin返回的时字符串
    return ['%d:%02d' % (h, m)
            for h in range(12) for m in range(60)
            if (bin(h) + bin(m)).count('1') == num]
