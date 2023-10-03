"""
수 묶기
 
시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
2 초	128 MB	35318	11598	9304	32.084%
문제
길이가 N인 수열이 주어졌을 때, 그 수열의 합을 구하려고 한다. 하지만, 그냥 그 수열의 합을 모두 더해서 구하는 것이 아니라, 수열의 두 수를 묶으려고 한다. 어떤 수를 묶으려고 할 때, 위치에 상관없이 묶을 수 있다. 하지만, 같은 위치에 있는 수(자기 자신)를 묶는 것은 불가능하다. 그리고 어떤 수를 묶게 되면, 수열의 합을 구할 때 묶은 수는 서로 곱한 후에 더한다.

예를 들면, 어떤 수열이 {0, 1, 2, 4, 3, 5}일 때, 그냥 이 수열의 합을 구하면 0+1+2+4+3+5 = 15이다. 하지만, 2와 3을 묶고, 4와 5를 묶게 되면, 0+1+(2*3)+(4*5) = 27이 되어 최대가 된다.

수열의 모든 수는 단 한번만 묶거나, 아니면 묶지 않아야한다.

수열이 주어졌을 때, 수열의 각 수를 적절히 묶었을 때, 그 합이 최대가 되게 하는 프로그램을 작성하시오.

입력
첫째 줄에 수열의 크기 N이 주어진다. N은 50보다 작은 자연수이다. 둘째 줄부터 N개의 줄에 수열의 각 수가 주어진다. 수열의 수는 -1,000보다 크거나 같고, 1,000보다 작거나 같은 정수이다.

출력
수를 합이 최대가 나오게 묶었을 때 합을 출력한다. 정답은 항상 231보다 작다.

예제 입력 1 
4
-1
2
1
3
예제 출력 1 
6
예제 입력 2 
6
0
1
2
4
3
5
예제 출력 2 
27
예제 입력 3 
1
-1
예제 출력 3 
-1
예제 입력 4 
3
-1
0
1
예제 출력 4 
1
예제 입력 5 
2
1
1
예제 출력 5 
2

5
3
4
5
6
7
>> 65
출처
문제의 오타를 찾은 사람: acka, bupjae, jwvg0425, rainshot, silvercube, tncks0121
문제를 번역한 사람: baekjoon
데이터를 추가한 사람: godnes628
"""
import sys

readline = sys.stdin.readline


def maximum_pair(arr):
    if not arr:
        return 0

    i = 0
    total = 0

    for i in range(0, len(arr), 2):
        cur, nxt = arr[i], arr[i + 1]
        total += max(cur * nxt, cur + nxt)

    return total


if __name__ == "__main__":
    N = int(readline())

    p_arr = []
    m_arr = []

    for _ in range(N):
        n = int(readline())

        if n > 0:
            p_arr.append(n)
        else:
            m_arr.append(n)

    p_arr.sort(reverse=True)
    m_arr.sort()

    total = (
        maximum_pair(p_arr[:-1]) + p_arr[-1] if len(p_arr) % 2 else maximum_pair(p_arr)
    )
    total += (
        maximum_pair(m_arr[:-1]) + m_arr[-1] if len(m_arr) % 2 else maximum_pair(m_arr)
    )

    print(total)
