from sys import stdin

readline = stdin.readline

if __name__ == '__main__':
    N = int(readline())
    scores = tuple(map(int, readline().split()))
    print(sum(scores) * 100 / max(scores) / N)