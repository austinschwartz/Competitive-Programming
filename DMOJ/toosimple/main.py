import string
import sys

def Hello():
    pass
def World():
    pass

sys.stdout.write(Hello.__name__)
a = list(string.punctuation)
a.pop()
a.pop()
a.pop()
a.pop()
a.pop()
a.pop()
a.pop()
a.pop()
a.pop()
a.pop()
a.pop()
a.pop()
a.pop()
a.pop()
a.pop()
a.pop()
a.pop()
a.pop()
a.pop()
a.pop()
sys.stdout.write(a.pop())
x = list(string.whitespace)
x.reverse()
sys.stdout.write(x.pop())
a.pop()
a.pop()
a.pop()
a.pop()
a.pop()
a.pop()
a.pop()
a.pop()
a.pop()
a.pop()
sys.stdout.write(World.__name__)
sys.stdout.write(a.pop())
