def main():
    n = int(input())
    if n <= 2:
        return False
    a = list(map(int, input().split(' ')))
    s = [(min(a[i], a[i+1]), max(a[i], a[i+1])) for i in range(n-1)]
    for i, p1 in enumerate(s):
        for j, p2 in enumerate(s):
            if i == j:
                continue
            if p1[0] < p2[0] and p2[0] < p1[1] and p1[1] < p2[1]:
                return True
            if p2[0] < p1[0] and p1[0] < p2[1] and p2[1] < p1[1]:
                return True
    return False

print("yes" if main() else "no")
