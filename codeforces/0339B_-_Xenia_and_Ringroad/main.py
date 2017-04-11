(n, m) = map(int, input().split(' '))

a = list(map(int, input().split(' ')))

houses = 0
if a[0] != 1:
    houses += (a[0] - 1)
for i in range(1, m):
    if a[i] > a[i-1]:
        houses += (a[i] - a[i-1])
    elif a[i] == a[i-1]:
        continue
    else:
        houses += (n - a[i-1]) + a[i]
print(houses)
        
