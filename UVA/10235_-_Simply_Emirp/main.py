MAX = 1000001
is_prime = [True] * MAX
is_prime[1] = False
primes = set()
for i in range(2, MAX):
    if is_prime[i]:
        primes.add(i)
        for j in range(i*i, MAX, i):
            is_prime[j] = False

def f(a):
    global is_prime
    if not is_prime[a]:
        return "{} is not prime.".format(a)
    rev = int(''.join(reversed(list(str(a)))))
    if not is_prime[rev] or rev == a:
        return "{} is prime.".format(a)
    return "{} is emirp.".format(a)

    return 1

def main():
    while True:
        try:
            n = int(input())
            print(f(n))
        except Exception as e:
            return

main()
