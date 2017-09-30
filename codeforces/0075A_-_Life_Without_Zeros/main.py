def main():
    def f(s):
        return int(''.join((filter(lambda x: x != '0', list(str(s))))))
    a = int(input())
    b = int(input())
    aa = f(a)
    bb = f(b)
    return f(a + b) == aa + bb

print("YES") if main() else print ("NO")
