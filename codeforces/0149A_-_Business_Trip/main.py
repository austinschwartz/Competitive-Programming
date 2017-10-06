from queue import PriorityQueue

def main():
    k = int(input())
    a = list(map(int, input().split(' ')))
    if k == 0:
        return 0
    pq = PriorityQueue()
    for num in a:
        pq.put(-1 * num)
    months = 0 
    while k > 0 and pq.qsize() > 0:
        k -= -1 * pq.get()
        months += 1
    if k > 0:
        return -1
    return months

print(main())
