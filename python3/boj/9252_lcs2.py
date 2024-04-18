from sys import stdin
from collections import deque

readline = stdin.readline


def lcs2(s1, s2):
    mem = [[0 for _ in range(len(s2) + 1)] for _ in range(len(s1) + 1)]
    
    for i in range(1, len(mem)):
        for j in range(1, len(mem[0])):
            if s1[i - 1] == s2[j - 1]:
                mem[i][j] = mem[i - 1][j - 1] + 1
            else:
                mem[i][j] = max(mem[i - 1][j], mem[i][j - 1])
    
    print(mem[-1][-1])
    
    if mem[-1][-1] == 0:
        return
    
    res = deque()
    i, j = len(s1), len(s2)
    
    while (mem[i][j] > 0):
        if mem[i][j] == mem[i - 1][j]:
            i -= 1
        elif mem[i][j] == mem[i][j - 1]:
            j -= 1
        else:
            res.appendleft(s1[i - 1])
            i -= 1
            j -= 1
    
    print(''.join(res))


if __name__ == '__main__':
    s1 = readline().rstrip()
    s2 = readline().rstrip()
    lcs2(s1, s2)