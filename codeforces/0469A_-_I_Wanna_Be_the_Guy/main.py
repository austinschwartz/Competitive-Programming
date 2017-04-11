levels = int(input())

x = list(map(int, input().split(' ')))
y = list(map(int, input().split(' ')))

s = set()

for i in range(1, x[0] + 1):
    s.add(x[i])

for i in range(1, y[0] + 1):
    s.add(y[i])

if len(s) == levels:
    print("I become the guy.")
else:
    print("Oh, my keyboard!")
