n = int(input())

a = list(map(int, input().split(' ')))

mini = 0
maxi = 0

for i in range(1, n):
    if a[i] <= a[mini]:
        mini = i
    if a[i] > a[maxi]:
        maxi = i


ans = maxi - 1 + n - mini
if maxi > mini:
    ans -= 1
print(ans)
