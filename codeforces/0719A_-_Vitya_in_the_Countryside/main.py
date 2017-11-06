def main(n, a):
    for ai in a[-15:]:
        if ai == 15:
            return "DOWN"
        if ai == 0:
            return "UP"
    if n == 1:
        return "-1"
    if a[-1] > a[-2]:
        return "UP"
    return "DOWN"

print(main(int(input()), list(map(int, input().split(' ')))))
