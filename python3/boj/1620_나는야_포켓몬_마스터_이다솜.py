from sys import stdin

readline = stdin.readline

if __name__ == "__main__":
    N, M = map(int, readline().split())
    
    poketmons = [readline().rstrip() for _ in range(N)]
    poketDictNP = dict(enumerate(poketmons, 1))
    poketDictPN = {v: k for k, v in enumerate(poketmons, 1)}
    
    for _ in range(M):
        r = readline().rstrip()
        
        if r in poketDictPN:
            print(poketDictPN[r])
        else:
            print(poketDictNP[int(r)])
