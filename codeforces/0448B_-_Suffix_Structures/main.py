from collections import defaultdict

def sub(a, b):
    i = 0
    j = 0
    while i < len(a):
        if a[i] == b[j]:
            j += 1
            if j == len(b):
                return True
        i += 1
    return False

def compare(a, b):
    automaton = sub(a, b)
    array = True
    both = True
    m = [0] * 26
    for c in a:
        m[ord(c) - ord('a')] += 1
    for c in b:
        m[ord(c) - ord('a')] -= 1
    for i in range(26):
        if m[i] != 0:
            array = False
        if m[i] < 0:
            both = False
    if automaton:
        return "automaton"
    elif array:
        return "array"
    elif both:
        return "both"
    return "need tree"

def main():
    a = input()
    b = input()
    return compare(a, b)

print(main())
        
