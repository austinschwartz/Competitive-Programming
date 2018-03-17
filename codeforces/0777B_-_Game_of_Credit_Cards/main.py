#!/usr/bin/env python3

def main():
    from collections import Counter
    n = int(input())
    s = list(map(int, list(input())))
    m = list(map(int, list(input())))

    m_map = Counter(m)
    flicks = 0
    for i in s:
        played = False
        for j in range(i, 10):
            if m_map[j] > 0:
                played = True
                #print("using ", j)
                m_map[j] -= 1
                if i > j:
                    flicks += 1
                break
        if not played:
            for j in range(0, i):
                if m_map[j] > 0:
                    played = True
                    #print("x using ", j, i)
                    m_map[j] -= 1
                    if i > j:
                        flicks += 1
                    break
    print(flicks)

    m_map = Counter(m)
    flicks = 0
    for i in s:
        played = False
        for j in range(i+1, 10):
            if m_map[j] > 0:
                played = True
                #print("using ", j)
                m_map[j] -= 1
                if j > i:
                    flicks += 1
                break
        if not played:
            for j in range(0, i + 1):
                if m_map[j] > 0:
                    played = True
                    #print("using ", j)
                    m_map[j] -= 1
                    if j > i:
                        flicks += 1
                    break
    print(flicks)

main()
