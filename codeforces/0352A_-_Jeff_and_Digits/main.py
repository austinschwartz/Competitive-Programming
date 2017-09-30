def main():
    n = int(input())
    nums = list(map(int, input().split(' ')))

    zeros = 0
    fives = 0
    for i in nums:
        if i == 0:
            zeros += 1
        elif i == 5:
            fives += 1
    if zeros == 0:
        return "-1"
    if fives < 9:
        return "0"
    return "5" * (fives // 9) * 9 + "0" * zeros

print(main())
