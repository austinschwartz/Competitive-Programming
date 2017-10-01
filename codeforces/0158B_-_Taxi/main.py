import math
def main():
    n = int(input())
    nums = list(map(int, input().split(' ')))

    arr = [0, 0, 0, 0]
    for num in nums:
        arr[num-1] += 1

    # add 4s
    ret = arr[3]
    arr[3] = 0

    # pair 3s with 1s
    pairs = min(arr[2], arr[0])
    ret += pairs
    arr[2] -= pairs
    arr[0] -= pairs

    # pair 2s with 2s
    if arr[1] > 1:
        pairs = arr[1] // 2
        ret += pairs
        arr[1] -= (pairs * 2)

    # new cab for every leftover 3s
    if arr[2] > 0:
        ret += arr[2]
        arr[2] = 0

    # new cab for every leftover 2s
    if arr[0] >= 2 and arr[1] >= 1:
        pairs = min(arr[0] // 2, arr[1])
        arr[0] -= pairs * 2
        arr[1] -= pairs
        ret += pairs

    # edge case if we have 1 2 and 1 1
    if arr[1] == 1 and arr[0] == 1:
        arr[0] -= 1
        arr[1] -= 1
        ret += 1

    # pair an left over 2s
    ret += int(math.ceil(float(arr[1]) / 2.0))
    arr[1] = 0

    # pair an left over 1s
    ret += int(math.ceil(float(arr[0]) / 4.0))
    arr[0] = 0

    return ret

print(main())

