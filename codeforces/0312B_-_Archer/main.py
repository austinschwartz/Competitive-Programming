def main():
    (a, b, c, d) = map(float, input().split(' '))
    x = 1 - c/d - a/b + (a * c)/(b * d)
    return -a / b / (x - 1)

print('{}'.format(main()))
