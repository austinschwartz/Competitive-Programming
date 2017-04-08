n = int(input())

nums = list(map(int, input().split(' ')))

amaz = 0
low = nums[0]
high = nums[0]
for i in range(1, n):
    if nums[i] < low:
        amaz += 1
        low = nums[i]
    elif nums[i] > high:
        amaz += 1
        high = nums[i]
print(amaz)
