def main(n, k):
    ans = int(1e8)
    for b in range(0, 75):
        for c in range(0, 75):
            for d in range(0, 75):
                for e in range(0, 75):
                    if 2*b + 3*c + 4*d + 5*e == k and b + c + d + e == n:
                        ans = min(ans, b)
    return ans

(n, k) = map(int, input().split(' '))
print(main(n, k))
