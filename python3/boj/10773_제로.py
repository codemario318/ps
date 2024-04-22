from sys import stdin

readline = stdin.readline

if __name__ == "__main__":
    K = int(readline())
    numbers = []
    
    for _ in range(K):
        number = int(readline())
        
        if number == 0:
            numbers.pop()
        else:
            numbers.append(number)
    
    print(sum(numbers))