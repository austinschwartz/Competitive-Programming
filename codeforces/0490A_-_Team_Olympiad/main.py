from collections import defaultdict

def main():
    n = int(input())
    a = list(map(int, input().split(' ')))
    m = defaultdict(list)
    for i, ai in enumerate(a):
        m[ai].append(str(i + 1))

    x = int(1e8)
    for i in range(1, 4):
        x = min(len(m[i]), x)

    ret = []
    for i in range(1, 4):
        ret.append(m[i][:x])
    print(x)
    for line in zip(*ret):
        print(' '.join(line))

main()
