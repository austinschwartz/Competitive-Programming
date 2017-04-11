n = int(input())

nums = list(map(int,input().split(' ')))

dif_count = 0
dif_indx = -1
for i in range(1, n):
    if nums[i] < nums[i - 1]:
        dif_indx = i
        dif_count += 1

if nums[n - 1] > nums[0]:
    dif_count += 1

if dif_indx == -1:
    print(0)
elif dif_count > 1:
    print(-1)
else:
    print(n - dif_indx)
