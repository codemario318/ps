"""
문제
매일 아침, 세준이는 학교에 가기 위해서 차를 타고 D킬로미터 길이의 고속도로를 지난다. 이 고속도로는 심각하게 커브가 많아서 정말 운전하기도 힘들다. 어느 날, 세준이는 이 고속도로에 지름길이 존재한다는 것을 알게 되었다. 모든 지름길은 일방통행이고, 고속도로를 역주행할 수는 없다.

세준이가 운전해야 하는 거리의 최솟값을 출력하시오.

입력
첫째 줄에 지름길의 개수 N과 고속도로의 길이 D가 주어진다. N은 12 이하인 양의 정수이고, D는 10,000보다 작거나 같은 자연수이다. 다음 N개의 줄에 지름길의 시작 위치, 도착 위치, 지름길의 길이가 주어진다. 모든 위치와 길이는 10,000보다 작거나 같은 음이 아닌 정수이다. 지름길의 시작 위치는 도착 위치보다 작다.

출력
세준이가 운전해야하는 거리의 최솟값을 출력하시오.

예제 입력 1 
5 150
0 50 10
0 50 20
50 100 10
100 151 10
110 140 90
예제 출력 1 
70
예제 입력 2 
2 100
10 60 40
50 90 20
예제 출력 2 
80
예제 입력 3 
8 900
0 10 9
20 60 45
80 190 100
50 70 15
160 180 14
140 160 14
420 901 5
450 900 0
예제 출력 3 
432
"""

import sys
from collections import defaultdict

readline = sys.stdin.readline

if __name__ == "__main__":
    N, D = map(int, readline().split())
    graph = defaultdict(dict)

    for _ in range(N):
        s, e, d = map(int, readline().split())

        if e not in graph[s]:
            graph[s][e] = d
        else:
            graph[s][e] = min(graph[s][e], d)

    mem = [i for i in range(D + 1)]

    for s in range(D + 1):
        mem[s] = min(mem[s], mem[s - 1] + 1)

        for dest, dist in graph[s].items():
            if dest <= D:
                mem[dest] = min(mem[dest], mem[s] + dist)

    print(mem[-1])
