from math import ceil

def main(a, b, n):
    return int(ceil((a / 5))) + int(ceil((b / 10))) <= n

print("YES" if main(sum(list(map(int, input().split(' ')))), sum(list(map(int, input().split(' ')))), int(input())) else "NO")
