#!/usr/bin/python
# coding: utf-8

class Solution(object):
    def findSubstring(self, s, words):
        """
        :type s: str
        :type words: List[str]
        :rtype: List[int]
        """
        res = []
        if not s or not words:
            return res
        n, cnt, size = len(s), len(words), len(words[0])
        m1 = {}
        for w in words:
            if w not in m1:
                m1[w] = 0
            m1[w] += 1
        for i in range(size):
            left, count, m2 = i, 0, {}
            for j in range(i, n - size + 1, size):
                t = s[j:j + size]
                if t in m1:
                    if t not in m2:
                        m2[t] = 0
                    m2[t] += 1
                    if m2[t] <= m1[t]:
                        count += 1
                    else:
                        while m2[t] > m1[t]:
                            t2 = s[left : left + size]
                            m2[t2] -= 1
                            if t2 != t:
                                count -= 1
                            left += size
                    if count == cnt:
                        res.append(left)
                        m2[s[left : left + size]] -= 1
                        count -= 1
                        left += size
                else:
                    m2.clear()
                    left = j + size
                    count = 0
        return res
