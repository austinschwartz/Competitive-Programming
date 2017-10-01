def main():
    n = int(input())
    nums = list(map(int, input().split(' ')))
    m = {}
    for num in nums:
        if num in m:
            m[num] += 1
        else:
            m[num] = 1
    for num in nums:
        if m[num] > (n + 1)//2:
            return False
    return True

print("YES") if main() else print("NO")
