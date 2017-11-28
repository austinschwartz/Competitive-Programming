from sys import stdin, stdout

def main():
    def can(m, s):
        return s >= 0 and s <= 9 * m
    def f(m, s):
        _sum = s
        minn = 0
        for i in range(m):
            for d in range(0, 10):
                if ((i > 0 or d > 0 or (m == 1 and d == 0)) and can(m - i - 1, _sum - d)):
                    minn += d
                    minn *= 10
                    _sum -= d
                    break
        maxx = 0
        _sum = s
        for i in range(m):
            for d in range(9, -1, -1):
                if ((i > 0 or d > 0 or (m == 1 and d == 0)) and can(m - i - 1, _sum - d)):
                    maxx += d
                    maxx *= 10
                    _sum -= d
                    break
        if len(str(minn // 10)) != m or len(str(maxx // 10)) != m:
            return "-1 -1"
        if sum(list(map(int, list(str(minn // 10))))) != s:
            return "-1 -1"
        if sum(list(map(int, list(str(maxx // 10))))) != s:
            return "-1 -1"
        return "{} {}".format(minn // 10, maxx // 10)

    (m, s) = map(int, stdin.readline().strip().split(' '))
    print(f(m, s))

main()
