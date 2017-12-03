def main():
    n = int(input())
    ans = 0
    for i in range(n):
        s = input()
        if s in set(['ABSINTH', 'BEER', 'BRANDY', 'CHAMPAGNE', 'GIN', 'RUM', 'SAKE', 'TEQUILA', 'VODKA', 'WHISKEY', 'WINE']):
            ans += 1
            continue
        try:
            x = int(s)
            if x < 18:
                ans += 1
        except Exception as e:
            pass
    return ans

print(main())

