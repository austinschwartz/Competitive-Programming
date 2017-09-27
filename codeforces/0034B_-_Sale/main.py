import sys

(n, m) = map(int, sys.stdin.readline().split(' '))

def main():
    nums = sorted(list(map(int, sys.stdin.readline().split(' '))))

    ret = 0
    for i in range(min(n, m)):
        if nums[i] >= 0:
            break
        ret -= nums[i]

    sys.stdout.write('{}\n'.format(ret))

main()
