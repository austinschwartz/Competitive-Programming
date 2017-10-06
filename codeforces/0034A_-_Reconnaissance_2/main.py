n = int(input())
a = list(map(int, input().split(' ')))

m = abs(a[-1] - a[0])

for i in range(n - 1):
    m = min(abs(a[i] - a[i+1]), m)

if abs(a[-1] - a[0]) == m:
    print(1, len(a))
else:
    for i in range(n - 1):
        if abs(a[i] - a[i+1]) == m:
            print(i + 1, i + 2)
            break
