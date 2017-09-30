def main():
    l = list(input())
    n = len(l)

    i = 0
    while i < n:
        if i + 2 < n and l[i] == '1' and l[i+1] == '4' and l[i+2] == '4':
            i += 3
        elif i + 1 < n and l[i] == '1' and l[i+1] == '4':
            i += 2
        elif l[i] == '1':
            i += 1
        else:
            return False
    return True

print("YES") if main() else print("NO")
