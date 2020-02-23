#!/usr/bin/python
# coding: utf-8

class MyHashSet(object):
    
    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.hashSet= [False] * 1000001
        

    def add(self, key):
        """
        :type key: int
        :rtype: void
        """
        self.hashSet[key] = True
        

    def remove(self, key):
        """
        :type key: int
        :rtype: void
        """
        self.hashSet[key] = False
        

    def contains(self, key):
        """
        Returns true if this set contains the specified element
        :type key: int
        :rtype: bool
        """
        return self.hashSet[key]