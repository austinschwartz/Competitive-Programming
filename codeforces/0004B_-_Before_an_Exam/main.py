from sys import stdin, stdout

def main():
    (d, sumTime) = map(int, input().split(' '))
    l = []
    minnSum = 0
    maxxSum = 0
    a = []
    b = []
    for i in range(d):
        (minn, maxx) = map(int, input().split(' '))
        minnSum += minn
        maxxSum += maxx
        a.append(minn)
        b.append(maxx)
    if sumTime <= maxxSum  and sumTime >= minnSum:
        stdout.write('YES\n')
        cur = sumTime
        out = []
        curSum = 0
        for i in range(d):
            x = a[i]
            curSum += x
            out.append(x)
        for i in range(d):
            if curSum >= sumTime:
                break
            if out[i] < b[i]:
                x = min(sumTime - curSum, (b[i] - out[i]))
                out[i] += x
                curSum += x

        stdout.write(' '.join(list(map(str, out))))
        stdout.write('\n')
    else:
        stdout.write('NO\n')

main()
