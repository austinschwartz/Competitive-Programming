def main(n, s):
    ret = ""
    i = 0
    while i < n:
        if i + 2 < n and s[i] == 'o' and s[i + 1] == 'g' and s[i + 2] == 'o':
            ret += '***'
            j = i + 1
            while j + 1 < n:
                if s[j] == 'g' and s[j + 1] == 'o':
                    s[j] = '*'
                    s[j + 1] = '*'
                    j += 2
                else:
                    break
            i = j - 1
        else:
            ret += s[i]
        i += 1
    return ''.join(ret)

print(main(int(input()), list(input())))

