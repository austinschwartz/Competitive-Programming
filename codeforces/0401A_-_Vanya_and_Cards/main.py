import math

(n, x) = map(int, input().split(' '))

a = list(map(int, input().split(' ')))

s = -1 * sum(a)

if s == 0:
    print(0);
else:
    print(math.ceil(abs(s) / x))
