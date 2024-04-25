from sys import stdin

readline = stdin.readline


def dp(N, r, c):
    if N == 0:
        return 0
    return 2 * (r % 2) + (c % 2) + 4 * dp(N - 1, r // 2, c // 2)


if __name__ == "__main__":
    N, r, c = map(int, readline().split())
    print(dp(N, r, c))