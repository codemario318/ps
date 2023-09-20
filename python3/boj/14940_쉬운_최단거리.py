"""
문제
지도가 주어지면 모든 지점에 대해서 목표지점까지의 거리를 구하여라.

문제를 쉽게 만들기 위해 오직 가로와 세로로만 움직일 수 있다고 하자.

입력
지도의 크기 n과 m이 주어진다. n은 세로의 크기, m은 가로의 크기다.(2 ≤ n ≤ 1000, 2 ≤ m ≤ 1000)

다음 n개의 줄에 m개의 숫자가 주어진다. 0은 갈 수 없는 땅이고 1은 갈 수 있는 땅, 2는 목표지점이다. 입력에서 2는 단 한개이다.

출력
각 지점에서 목표지점까지의 거리를 출력한다. 원래 갈 수 없는 땅인 위치는 0을 출력하고, 원래 갈 수 있는 땅인 부분 중에서 도달할 수 없는 위치는 -1을 출력한다.

2 5
1 1 1 1 2
0 0 0 0 0
"""

import sys
from collections import deque

readline = sys.stdin.readline

OFFSET = [[0, 1], [0, -1], [1, 0], [-1, 0]]

if __name__ == "__main__":
    n, m = map(int, readline().split())

    board = [list(map(int, readline().split())) for _ in range(n)]
    result = [[0 if board[i][j] == 0 else -1 for j in range(m)] for i in range(n)]

    s, e = 0, 0

    for i in range(n):
        for j in range(m):
            if board[i][j] == 2:
                s, e = i, j
                break

    q = deque([[s, e, 0]])
    result[s][e] = 0

    while q:
        col, row, dist = q.popleft()

        for wc, wr in OFFSET:
            nc, nr, nd = col + wc, row + wr, dist + 1

            if (
                0 <= nc < n
                and 0 <= nr < m
                and board[nc][nr] == 1
                and result[nc][nr] == -1
            ):
                result[nc][nr] = nd
                q.append([nc, nr, nd])

    for row in result:
        print(" ".join(map(str, row)))
