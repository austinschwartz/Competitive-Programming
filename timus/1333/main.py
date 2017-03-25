import math
SIZE = 300

board = [[False for _ in range(SIZE)] for _ in range(SIZE)]
N = int(input())
for n in range(N):
    (x, y, r) = map(lambda g : int(float(g) * SIZE), input().split(' '))
    for i in range(SIZE):
        for j in range(SIZE):
            if board[i][j] == False:
                if (j - x)*(j - x) + (i - y)*(i - y) < r * r:
                    board[i][j] |= True
    
marked = 0
for i in range(SIZE):
    for j in range(SIZE):
        if board[i][j]:
            marked += 1

percent_covered = (marked / (SIZE*SIZE))*100

print("%.5f" % (percent_covered))
