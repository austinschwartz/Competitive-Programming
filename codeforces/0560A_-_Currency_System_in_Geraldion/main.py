def main():
    input()
    if 1 in set(list(map(int, input().split(' ')))):
        return "-1"
    return "1"
print(main())
