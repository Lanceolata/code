#!/usr/bin/python
# coding: utf-8

# Below is the interface for Iterator, which is already defined for you.
#
# class Iterator(object):
#     def __init__(self, nums):
#         """
#         Initializes an iterator object to the beginning of a list.
#         :type nums: List[int]
#         """
#
#     def hasNext(self):
#         """
#         Returns true if the iteration has more elements.
#         :rtype: bool
#         """
#
#     def next(self):
#         """
#         Returns the next element in the iteration.
#         :rtype: int
#         """

class PeekingIterator(object):
    def __init__(self, iterator):
        """
        Initialize your data structure here.
        :type iterator: Iterator
        """
        self.it = iterator
        self.cache = 0
        self.hasPeeked = False
        

    def peek(self):
        """
        Returns the next element in the iteration without advancing the iterator.
        :rtype: int
        """
        if not self.hasPeeked:
            self.hasPeeked = True
            self.cache = self.it.next()
        return self.cache
        

    def next(self):
        """
        :rtype: int
        """
        if self.hasPeeked:
            self.hasPeeked = False
            return self.cache
        else:
            return self.it.next()
        

    def hasNext(self):
        """
        :rtype: bool
        """
        if self.hasPeeked:
            return True
        else:
            return self.it.hasNext()