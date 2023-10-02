"""
문제
연세대학교 수강신청이 얼마 전부터 바뀌어, 마일리지 제도로 바뀌었다. 이 제도는 각각의 학생들에게 마일리지를 주어 듣고 싶은 과목에 마일리지를 과목당 1~36을 분배한다. 그리고 모두 분배가 끝이 나면 과목에 대해서 마일리지를 많이 투자한 순으로 그 과목의 수강인원만큼 신청되는 방식이다.

성준이는 연세대학교 재학 중인 학생이다. 성준이는 저번 수강신청에서 실패하여 휴학을 했기 때문에 이번 수강신청만은 필사적으로 성공하려고 한다. 그래서 성준이는 학교 홈페이지를 뚫어버렸다.

그 덕분에 다른 사람들이 신청한 마일리지를 볼 수 있게 되었다. 성준이는 주어진 마일리지로 최대한 많은 과목을 신청하고 싶어 한다. (내가 마일리지를 넣고 이후에 과목을 신청하는 사람은 없다) 마일리지는 한 과목에 1에서 36까지 넣을 수 있다.

입력
첫째 줄에는 과목 수 n (1 ≤ n ≤ 100)과 주어진 마일리지 m (1 ≤ m ≤ 100)이 주어진다. 각 과목마다 2줄의 입력이 주어지는데 첫째 줄에는 각 과목에 신청한 사람 수 Pi과 과목의 수강인원 Li이 주어지고 그 다음 줄에는 각 사람이 마일리지를 얼마나 넣었는지 주어진다. (1 ≤ Pi ≤100, 1 ≤ Li ≤ 100)

(단 마일리지가 같다면 성준이에게 우선순위가 주어진다고 하자.)

출력
첫째 줄에 주어진 마일리지로 최대로 들을 수 있는 과목 개수를 출력한다.

예제 입력 1 
5 76
5 4 
36 25 1 36 36
4 4
30 24 25 20
6 4
36 36 36 36 36 36
2 4
3 7
5 4
27 15 26 8 14
예제 출력 1 
4
출처
University > 연세대학교 > 2016 연세대 컴퓨터과학과 프로그래밍 경진대회 A번

문제를 만든 사람: zych1751
"""
import sys

readline = sys.stdin.readline

if __name__ == "__main__":
    n, m = map(int, readline().split())
    lecture_mileages = []

    for _ in range(n):
        P, L = map(int, readline().split())
        mileages = map(int, readline().split())

        if P < L:
            lecture_mileages.append(1)
        else:
            mileages = sorted(mileages)
            lecture_mileages.append(mileages[P - L])

    lecture_mileages.sort()

    total = 0
    count = 0

    for mileage in lecture_mileages:
        if total + mileage > m:
            break

        total += mileage
        count += 1

    print(count)
