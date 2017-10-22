from math import ceil
def main():
    n = int(input())
    print(int(ceil((n * n) / 2)))
    for i in range(n):
        s = ""
        x = 0
        for j in range(n):
            if (i + j) % 2 == 0:
                x += 1
                s += "C"
            else:
                s += "."
        print(s)
main()
