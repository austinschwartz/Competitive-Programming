def main():
    n = 2 * int(input())
    nums = list(map(int, input().split(' ')))
    ret = 0
    s = set()
    for num in nums:
        if num in s:
            s.remove(num)
        else:
            s.add(num)
        ret = max(ret, len(s))
    return ret

print(main())
