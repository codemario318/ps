"""
문제
시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
0.5 초 (추가 시간 없음)	256 MB	9309	4430	3601	49.396%
문제
기다란 벤치 모양의 식탁에 사람들과 햄버거가 아래와 같이 단위 간격으로 놓여 있다. 사람들은 자신의 위치에서 거리가 
$K$ 이하인 햄버거를 먹을 수 있다.

햄버거	사람	햄버거	사람	햄버거	사람	햄버거	햄버거	사람	사람	햄버거	사람
1	2	3	4	5	6	7	8	9	10	11	12
위의 상태에서 
$K = 1$인 경우를 생각해보자. 이 경우 모든 사람은 자신과 인접한 햄버거만 먹을 수 있다. 10번의 위치에 있는 사람은 11번 위치에 있는 햄버거를 먹을 수 있다. 이 경우 다음과 같이 최대 5명의 사람이 햄버거를 먹을 수 있다.

2번 위치에 있는 사람: 1번 위치에 있는 햄버거
4번 위치에 있는 사람: 5번 위치에 있는 햄버거
6번 위치에 있는 사람: 7번 위치에 있는 햄버거
9번 위치에 있는 사람: 8번 위치에 있는 햄버거
10번 위치에 있는 사람: 11번 위치에 있는 햄버거
12번 위치에 있는 사람: 먹을 수 있는 햄버거가 없음
 
$K = 2$인 경우에는 6명 모두가 햄버거를 먹을 수 있다.

2번 위치에 있는 사람: 1번 위치에 있는 햄버거
4번 위치에 있는 사람: 3번 위치에 있는 햄버거
6번 위치에 있는 사람: 5번 위치에 있는 햄버거
9번 위치에 있는 사람: 7번 위치에 있는 햄버거
10번 위치에 있는 사람: 8번 위치에 있는 햄버거
12번 위치에 있는 사람: 11번 위치에 있는 햄버거
식탁의 길이 
$N$, 햄버거를 선택할 수 있는 거리 
$K$, 사람과 햄버거의 위치가 주어졌을 때, 햄버거를 먹을 수 있는 사람의 최대 수를 구하는 프로그램을 작성하시오.

입력
첫 줄에 두 정수 
$N$과 
$K$가 있다. 그리고 다음 줄에 사람과 햄버거의 위치가 문자 P(사람)와 H(햄버거)로 이루어지는 길이 
$N$인 문자열로 주어진다.

출력
첫 줄에 햄버거를 먹을 수 있는 최대 사람 수를 나타낸다.

제한
 
$1 \le N \le 20,000$ 
 
$1 \le K \le 10$ 
예제 입력 1 
20 1
HHPHPPHHPPHPPPHPHPHP
예제 출력 1 
8
예제 입력 2 
20 2
HHHHHPPPPPHPHPHPHHHP
예제 출력 2 
7

6 1
HPHPHP
>> 3

12 1
HPHPHPHHPPHP
>> 5

12 2
HPHPHPHHPPHP
>> 6

1 1
H
>> 0

1 1
P
>> 0

5 1
PHPHP
>> 2

5 2
PHPHP
>> 2

6 1
PHHPPH

20 2
HHPHPPHHPPHPPPHPHPHP
>> 8

20 3
HHPHPPHHPPHPPPHPHPHP
>> 9 

20 4
HHPHPPHHPPHPPPHPHPHP
>> 9 

20 1
HHHHHPPPPPHPHPHPHHHP
>> 6

20 3
HHHHHPPPPPHPHPHPHHHP
>> 9

8 3
PPHHHHPP
>> 4
"""

import sys
from collections import deque

readline = sys.stdin.readline

if __name__ == "__main__":
    N, K = map(int, readline().split())
    table = readline().rstrip()

    count = 0
    eaten = [False for _ in range(N)]

    for i in range(N):
        if table[i] == "H":
            continue

        eat = i

        for j in range(i - 1, i - K - 1, -1):
            if j < 0:
                break
            if table[j] == "H" and not eaten[j]:
                eat = j

        if eat != i:
            eaten[eat] = True
            count += 1
            continue

        for j in range(i + 1, i + K + 1):
            if j >= N:
                break
            if table[j] == "H" and not eaten[j]:
                eat = j
                break

        if eat != i:
            eaten[eat] = True
            count += 1

    print(count)
