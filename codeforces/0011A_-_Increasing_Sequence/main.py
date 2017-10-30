def main(n, d, b):
    ret = 0
    for i in range(1, n):
        if b[i] <= b[i - 1]:
            diff = ((b[i - 1] - b[i]) // d) + 1
            b[i] += (diff * d)
            ret += diff
    return ret

print(main(*map(int, input().split(' ')), list(map(int,input().split(' ')))))

