import sys

def main():
    (n, m, d) = map(int, sys.stdin.readline().split(' '))
    nums = []
    for i in range(n):
        nums = nums + list(map(int, sys.stdin.readline().split(' ')))
    k = n * m
    g = nums[0] % d
    for i in range(1, k):
        if nums[i] % d != g:
            sys.stdout.write('-1\n')
            return
    nums = sorted(nums)
    ret = 0
    median = nums[k//2]
    for i in range(k):
        ret += abs((nums[i] - median) // d)
    sys.stdout.write("{}\n".format(ret))

main()

