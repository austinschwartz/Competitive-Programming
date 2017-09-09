import sys
s = sys.stdin.readline()
n = len(s)

ret = False

a = s.find("AB")
if a != -1 and s.find("BA", a + 2) != -1:
    ret = True

if not ret:
    a = s.find("BA")
    if a != -1 and s.find("AB", a + 2) != -1:
        ret = True

sys.stdout.write("YES\n" if ret else "NO\n")

