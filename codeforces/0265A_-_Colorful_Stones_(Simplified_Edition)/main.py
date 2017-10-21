def main():
    s = input()
    t = input()
    i = 0
    for ti in t:
        if s[i] == ti:
            i += 1
    return i + 1

print(main())
