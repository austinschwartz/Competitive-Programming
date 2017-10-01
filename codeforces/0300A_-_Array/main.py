def main():
    n = int(input())
    nums = list(map(int, input().split(' ')))
    positives = []
    negatives = []
    zeros = []
    a = []
    b = []
    c = []
    for num in nums:
        if num == 0:
            zeros.append(num)
        elif num < 0:
            negatives.append(num)
        else:
            positives.append(num)
    if len(positives) == 0:
        positives.append(negatives.pop())
        positives.append(negatives.pop())
    for i in range(len(negatives)):
        if i == len(negatives) - 1 and len(a) % 2 != 0:
            zeros.append(negatives[i])
        else:
            a.append(negatives[i])
    for pos in positives:
        b.append(pos)
    for zero in zeros:
        c.append(zero)
    print('{} {}'.format(len(a), ' '.join(map(str,a))))
    print('{} {}'.format(len(b), ' '.join(map(str,b))))
    print('{} {}'.format(len(c), ' '.join(map(str,c))))

main()
