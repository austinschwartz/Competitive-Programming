def main(n, A):
    m = 0
    for c in A:
        if c == 'A':
            m += 1
    if n % 2 == 0 and m == n // 2:
        return "Friendship"
    if m > n // 2:
        return "Anton"
    return "Danik"

print(main(int(input()), input()))
