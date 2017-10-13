def main(i):
    if i == 1:
        return 1
    s = [i] + list(range(1, i))
    return ' '.join(map(str, s))

print(main(int(input())))
