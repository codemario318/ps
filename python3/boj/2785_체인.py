"""
문제
희원이는 그의 다락방에서 N개의 체인을 찾았다. 각각의 체인은 몇 개의 고리로 연결되어 있는데, 각각의 고리는 최대 두 개의 인접한 고리를 가질 수 있다. 각각의 고리는 열고 닫을 수 있다. 그래서, 체인을 분리하거나 두 체인을 연결하여 하나의 긴 체인으로 만들 수 있다. 희원이는 가능한 한 적은 고리를 열고 닫아서, 모든 체인을 하나의 긴 체인으로 연결하려고 한다.

예를 들어, 희원이가 세 개의 체인을 가지고 있고, 각 체인이 고리 하나로만 이루어져 있다면, 그 중 하나를 열어서 나머지 두 개를 연결하고 닫으면 된다.



체인의 개수와 각각의 체인의 길이가 주어지면, 하나의 긴 체인으로 모든 체인을 묶기 위해 희원이가 열고 닫아야할 최소한의 고리 수를 찾아라.

입력
첫 번째 줄에는 체인의 개수를 나타내는 양의 정수 N (2 ≤ N ≤ 500000)이 주어진다. 두 번째 줄에는 각각의 체인의 길이를 나타내는 N개의 양의 정수 Li(1 ≤ Li ≤ 1000000)가 주어진다.

출력
첫째 줄에 필요한 고리의 최소 개수를 출력한다.

예제 입력 1 
2
3 3
예제 출력 1 
1
예제 입력 2 
3
1 1 1
예제 출력 2 
1
예제 입력 3 
5
4 3 5 7 9
예제 출력 3 
3
출처
Contest > Croatian Open Competition in Informatics > COCI 2012/2013 > Contest #2 3번

문제를 번역한 사람: baekjoon
잘못된 번역을 찾은 사람: jh05013

2
3 3

3
4 2 4
2
"""
import sys

readline = sys.stdin.readline

if __name__ == "__main__":
    N = int(readline())
    chains = sorted(map(int, readline().split()))
    count = 0

    for chain in chains:
        if count == N - 1:
            break

        while chain > 0 and count < N - 1:
            chain -= 1
            count += 1

        N -= 1

    print(count)
