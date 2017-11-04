def main():
    s = input()
    l = []
    for i in range(10):
        l.append(input())
    ret = ""
    i = 0
    while i < 80:
        for j in range(10):
            if l[j] == s[i:i+10]:
                ret += str(j)
                i += 10
                break
    return ret

print(main())
