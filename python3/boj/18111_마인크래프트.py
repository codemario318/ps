from sys import stdin

readline = stdin.readline

MAX_HEIGHT = 256
REMOVE_COST = 2
PUSH_COST = 1 

def solution(B, board):
    minCost = float('inf')
    maxHeight = 0
    
    for h in range(MAX_HEIGHT + 1):
        push = 0
        remove = 0
        
        for i in range(len(board)):
            for j in range(len(board[-1])):
                cur = board[i][j]
                    
                if cur > h:
                    remove += cur - h
                elif cur < h:
                    push += h - cur

        if push > (B + remove):
            return minCost, maxHeight
            
        cost = (push * PUSH_COST) + (remove * REMOVE_COST)
        
        if cost <= minCost:
            minCost = cost
            maxHeight = h
    
    return minCost, maxHeight

if __name__ == "__main__":
    N, M, B = map(int, readline().split())
    board = [list(map(int, readline().split())) for _ in range(N)]
    result = solution(B, board)
    print(f'{result[0]} {result[1]}')