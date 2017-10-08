import math
i = 1
while True:
    n = int(input())
    if n < 0:
        break
    print('Case {}: {}'.format(i, int(math.ceil(math.log2(n)))))
    i += 1
