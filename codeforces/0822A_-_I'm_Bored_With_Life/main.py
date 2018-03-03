def main():
    from math import factorial
    (a, b) = map(int, input().split(' '))
    return factorial(min(a, b))
print(main())
