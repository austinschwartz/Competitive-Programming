def main(n):
    MAX = int(n * 3)
    is_prime = [True] * MAX
    is_prime[0] = False
    is_prime[1] = False
    for i in range(2, n + 1):
        if is_prime[i]:
            for j in range(i * i, n + 3, i):
                is_prime[j] = False
    if n == 1:
        print("1\n1")
        return
    elif n == 2:
        print("1\n1 1")
        return
    print(2)

    ret = []
    for i in range(2, n + 2):
        if not is_prime[i]:
            ret.append(1)
        else:
            ret.append(2)

    print(' '.join(list(map(str,ret))))

main(int(input()))

