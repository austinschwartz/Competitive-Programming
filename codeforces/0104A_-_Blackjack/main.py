import itertools

n = int(input())

def f(i):
    if i == 20:
        return 15
    if i <= 10 or i > 21:
        return 0
    return 4

print(f(n))

