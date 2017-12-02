from sys import stdin,stdout

def main():
    n = int(stdin.readline().strip())
    a = []
    a_sum = 0
    b = []
    b_sum = 0
    last = 'first'
    for i in range(n):
        x = int(stdin.readline().strip())
        if x > 0:
            a.append(str(x))
            a_sum += x
            last = 'first'
        else:
            x = -x
            b.append(str(x))
            b_sum += x
            last = 'second'
    if a_sum > b_sum:
        return "first"
    if b_sum > a_sum:
        return "second"
    if a_sum == b_sum and len(a) == len(b):
        c = 0
        for i in range(len(a)):
            if a[i] == b[i]:
                c += 1
            else:
                break
        if c == len(a) and c == len(b):
            return last
    for i in range(min(len(a), len(b))):
        if a[i] == b[i]:
            continue
        if int(a[i]) < int(b[i]):
            return "second"
        else:
            return "first"
    if a > b:
        return "first"
    return "second"
stdout.write('{}\n'.format(main()))
