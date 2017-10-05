n = list(input())

j = -1
for i in range(len(n) - 1, -1, -1):
    if int(n[i]) % 2 == 0:
        if j == -1 or n[i] <= n[-1]:
            j = i

if j == -1:
    print(-1)
else:
    temp = n[j]
    n[j] = n[-1]
    n[-1] = temp
    print(''.join(n))

