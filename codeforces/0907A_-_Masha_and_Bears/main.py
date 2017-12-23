def main():
    def climb(a, b):
        return a <= b
    def like(a, b):
        return climb(a, b) and 2 * a >= b
    father, mother, son, martha = map(int, input().split(' '))
    for C3 in range(1, 301):
        if not like(son, C3) or not like(martha, C3):
            continue
        for C2 in range(C3 + 1, 301):
            if not like(mother, C2) or not climb(martha, C2) or like(martha, C2):
                continue
            for C1 in range(C2 + 1, 301):
                if not like(father, C1) or not climb(martha, C1) or like(martha, C1):
                    continue
                return '{}\n{}\n{}'.format(C1, C2, C3)
    return -1
print(main())
