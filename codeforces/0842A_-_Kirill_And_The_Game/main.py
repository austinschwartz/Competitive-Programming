def main(l, r, x, y, k):
    for cost in range(x, y + 1):
        exp = k * cost
        if exp <= r and exp >= l:
            return "YES"
    return "NO"

print(main(*list(map(int, input().split(' ')))))
