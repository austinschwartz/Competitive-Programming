minX = [9999 for i in range(2000)]
minY = [9999 for i in range(2000)]
maxX = [-9999 for i in range(2000)]
maxY = [-9999 for i in range(2000)]

n = int(input())
points = []
for i in range(n):
    (x, y) = map(int, input().split(' '))
    x = x + 1000
    y = y + 1000
    points.append((x, y))
    minY[x] = min(minY[x], y)
    maxY[x] = max(maxY[x], y)
    minX[y] = min(minX[y], x)
    maxX[y] = max(maxX[y], x)

ret = 0
for point in points:
    (x, y) = point
    if x > minX[y] and x < maxX[y] and y > minY[x] and y < maxY[x]:
        ret += 1
print(ret)
