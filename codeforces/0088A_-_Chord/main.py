def main():
    from itertools import permutations
    l = ['C', 'C#', 'D', 'D#', 'E', 'F', 'F#', 'G', 'G#', 'A', 'B', 'H']
    m = {c: i for i, c in enumerate(l)}
    def dist(A, B):
        nonlocal l
        a, b = m[A], m[B]
        return (b - a) % 12
    l = input().split(' ')
    for p in permutations(l):
        if dist(p[0], p[1]) == 4 and dist(p[1], p[2]) == 3 and dist(p[0], p[2]) == 7:
            return "major"
        if dist(p[0], p[1]) == 3 and dist(p[1], p[2]) == 4 and dist(p[0], p[2]) == 7:
            return "minor"
    return "strange"

print(main())
