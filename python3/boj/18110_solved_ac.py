from sys import stdin

readline = stdin.readline

TRIM_RATE = 0.15

def round(f):
    return int(f) + (f - int(f) >= 0.5) 

if __name__ == "__main__":
    n = int(readline())
    levels = [int(readline()) for _ in range(n)]
    levels.sort()
    
    trimmed = round(n * TRIM_RATE)     
    trimmedLevels = levels[trimmed : n - trimmed]
    
    if len(trimmedLevels) > 0:
        print(round(sum(trimmedLevels) / len(trimmedLevels)))
    else:
        print(0)