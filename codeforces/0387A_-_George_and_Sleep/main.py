def main():
    def f(sh, sm, th, tm):
        sh -= th
        sm -= tm
        if sm < 0:
            sh -= 1
            sm %= 60
        if sh < 0:
            sh %= 24
        return (sh, sm)
    s = map(int, input().split(':'))
    t = map(int, input().split(':'))
    return "{:02d}:{:02d}".format(*f(*s, *t))
print(main())
