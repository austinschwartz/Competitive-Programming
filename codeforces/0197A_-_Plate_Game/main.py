def main(a, b, r):
    return "First" if 2 * r <= min(a, b) else "Second"

(a, b, r) = map(int, input().split(' '))
print(main(a, b, r))
