def main():
    from sys import stdin, stdout
    from collections import defaultdict
    h = int(input())
    if h <= 1:
        stdout.write("perfect\n")
        return
    a = list(map(int, stdin.readline().strip().split(' ')))
    ambiguous = False
    for i in range(0, h + 1):
        if a[i] > 1 and a[i - 1] > 1:
            ambiguous = True
            break
    
    if not ambiguous:
        stdout.write("perfect\n")
        return

    stdout.write("ambiguous\n")
    t = defaultdict(list)
    prev = 1
    cur = 2
    r = [0]
    for i in range(1, h + 1):
        for j in range(a[i]):
            t[prev].append(cur)
            cur += 1
        for l in t[prev]:
            r.append(prev)
        prev = cur - 1
    stdout.write(' '.join(list(map(str, r))) + "\n")

    t = defaultdict(list)
    prev = 1
    cur = 2
    r = [0]
    o = True
    for i in range(1, h + 1):
        for j in range(a[i]):
            t[prev].append(cur)
            cur += 1
        for l in t[prev]:
            if a[i] > 1 and a[i - 1] > 1 and o:
                r.append(prev - 1)
                o = False
            else:
                r.append(prev)
        prev = cur - 1
    stdout.write(' '.join(list(map(str, r))) + "\n")

main()
