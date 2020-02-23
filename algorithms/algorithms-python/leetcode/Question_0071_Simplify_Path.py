#!/usr/bin/python
# coding: utf-8

class Solution(object):
    def simplifyPath(self, path):
        """
        :type path: str
        :rtype: str
        """
        items = path.split("/")
        res = []
        for i in items:
            if i == "." or not i:
                continue
            elif i == "..":
                if res:
                    res.pop()
            else:
                res.append(i)
        return "/" + "/".join(res)
