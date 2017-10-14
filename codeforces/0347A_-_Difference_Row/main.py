def main():
    n = int(input())
    nums = sorted(list(map(int, input().split(' '))))
    temp = nums[0]
    nums[0] = nums[-1]
    nums[-1] = temp
    print(' '.join(map(str, nums)))

main()
