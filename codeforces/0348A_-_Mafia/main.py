from math import ceil

def main():
    n = int(input())
    a = list(map(int, input().split(' ')))
    return max(max(a), int(ceil(sum(a) / (n - 1.0))))
print(main())
        
