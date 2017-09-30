def main():
    MAX = 3005
    n = int(input())

    nums = list(map(int, input().split(' ')))

    a = [False] * MAX

    for i in nums:
        a[i] = True

    for i in range(1, MAX):
        if not a[i]:
            return i

    return -1

print(main())
