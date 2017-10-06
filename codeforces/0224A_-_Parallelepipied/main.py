from math import sqrt

def f(a1, a2, a3):
    h = sqrt((a2 * a3) // a1)
    l = (a1 * h) // a3
    w = a1 // l
    return int(4 * (w + l + h))

def main():
    (a1, a2, a3) = map(int, input().split(' '))
    print(f(a1, a2, a3))

main()
