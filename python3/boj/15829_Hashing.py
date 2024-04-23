from sys import stdin

readline = stdin.readline

R = 31
M = 1234567891

CODE = {chr(i): i - ord('a') + 1 for i in range(ord('a'), ord('z') + 1)}

def hash(i, c):
    return CODE[c] * (R ** i)
    
if __name__ == "__main__":
    L = int(readline())
    string = readline().rstrip()
    print(sum(map(lambda x: hash(x[0], x[1]), enumerate(string))) % M)