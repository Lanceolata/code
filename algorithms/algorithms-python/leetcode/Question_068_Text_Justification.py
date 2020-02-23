#!/usr/bin/python
# coding: utf-8

class Solution(object):
    def fullJustify(self, words, maxWidth):
        """
        :type words: List[str]
        :type maxWidth: int
        :rtype: List[str]
        """
        cur = []
        cur_len = 0
        ans = []
        
        for w in words:
            if len(w) + cur_len + len(cur) > maxWidth:
                spaces = maxWidth - cur_len
                for i in range(spaces):
                    idx = i % (len(cur)-1 or 1)
                    cur[idx] += ' '
                ans.append(''.join(cur))
                cur = []
                cur_len = 0
            cur.append(w)
            cur_len += len(w)
                
        return ans + [' '.join(cur).ljust(maxWidth)]
