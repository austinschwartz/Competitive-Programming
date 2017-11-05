def main(s1, s2):
    def flip(c):
        if ord(c) in range(ord('a'), ord('z') + 1):
            return chr(ord('A') - ord('a') + ord(c))
        else:
            return chr(ord('a') - ord('A') + ord(c))
    m = [0 for i in range(256)]
    for c in s2:
        m[ord(c)] += 1
    a = 0
    b = 0
    marked = set()
    for i, c in enumerate(s1):
        if m[ord(c)] > 0:
            m[ord(c)] -= 1
            a += 1
            marked.add(i)
    for i, c in enumerate(s1):
        if i in marked:
            continue
        if m[ord(flip(c))] > 0:
           m[ord(flip(c))] -= 1
           b += 1
    return "{} {}".format(a, b)

print(main(input(), input()))
