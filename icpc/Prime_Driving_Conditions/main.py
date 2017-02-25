import math

def is_prime(n):
    if n <= 1:
        return False
    for i in range(2, int(math.sqrt(n))):
        if n % i == 0:
            return False
    return True

def incs(s, i):
    if i == -1:
        return
    if s[i] == 'Z':
        incs(s, i - 1)
    else:
        s[i] = chr(ord(s[i]) + 1)

def f(s, n):
    n += 1
    while not is_prime(n):
        if n >= 9999:
            n = 0
            incs(s, 2)
        else:
            n += 1
    return (s, n)

while True:
    (s, n) = input().split(' ')
    n = int(n)
    s = list(s)
    if n == 0:
        break
    (ss, nn) = f(s, n)
    print("{} {}".format(''.join(ss), nn))
