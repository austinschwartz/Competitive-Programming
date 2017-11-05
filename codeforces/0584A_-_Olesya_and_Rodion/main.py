def main(n, t):
    b = 10 ** (n - 1)
    while b % t != 0:
        b += 1
    if b % t != 0 or len(str(b)) != n:
        return -1
    return b

print(main(*list(map(int, input().split(' ')))))
    
