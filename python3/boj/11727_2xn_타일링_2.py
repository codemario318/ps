SIZE = 1001
MOD = 10007

MEM = [-1 for _ in range(SIZE + 1)]
MEM[0], MEM[1], MEM[2] = 0, 1, 3

def dp(n):
    if MEM[n] >= 0:
        return MEM[n]

    MEM[n] = (dp(n - 1) + 2 * dp(n - 2)) % MOD

    return MEM[n]

if __name__ == "__main__":
    n = int(input())
    print(dp(n))