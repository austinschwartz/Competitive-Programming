def main():
    (candles, b) = map(int, input().split(' '))

    hours = 0
    l = 0
    while candles > 0:
        hours += candles
        l += (candles % b)
        candles //= b
        if l >= b:
            x = (l // b)
            l %= b
            candles += x
    return hours
print(main())
