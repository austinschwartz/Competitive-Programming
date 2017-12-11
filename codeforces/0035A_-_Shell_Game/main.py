def main():
    out = open('output.txt', 'w')
    x = [0, 0, 0]
    with open('input.txt', 'rb') as f:
        i = int(str(f.readline().strip(), 'utf-8'))
        x[i - 1] = 1
        for j in range(3):
            (a, b) = map(lambda g: int(g) - 1, str(f.readline().strip(), 'utf-8').split(' '))
            temp = x[a]
            x[a] = x[b]
            x[b] = temp
        for i in range(3):
            if x[i] == 1:
                out.write('{}\n'.format(i + 1))
                out.close()
                return
    out.close()

main()
