from sys import stdin, stdout

def main(n, k):
    if k > n or (k == 1 and n > 1):
        stdout.write("-1\n")
        return
    i = 0
    while i < n - k + 2:
        stdout.write("a")
        i += 1
        if i < n - k + 2 and i < n:
            stdout.write("b")
        i += 1
    for i in range(k - 2):
        stdout.write(chr(ord('c') + i))
    stdout.write("\n")

(n, k) = map(int, stdin.readline().strip().split(' '))
main(n, k)
