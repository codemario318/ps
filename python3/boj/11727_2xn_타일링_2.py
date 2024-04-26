SIZE = 1001
MOD = 10007

if __name__ == "__main__":
    n = int(input())
    mem = [0, 1, 3]
    
    for _ in range(3, n + 1):
        mem.append((mem[-1] + 2 * mem[-2]) % MOD) 
    
    print(mem[n])