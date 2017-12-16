def main():
    n = int(input())
    s = list(input())
    if len(s) > 26:
        return -1
    return len(s) - len(set(s))
print(main())
