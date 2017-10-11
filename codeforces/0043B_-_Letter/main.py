from collections import defaultdict

def main():
    s1 = input().split(' ')
    s2 = input().split(' ')

    d = defaultdict(int)

    for word in s1:
        for ch in list(word):
            d[ch] += 1

    for word in s2:
        for ch in list(word):
            d[ch] -= 1
            if d[ch] < 0:
                return False

    return True
        
print("YES") if main() else print("NO")
