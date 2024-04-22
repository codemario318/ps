from sys import stdin


readline = stdin.readline
N = 9


if __name__ == "__main__":
    numbers = [(int(readline()), i) for i in range(1, N + 1)]
    number, idx = max(numbers)
    print(number)
    print(idx)