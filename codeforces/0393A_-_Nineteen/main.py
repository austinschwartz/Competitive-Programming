def main(s):
    from collections import Counter
    count = Counter(s)
    n = {'n': 2, 'i': 1, 'e': 3, 't': 1}
    f = True
    x = ""
    for i in range(len(s)):
        for c in n:
            if count[c] < n[c]:
                f = False
                break
        if not f:
            break
        for c in n:
            count[c] -= n[c]
        x += "ninetee"
    if count['n'] > 0:
        x += "n"
    r = 0
    for i in range(0, len(x) + 2 , 7):
        if x[i:i+8] == 'nineteen':
            r += 1
    return r
        
print(main(list(input())))
