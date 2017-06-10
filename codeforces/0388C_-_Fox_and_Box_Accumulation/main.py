n = int(input())

nums = sorted(list(map(int, input().split(' '))))

used = set()

k = 0
while len(used) < n:
    k += 1
    pile = []
    for i in range(n):
        if i not in used and nums[i] >= len(pile):
            pile.append(nums[i])
            used.add(i)
    #print(pile)

print(k)

