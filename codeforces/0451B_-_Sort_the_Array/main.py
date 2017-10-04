def is_sorted(a, left, right):
    s1 = a[:left-1]
    s2 = a[left-1:right][::-1]
    s3 = a[right :]
    s = s1 + s2 + s3
    for i in range(1, len(s)):
        if s[i] < s[i-1]:
            return False
    return True

n = int(input())
a = [-1 * int(1e9) - 5] + list(map(int, input().split(' '))) + [int(1e9) + 5]

left = -1
right = -1
length = 0
borked = False

for i in range(1, n + 2):
    if a[i] < a[i-1]:
        if left == -1:
            left = i - 1
        right = i

if left == -1 and right == -1:
    print("yes")
    print("1 1")
else:
    if not is_sorted(a, left + 1, right + 1):
        print("no")
    else:
        print("yes")
        print(left, right)

