def main():
    (n, m) = map(int, input().split(' '))
    colors = [0] * (n + 1)
    for i in range(m):
        (a, b, c) = map(int, input().split(' '))
        if colors[a] > 0:
            colors[b] = 1 + colors[a] % 3
            colors[c] = 1 + (1 + colors[a] % 3) % 3
        elif colors[b] > 0:
            colors[a] = 1 + colors[b] % 3
            colors[c] = 1 + (1 + colors[b] % 3) % 3
        elif colors[c] > 0:
            colors[a] = 1 + colors[c] % 3
            colors[b] = 1 + (1 + colors[c] % 3) % 3
        else:
            colors[a] = 1
            colors[b] = 2
            colors[c] = 3
    print(' '.join(list(map(str, colors[1:]))))

main()
