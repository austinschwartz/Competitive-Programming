def main():
    s = set(range(1, int(input()) + 1))
    for a in sorted(list(map(int, input().split(' ')))):
        if a in s:
            s.remove(ai)
    return len(s)
print(main())


