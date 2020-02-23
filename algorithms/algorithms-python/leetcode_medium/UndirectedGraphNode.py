#!/usr/bin/python
# coding: utf-8

class UndirectedGraphNode:
    def __init__(self, x):
        self.label = x
        self.neighbors = []