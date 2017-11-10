def main(n, a):
    a1 = sorted(a)
    a2 = list(reversed(sorted(a)))
    r = []
    for i in range(n//2):
        r.append(a1[i])
        r.append(a2[i])
    if n % 2 == 1:
        r.append(a1[n // 2])
    return ' '.join(list(map(str,r)))

print(main(int(input()), list(map(int, input().split(' ')))))
