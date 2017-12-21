def main():
    s = sum(list(map(int, input().split(' '))))
    ss = s // 5
    if ss == 0:
        return -1
    return ss if ss * 5 == s else -1
print(main())
