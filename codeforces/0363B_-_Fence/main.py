(n, k) = map(int, input().split(' '))
nums = list(map(int, input().split(' ')))

i = 0
j = k - 1

s = 0
for x in range(i, j + 1):
    s += nums[x]

min_sum = s
cur_sum = s
indx = 0
while j < n - 1:
    cur_sum -= nums[i]
    i += 1
    j += 1
    cur_sum += nums[j]
    if cur_sum < min_sum:
        min_sum = cur_sum
        indx = i

print(indx + 1)
