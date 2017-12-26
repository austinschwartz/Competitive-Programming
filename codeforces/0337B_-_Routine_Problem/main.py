def main():
    from fractions import Fraction
    (a, b, c, d) = map(int, input().split(' '))
    f = Fraction(a * d - b * c, a * d)
    if a * d <= b * c:
        f = Fraction(b * c - a * d, b * c)
    print('{}/{}'.format(f.numerator, f.denominator))
main()
