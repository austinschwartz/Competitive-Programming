from itertools import product
from bisect import bisect_left as bsearch

def main():
    luckies = []
    for i in range(12):
        for p in product([4, 7], repeat=i):
            if len(p) > 0:
                fours = 0
                sevens = 0
                for num in p:
                    if num == 7:
                        sevens += 1
                    else:
                        fours += 1
                if fours == sevens:
                    x = ''.join(map(str, p))
                    luckies.append(int(x))
    luckies = sorted(luckies)
    i = bsearch(luckies, int(input()))
    return luckies[i]
    
print(main())
