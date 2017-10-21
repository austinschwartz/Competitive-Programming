def main():
    n = int(input())
    i = 0
    j = n - 1
    c = None
    c2 = None
    flipped = False
    for i in range(n):
        l = list(input())
        if c == None:
            c = l[1]
        for k in range(n):
            if k != i and k != j:
                if l[k] != c:
                    return False
        if c2 == None:
            c2 = l[i]
        if c2 == c:
            return False
        if l[i] != l[j] or l[i] != c2:
            return False
        i += 1
        j -= 1
    return True

print("YES" if main() else "NO")
