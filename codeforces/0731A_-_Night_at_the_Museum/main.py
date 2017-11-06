def main(s):
    s = "a" + s
    def dist(a, b):
        x = max(ord(a), ord(b))
        y = min(ord(a), ord(b))
        return min(x - y, 26 + y - x)
    ret = 0
    for i in range(len(s) - 1):
        ret += dist(s[i], s[i + 1])
    return ret

print(main(input()))
