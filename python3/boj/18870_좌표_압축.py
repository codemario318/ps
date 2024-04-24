from sys import stdin

readline = stdin.readline

if __name__ == "__main__":
    N = int(readline())
    numbers = list(map(int, readline().split()))
    numberSet = set(numbers)
    counter = {number: i for i, number in enumerate(sorted(numberSet))}
    print(" ".join(map(lambda x: str(counter[x]), numbers)))
