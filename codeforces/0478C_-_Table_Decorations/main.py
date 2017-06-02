s = sorted(list(map(int, input().split(' '))))
a = s[0]
b = s[1]
c = s[2]

count = 0

if 2 * (a + b) <= c:
    count = a + b
else:
    count = (a + b + c) // 3

print(count)
