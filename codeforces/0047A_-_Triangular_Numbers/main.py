def main():
    n = int(input())
    s = 0
    for i in range(n + 1):
        s += i
        if s == n:
            return "YES"
    return "NO"

print(main())
