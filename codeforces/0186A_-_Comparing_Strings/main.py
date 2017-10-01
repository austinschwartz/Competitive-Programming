def main():
    s1 = list(input())
    s2 = list(input())
    if len(s1) != len(s2):
        return False
    diff = []
    for i in range(len(s1)):
        if s1[i] != s2[i]:
            diff.append(i)
    if len(diff) == 0:
        return True
    if len(diff) != 2:
        return False
    return s1[diff[0]] == s2[diff[1]] and s2[diff[0]] == s1[diff[1]]

print("YES") if main() else print("NO")
