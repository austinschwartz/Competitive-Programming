from collections import defaultdict

def main():
    n = int(input())
    a = list(map(int, input().split(' ')))
    
    m = defaultdict(list)
    for i in range(n):
        m[a[i]].append(i)

    ret = []
    for k in m:
        if len(m[k]) == 1:
            ret.append((k, 0))
        else:
            v = m[k]
            diff = None
            good = True
            for i in range(1, len(v)):
                d = v[i] - v[i-1]
                if diff == None:
                    diff = d
                elif diff != d:
                    good = False
                    break
            if i == len(v) - 1 and good:
                ret.append((k, diff))
    ret = sorted(ret, key=lambda x: x[0])
    print(len(ret))
    for r in ret:
        print(r[0], r[1])

main()
