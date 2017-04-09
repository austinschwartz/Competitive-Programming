(n, k) = map(int, input().split(' '))
a = list(input().split(' '))
s = set(a)

o = []

for i in range(k):
    o.append([a[i]])

for i in range(n * k):
    num = str(i + 1)
    j = 0
    if num not in s:
        while len(o[j]) == n:
            j += 1
        o[j].append(num)

for x in o:
    print(' '.join(x))
