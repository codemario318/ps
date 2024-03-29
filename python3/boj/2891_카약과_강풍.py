"""
시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
1 초	128 MB	4436	992	822	28.218%
문제
2890번을 보면 알겠지만, 상근이는 카약 대회를 개최했다. 그런데, 갑자기 엄청난 강풍이 경기장에 불었고, 일부 카약이 부서졌다. 경기는 5분 안에 시작해야 하는 상황이다.

다행히 일부 팀은 혹시 모를 사태에 대비해서 카약을 하나 더 경기장에 들고 왔다. 카약은 매우 무겁고 운반하기 어렵다. 따라서, 자신의 바로 다음이나 전에 경기하는 팀에게만 카약을 빌려주려고 한다. 즉, 팀 4는 여분의 카약을 3이나 5에게만 빌려줄 수 있다. 다른 팀에게서 받은 카약은 또 다른 팀에게 빌려줄 수 없다. 또, 카약을 하나 더 가져온 팀의 카약이 손상되었다면, 여분의 카약으로 경기에 출전하게되고, 이 카약은 다른 팀에게 빌려줄 수 없다.

카약이 부서진 팀과 하나 더 가져온 팀이 주어진다. 카약을 적절히 빌렸을 때 출발하지 못하는 팀의 최솟값은 몇 팀인지 구하는 프로그램을 작성하시오.

입력
첫째 줄에 팀의 수 N, 카약이 손상된 팀의 수 S, 카약을 하나 더 가져온 팀의 수 R이 주어진다. (2 ≤ N ≤ 10, 1 ≤ S, R ≤ N)

둘째 줄에는 카약이 손상된 팀의 번호가 주어진다. 팀 번호는 중복되지 않는다.

셋째 줄에는 카약을 하나 더 가져온 팀의 번호가 주어진다. 팀 번호는 중복되지 않는다.

출력
첫째 줄에 출발을 할 수 없는 팀의 최솟값을 출력한다.

예제 입력 1 
5 2 1
2 4
3
예제 출력 1 
1
예제 입력 2 
5 2 3
2 4
1 3 5
예제 출력 2 
0
출처
Contest > Croatian Open Competition in Informatics > COCI 2009/2010 > Contest #6 2번

문제를 번역한 사람: baekjoon
데이터를 추가한 사람: junito, kimforstudy
잘못된 조건을 찾은 사람: kyo20111

10 1 1 
1
3
>> 1

10 5 2
1 2 3 6 7 
7 8
>> 4

5 3 3
2 3 4
1 2 3
>> 1
"""

import sys

readline = sys.stdin.readline

if __name__ == "__main__":
    N, S, R = map(int, readline().split())

    no_kayak = list(map(int, readline().split()))
    multi_kayak = set(map(int, readline().split()))

    for n in range(1, N + 1):
        if n in no_kayak and n in multi_kayak:
            no_kayak.remove(n)
            multi_kayak.remove(n)

    count = 0

    for team in no_kayak:
        if team - 1 in multi_kayak:
            multi_kayak.remove(team - 1)
            continue

        if team + 1 in multi_kayak:
            multi_kayak.remove(team + 1)
            continue

        count += 1

    print(count)
