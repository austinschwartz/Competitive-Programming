(n, m) = map(int, open('input.txt').read().split(' '))

s = ""

if n > m:
    while n > 0 and m > 0:
        s += "BG"
        n -= 1
        m -= 1

    while n > 0:
        s += "B"
        n -= 1

    while m > 0:
        s += "G"
        m -= 1
else:    
    while n > 0 and m > 0:
        s += "GB"
        n -= 1
        m -= 1
    while m > 0:
        s += "G"
        m -= 1
    while n > 0:
        s += "B"
        n -= 1

out = open('output.txt', 'w')
out.write(s)
