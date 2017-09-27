import sys

sys.stdout.write("{}\n".format(4 - len(set(map(int, sys.stdin.readline().split(' '))))))

