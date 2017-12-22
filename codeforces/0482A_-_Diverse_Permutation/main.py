def main():
    from sys import stdin, stdout
    (n, k) = map(int, stdin.readline().strip().split(' '))
    p = []
    for i in range(n - k):
        p.append(i + 1)
    l = n - k + 1
    o = n
    x = False
    for i in range(n - k + 1, n + 1):
        if x:
            p.append(l)
            l += 1
        else:
            p.append(o)
            o -= 1
        x ^= True
    #se = set()
    #for i in range(len(p) - 1):
        #se.add(abs(p[i] - p[i + 1]))
    #print(len(se))
    stdout.write(' '.join(list(map(str, p))) + '\n')
main()
