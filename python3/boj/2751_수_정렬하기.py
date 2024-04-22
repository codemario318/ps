from sys import stdin

readline = stdin.readline

if __name__ == "__main__":
    N = int(readline())
    numbers = [int(readline()) for _ in range(N)]
    numbers.sort()
    print('\n'.join(map(str, numbers)))