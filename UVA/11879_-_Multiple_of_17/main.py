def f(n):
    return int((n // 10 - 5 * (n % 10)) % 17 == 0)

def main():
    while True:
        try:
            n = int(input())
            if n == 0:
                break
            print(f(n))
        except Exception as e:
            return

main()
