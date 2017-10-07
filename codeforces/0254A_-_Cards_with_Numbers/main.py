import atexit
import io
import sys

def main():
    with open('input.txt') as f:
        n = int(f.readline())
        a = f.readline().rstrip().split(' ')

        m = {}

        for i, ai in enumerate(a):
            if ai not in m:
                m[ai] = set()
            m[ai].add(i)

        ans = ""
        for k in m:
            if len(m[k]) % 2 != 0:
                return "-1"
        for k in m:
            while len(m[k]) > 0:
                ans += "{} {}\n".format(m[k].pop() + 1, m[k].pop() + 1)
        return ans

with open('output.txt', 'w+') as out:
    print(main().rstrip(), file=out)

