def main():
    n = int(input())
    if n >= 0:
        return n
    return max(-(-n // 10), -((-n // 100) * 10 + (-n % 10)))
print(main())
