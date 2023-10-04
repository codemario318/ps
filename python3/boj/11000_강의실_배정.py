"""
강의실 배정
 
시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
1 초	256 MB	39434	11562	8525	28.827%
문제
수강신청의 마스터 김종혜 선생님에게 새로운 과제가 주어졌다. 

김종혜 선생님한테는 Si에 시작해서 Ti에 끝나는 N개의 수업이 주어지는데, 최소의 강의실을 사용해서 모든 수업을 가능하게 해야 한다. 

참고로, 수업이 끝난 직후에 다음 수업을 시작할 수 있다. (즉, Ti ≤ Sj 일 경우 i 수업과 j 수업은 같이 들을 수 있다.)

수강신청 대충한 게 찔리면, 선생님을 도와드리자!

입력
첫 번째 줄에 N이 주어진다. (1 ≤ N ≤ 200,000)

이후 N개의 줄에 Si, Ti가 주어진다. (0 ≤ Si < Ti ≤ 109)

출력
강의실의 개수를 출력하라.

예제 입력 1 
3
1 3
2 4
3 5
예제 출력 1 
2
출처
문제를 만든 사람: koosaga
데이터를 추가한 사람: zlzmsrhak

4
1 2
1 3
1 4
2 4
>> 3
"""

import sys
from heapq import heappop, heappush

readline = sys.stdin.readline

if __name__ == "__main__":
    N = int(readline())
    ST = [tuple(map(int, readline().split())) for _ in range(N)]

    ST.sort()

    ends = [0]

    for s, e in ST:
        if s >= ends[0]:
            heappop(ends)
        heappush(ends, e)

    print(len(ends))
