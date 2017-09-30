import math

(n, x, y) = map(int, input().split(' '))

f = math.ceil((float(y)/100 * n) - x)

print(max(0, f))
