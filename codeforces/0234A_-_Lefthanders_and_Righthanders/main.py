def main(n, s):
    with open('output.txt', 'w') as f:
        t = n // 2
        for i in range(t):
            if s[i] == 'R' and s[i + t] == 'L':
                f.write('{} {}\n'.format(i + t + 1, i + 1))
            else:
                f.write('{} {}\n'.format(i + 1, i + t + 1))
    
with open('input.txt', 'rb') as f:
    n = int(f.readline().strip())
    s = str(f.readline().strip(), 'utf-8')
    main(n, s)
