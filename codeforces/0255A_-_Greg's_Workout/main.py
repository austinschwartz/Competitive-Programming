def main():
    n = int(input())
    a = list(map(int, input().split(' ')))
    r = [0, 0, 0]
    s = ["chest", "biceps", "back"]
    ma = 0
    for i, ai in enumerate(a):
        r[i % 3] += ai
        if r[i % 3] > r[ma]:
            ma = i % 3
    return s[ma]

print(main())
