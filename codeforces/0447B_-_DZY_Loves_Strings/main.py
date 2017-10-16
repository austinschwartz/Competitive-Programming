def main():
    s = list(input())
    k = int(input())
    w = list(map(int, input().split(' ')))
    max_index = 0
    for i in range(1, len(w)):
        if w[i] > w[max_index]:
            max_index = i
    for i in range(k):
        s.append(chr(max_index + ord('a')))
    ret = 0
    for i, c in enumerate(s):
        ret += (i + 1) * (w[ord(c) - ord('a')])
    return ret

print(main())
