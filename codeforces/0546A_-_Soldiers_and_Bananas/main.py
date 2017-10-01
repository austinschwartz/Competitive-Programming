(k, n, w) = map(int, input().split(' '))

s = k * (w * (w + 1)) // 2

print(max(0, s - n))
