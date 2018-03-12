def main(n):
    ret = 0
    for i in range(1, n + 1):
        ret += (2 ** i)
    return ret

print(main(int(input())))
