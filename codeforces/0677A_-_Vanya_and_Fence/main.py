def main(n, h, a):
    ans = 0
    for i in range(n):
        if a[i] > h:
            ans += 2
        else:
            ans += 1
    return ans 

(n, h) = map(int, input().split(' '))
a = list(map(int, input().split(' ')))
print(main(n, h, a))
