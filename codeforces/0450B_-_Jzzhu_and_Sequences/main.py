def main():
    MOD = 1000000007
    (x, y) = map(int, input().split(' '))
    n = int(input())

    out = [x - y, x, y, y - x, -x, -y]
    ret = out[n % 6]

    print(ret % MOD)

main()
