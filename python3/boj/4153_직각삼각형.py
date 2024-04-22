from sys import stdin

readline = stdin.readline

if __name__ == "__main__":
    while True:
        
        a, b, c = map(int, readline().split())
        
        if a == 0 and b == 0 and c == 0:
            break
            
        a, b, c = sorted([a, b, c])
        
        if (a ** 2 + b ** 2) == c ** 2:
            print("right")
        else:
            print("wrong")