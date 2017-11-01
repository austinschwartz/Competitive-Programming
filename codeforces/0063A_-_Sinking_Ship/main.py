def main():
    def clear(t):
        nonlocal n, q
        for i in range(n):
            if q[i] == None:
                continue
            if q[i][1] in t:
                print(q[i][0])
                q[i] = None
    n = int(input())
    q = []
    for i in range(n):
        q.append(input().split(' '))
    clear(set(["rat"]))
    clear(set(["woman", "child"]))
    clear(set(["man"]))
    clear(set(["captain"]))
main()

