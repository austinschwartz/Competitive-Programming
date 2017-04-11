s = input()
ones = 0
zeros = 0
for ch in s:
    if ch == '1':
        ones += 1
        zeros = 0
    else:
        zeros += 1
        ones = 0
    if ones == 7 or zeros == 7:
        ones = -9999
        print("YES")
        break

if ones != -9999:
    print("NO")
