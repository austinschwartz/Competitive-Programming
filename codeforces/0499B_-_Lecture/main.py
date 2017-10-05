(n, m) = map(int, input().split(' '))

dic = {}
for i in range(m):
    (a, b) = input().split(' ')
    if len(b) < len(a):
        s = b
    else:
        s = a
    dic[a] = s
    dic[b] = s

print(' '.join(map(lambda word: dic[word], input().split(' '))))

