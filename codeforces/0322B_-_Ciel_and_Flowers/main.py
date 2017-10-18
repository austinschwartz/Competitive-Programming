def main():
    (r, g, b) = map(int, input().split(' '))
    def mix(m):
        if m > r or m > g or m > b:
            return 0
        return m + ((r - m) // 3) + ((g - m) // 3) + ((b - m) // 3)
    return max(mix(0), mix(1), mix(2))

print(main())
