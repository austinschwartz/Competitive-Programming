import sys

n = int(sys.stdin.readline())

i = 0
while n > 9:
    n = sum(map(int, list(str(n)))) 
    i += 1

sys.stdout.write(str(i) + '\n')
