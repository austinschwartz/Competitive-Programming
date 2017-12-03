def main(s):
    return "NO" if ''.join(''.join(s.lower().strip().split(' ')).split('?'))[-1] not in set(['a', 'e', 'i', 'o', 'u', 'y']) else "YES"

print(main(input()))
