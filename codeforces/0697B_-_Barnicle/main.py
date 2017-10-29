import decimal

decimal.getcontext().prec = 999

def main():
    (x, e) = input().split('e')
    num = decimal.Decimal(x) * (10 ** int(e))
    s = "{:.1000f}".format(num).rstrip("0")
    if s[-1] == '.':
        return s[:-1]
    return s

print(main())

