(n, k) = map(int, input().split(' '))

l = list(sorted(map(int, input().split(' '))))

print(len(list(filter(lambda i: i >= l[n - k] and i > 0, l))))

