def main():
    from sys import stdin, stdout
    n = int(stdin.readline().strip())
    alphas = list(map(lambda i: chr(i + ord('a')), range(0, 26)))
    se = set(alphas)
    count = 0
    excess = 0
    found = False
    for i in range(n):
        (a, b) = stdin.readline().strip().split(' ')
        if a == '!':
            se = se.intersection(set(b))
            count += 1
            if found:
                excess += 1
        elif a == '.':
            se = se.difference(set(b))
        elif a == '?':
            if i != n - 1:
                count += 1
                se = se.difference(set(b))
                if found:
                    excess += 1
        if len(se) == 1:
            found = True
    stdout.write('{}\n'.format(excess))
main()
