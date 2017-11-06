n = int(input())

s = int((n*n)*(n*n + 1)/2)
each_gets = s // n

res = []

used = set()

cur = []
for x in range(0, n*n):
    i = n*n - x
    j = each_gets//(n//2) - i
    if j not in used and i not in used:
        used.add(i)
        used.add(j)
        cur.append(i)
        cur.append(j)
        if len(cur) == n:
            res.append(sorted(cur))
            cur = []

for thing in res:
    print(' '.join(map(str,thing)))
