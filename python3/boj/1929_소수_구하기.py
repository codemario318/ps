def sieve_of_eratosthenes(s, e):
    primes = [True for _ in range(e + 1)]
    primes[0], primes[1] = False, False
    
    for i in range(2, int(e ** 0.5) + 1):
        if primes[i]:
            for j in range(i * i, e + 1, i):
                primes[j] = False

    return [i for i in range(s, e + 1) if primes[i]]

if __name__ == "__main__":
    s, e = map(int, input().split())
    primes = sieve_of_eratosthenes(s, e)
    print("\n".join(map(str, primes)))
    