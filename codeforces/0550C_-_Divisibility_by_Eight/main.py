def main():
    s = list(input())
    s.append("")
    s.append("")
    n = len(s)
    for i in range(n):
        for j in range(i + 1, n):
            for k in range(j + 1, n):
                num = int(s[i] + s[j] + s[k])
                if num % 8 == 0:
                    print("YES")
                    print(num)
                    return
    print("NO")
main()

