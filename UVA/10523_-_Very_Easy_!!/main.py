def f(N, A):
    ans = 0
    for i in range(1, N + 1):
        ans += (i * (A ** i))

    return ans

def main():
    while True:
        try:
            (N, A) = map(int, input().split(' '))
            print(f(N, A))
        except Exception as e:
            return

main()
