(n, k) = map(int, input().split(' '))

nums = []
for i in range(0, k):
    nums.append(n - i)

for i in range(1, n - k + 1):
    nums.append(i)

print(' '.join(map(str, nums)))
