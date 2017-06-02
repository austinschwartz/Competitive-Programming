n = int(input())

nums = list(map(int, input().split(' ')))

l = 0
r = n - 1

s = [0, 0]
cur = 0

while l <= r:
    if nums[l] > nums[r]:
        s[cur] += nums[l]
        l += 1
    else:
        s[cur] += nums[r]
        r -= 1

    cur ^= 1

print(s[0], s[1])
