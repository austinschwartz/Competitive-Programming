def main():
    (n, s, t) = map(int, input().split(' '))
    s -= 1
    t -= 1
    if s == t:
        return 0
    nums = list(map(lambda i: int(i) - 1, input().split(' ')))
    slow = s
    fast = nums[slow]
    i = 0
    while slow != t:
        if slow == fast:
            return -1
        slow = nums[slow]
        fast = nums[nums[fast]]
        i += 1
    return i

print(main())
