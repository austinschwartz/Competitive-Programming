from queue import PriorityQueue

def main():
    (n, m) = map(int, input().split(' '))
    a = list(map(int, input().split(' ')))
    
    pq = PriorityQueue()
    pq2 = PriorityQueue()
    for ai in a:
        pq.put(ai)
        pq2.put(-ai)

    i = 0
    ret = 0
    while i < n and pq.qsize() > 0:
        x = pq.get()
        ret += x
        x -= 1
        i += 1
        if x > 0:
            pq.put(x)

    i = 0
    ret2 = 0
    while i < n and pq2.qsize() > 0:
        x = pq2.get()
        ret2 += -x
        x += 1
        i += 1
        if x < 0:
            pq2.put(x)

    return ret2, ret


print('{} {}'.format(*main()))





