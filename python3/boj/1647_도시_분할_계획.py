from sys import stdin

readline = stdin.readline


def union(parants, a, b):
    a = find(parents, a)
    b = find(parants, b)
    
    if a < b:
        parants[b] = a
    else:
        parants[a] = b


def find(parants, n):
    if parants[n] != n:
        parants[n] = find(parants, parants[n])
    
    return parants[n]


if __name__ == '__main__':
    N, M = map(int, readline().split())
    edges = [tuple(map(int, readline().split())) for _ in range(M)]
    
    parents = [i for i in range(N + 1)]
    
    total = 0
    cost = 0
    
    for s, e, c in sorted(edges, key=lambda x: x[2]):
        if find(parents, s) == find(parents, e):
            continue
        
        union(parents, s, e)
        total += c
        cost = c    
    
    print(total - cost)