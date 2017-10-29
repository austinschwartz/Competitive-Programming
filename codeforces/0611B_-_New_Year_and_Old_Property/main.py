def main():
    (a, b) = map(int, input().split(' '))
    ret = 0
    for i in range(1, 1000):
        x = (1 << i) - 1
        for j in range(i - 1):
            y = x ^ (1 << j)
            if y <= b and y >= a:
                ret += 1
    return ret

print(main())
