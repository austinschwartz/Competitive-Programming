n = int(input())

a = list(map(int, input().split(' ')))
b = list(map(int, input().split(' ')))
vis = [False] * int(1e7)

for i in range(n):
    vis[a[i]] = True
    vis[b[i]] = True

x = 0
for i in range(n):
    for j in range(n):
        if vis[a[i] ^ b[j]]:
            x += 1

print("Karen") if x % 2 == 0 else print("Koyomi")
