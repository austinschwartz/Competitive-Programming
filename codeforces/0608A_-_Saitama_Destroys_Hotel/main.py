def main():
    (n, s) = map(int, input().split(' '))
    m = {}
    for i in range(n):
        (f, t) = map(int, input().split(' '))
        if f not in m:
            m[f] = t
        else:
            m[f] = max(t, m[f])
    time = 0
    while s > 0:
        if s in m:
            time += max(0, (m[s] - time))
        s -= 1
        time += 1
    print(time)
main()
        
