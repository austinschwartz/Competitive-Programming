from collections import defaultdict

def main():
    n = int(input())
    a = map(int, input().split(' '))
    m = defaultdict(int)
    for ai in a:
        m[ai] += 1
    if m[5] > 0 or m[7] > 0:
        return "-1"
    twos = 0
    threes = 0
    fours = 0

    # add 3s
    threes += m[3]
    m[1] -= m[3]
    m[6] -= m[3]
    m[3] = 0
    if m[1] < 0 or m[6] < 0:
        return "-1"

    # add 4s
    fours += m[4]
    m[1] -= m[4]
    m[2] -= m[4]
    m[4] = 0
    if m[2] < 0 or m[1] < 0:
        return "-1"

    twos += m[2]
    m[1] -= m[2]
    m[6] -= m[2]
    m[2] = 0
    if m[1] < 0 or m[6] < 0:
        return "-1"

    l = []
    for i in range(fours):
        l.append("1 2 4")
    for i in range(twos):
        l.append("1 2 6")
    for i in range(threes):
        l.append("1 3 6")
    if len(l) == 0:
        return "-1"
    for i in range(6):
        if m[i] > 0:
            return "-1"
    return '\n'.join(l)


print(main())
