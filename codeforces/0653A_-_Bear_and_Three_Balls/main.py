def main(n, a):
    def valid(i, j, k):
        if i == j or j == k or i == k:
            return False
        if abs(i - j) > 2 or abs(i - k) > 2 or abs(j - k) > 2:
            return False
        return True
    for i in range(n):
        for j in range(i + 1, n):
            for k in range(j + 1, n):
                if valid(a[i], a[j], a[k]):
                    return "YES"
    return "NO"
   
print(main(int(input()), list(map(int,input().split(' ')))))
