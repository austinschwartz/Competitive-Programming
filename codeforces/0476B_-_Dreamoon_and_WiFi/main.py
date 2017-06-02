s1 = list(input())
s2 = list(input())
n = len(s1)

pos = [0]
for i in range(n):
    if s1[i] == '+':
        pos.append(pos[i] + 1)
    else:
        pos.append(pos[i] - 1)

#print(pos)

pos2 = [[0]]
for i in range(n):
    if s2[i] == '?':
        a = []
        for j in pos2[i]:
            a.append(j + 1)
            a.append(j - 1)
        pos2.append(a)
    elif s2[i] == '+':
        a = []
        for j in pos2[i]:
            a.append(j + 1)
        pos2.append(a)
    elif s2[i] == '-':
        a = []
        for j in pos2[i]:
            a.append(j - 1)
        pos2.append(a)

count = 0
for t in pos2[-1]:
    if t == pos[-1]:
        count += 1

#print(count, "out of", len(pos2[-1]))
print("{:0.15f}".format(count / len(pos2[-1])))
