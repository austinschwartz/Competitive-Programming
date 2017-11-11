def main(t, c1, c2):
    if t in c1 and t not in c2:
        return "YES"
    if c1[1] != c2[1]:
        return "NO"
    order = {
        "6": 1,
        "7": 2,
        "8": 3,
        "9": 4,
        "T": 5,
        "J": 6,
        "Q": 7,
        "K": 8,
        "A": 9
    }
    if order[c1[0]] > order[c2[0]]:
        return "YES"
    return "NO"

print(main(input(), *input().strip().split()))
