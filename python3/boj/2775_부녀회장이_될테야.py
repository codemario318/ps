from sys import stdin

readline = stdin.readline

LIMIT = 15

if __name__ == "__main__":
    APT = [[i for i in range(LIMIT)]]
    
    for _ in range(1, LIMIT):
        temp = [0]
    
        for i in range(1, LIMIT):
            temp.append(temp[-1] + APT[-1][i])
        
        APT.append(temp)
    
    T = int(readline())
    
    for _ in range(T):
        k = int(readline())
        n = int(readline())
        print(APT[k][n])