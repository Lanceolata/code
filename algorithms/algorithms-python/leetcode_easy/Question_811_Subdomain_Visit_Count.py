#!/usr/bin/python
# coding: utf-8

class Solution(object):
    def subdomainVisits(self, cpdomains):
        """
        :type cpdomains: List[str]
        :rtype: List[str]
        """
        m = {}
        for dom in cpdomains:
            l = dom.split()
            num = int(l[0])
            ind = 0
            while ind != -1:
                d = l[1][ind:]
                if d not in m:
                    m[d] = 0
                m[d] += num
                ind = l[1].find(".", ind)
                if ind != -1:
                    ind += 1
        
        res = []
        for k, v in m.items():
            res.append("%d %s" % (v, k))
        return res