from sys import stdin, stdout

def main(s):
    segs = []
    cur = [0, 0, s[0]]
    for i, c in enumerate(s[1:]):
        if cur[2] != c:
            segs.append(cur)
            cur = [i, i, c]
            prev = c
        else:
            cur[1] += 1
    segs.append(cur)

    for seg in segs:
        if seg[1] - seg[0] + 1 > 2:
            seg[1] = seg[0] + 1

    for i in range(len(segs) - 1):
        sega = segs[i]
        segb = segs[i + 1]
        if sega[1] - sega[0] + 1 == 2 and segb[1] - segb[0] + 1 == 2:
            segb[1] = segb[0]

    for seg in segs:
        stdout.write('{}'.format(seg[2] * (seg[1] - seg[0] + 1)))
    stdout.write("\n")

main(stdin.readline().strip())
