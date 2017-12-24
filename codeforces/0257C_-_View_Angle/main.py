def main():
    from sys import stdin, stdout
    from math import atan2, pi
    n = int(stdin.readline().strip())
    angles = []
    for i in range(n):
        (x, y) = map(float, stdin.readline().strip().split(' '))
        angles.append((atan2(y, x) * 180 / pi) % 360)
    angles = sorted(angles)
    m = 0
    for i in range(n - 1):
        m = max(m, angles[i + 1] - angles[i])
    m = max(m, (angles[0] - angles[-1]) % 360)
    stdout.write('{:.15f}\n'.format((360 - m) % 360))
main()

