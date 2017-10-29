def main():
    l = []
    while True:
        try: 
            l.append(input())
        except Exception as e:
            break
    s = set()
    r = 0
    for line in l:
        if line[0] == '+':
            s.add(line[1:])
        elif line[0] == '-':
            s.remove(line[1:])
        else:
            r += (len(s) * len(line.split(":")[1]))
    return r

print(main())
