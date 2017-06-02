n = int(input())
nums = sorted(map(int, input().split(' ')))

changes = 0

for i in range(n):
    changes += abs(nums[i] - i - 1)

print(changes)
