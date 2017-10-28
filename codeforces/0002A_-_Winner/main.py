from collections import defaultdict

def main():
    n = int(input())
    m = defaultdict(int)
    ma = 0
    l = []
    for i in range(n):
        s = input().split(' ')
        l.append((s[0], int(s[1])))
        m[s[0]] += int(s[1])
    
    winners = set()
    ma = max(m.values())
    m = defaultdict(int)
    for i in range(n):
        m[l[i][0]] += l[i][1]
        if m[l[i][0]] == ma:
            winners.add(l[i][0])

    if len(winners) == 1:
        return list(winners)[0]

    m = defaultdict(int)
    for i in range(n):
        m[l[i][0]] += l[i][1]
        if m[l[i][0]] >= ma and l[i][0] in winners:
            return l[i][0]

print(main())
