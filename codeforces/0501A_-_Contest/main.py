(a, b, c, d) = map(int, input().split(' '))

def points(p, t):
    return max(3.0/10.0 * p, p  - p / 250.0 * t)

if points(a, c) > points(b, d):
    print("Misha")
elif points(a, c) < points(b, d):
    print("Vasya")
else:
    print("Tie")
