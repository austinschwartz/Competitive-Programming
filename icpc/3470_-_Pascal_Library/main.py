while True:
    (N, D) = map(int, input().strip().split(' '))
    if N == 0 and D == 0:
        break
    row = []
    for i in range(N):
        row.append(0)
    ret = False
    for d in range(D):
        line = map(int, input().strip().split(' '))
        for i, v in enumerate(line):
            if ret:
                break
            if v == 1:
                row[i] += 1
                if row[i] == D:
                    ret = True
    if ret:
        print('yes')
    else:
        print('no')

