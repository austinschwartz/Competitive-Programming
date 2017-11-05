def main():
    def fits(a, b, a2, b2, a3, b3):
        if a2 + a3 <= a and max(b2, b3) <= b:
            return True
        if max(a2, a3) <= a and b2 + b3 <= b:
            return True
        return False
    (a1, b1) = map(int, input().split(' '))
    (a2, b2) = map(int, input().split(' '))
    (a3, b3) = map(int, input().split(' '))
    if a2*b2 + a3*b3 > a1*b1:
        return False

    if fits(a1, b1, a2, b2, a3, b3) or fits(b1, a1, a2, b2, a3, b3):
        return True

    if fits(a1, b1, b2, a2, a3, b3) or fits(b1, a1, b2, a2, a3, b3):
        return True

    if fits(a1, b1, a3, b3, a2, b2) or fits(b1, a1, a3, b3, a2, b2):
        return True

    if fits(a1, b1, b3, a3, a2, b2) or fits(b1, a1, b3, a3, a2, b2):
        return True

    return False

print("YES" if main() else "NO")
