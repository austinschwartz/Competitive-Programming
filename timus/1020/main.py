import math

(N, R) = input().split(' ')
N = int(N)
R = float(R)

def dist(x1, x2, y1, y2):
    return math.sqrt((x2 - x1)**2 + (y2 - y1)**2)
    
string = 0.0
prev = None
first = None
for i in range(N):
    (x, y) = map(float, input().split(' '))
    if first is None:
        first = (x, y)
    if prev is not None:
        string += dist(prev[0], x, prev[1], y)
    prev = (x, y)
    
string += dist(prev[0], first[0], prev[1], first[1])
        
string += (math.pi * 2 * R)
print("%.2f" % string)
