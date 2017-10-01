def main():
    n = int(input())
    a = 0
    b = 0
    nums = list(map(int, input().split(' ')))
    s = 0
    for num in nums:
        if num == 100:
            a += 1
        else:
            b += 1
        s += num
    if s % 200 != 0:
        return False
    half = s // 2
    for i in range(0, b + 1):
        if 200 * i <= half and half - 200 * i <= a * 100:
            return True
    return False

print("YES") if main() else print("NO")
