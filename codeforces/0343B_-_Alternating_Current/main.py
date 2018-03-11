def main(braid):
    def c(braid):
        ret = []
        i = 0
        if len(braid) == 2:
            if braid[0] == braid[1]:
                return []
            else:
                return braid
        while i < len(braid):
            if i < len(braid) - 1 and braid[i] == braid[i + 1]:
                i += 2
            else:
                ret.append(braid[i])
                i += 1
        return ret
    x = c(braid)
    while len(x) != 0:
        y = c(x)
        if x == y:
            break
        x = y
    return len(x) == 0



print("Yes" if main(list(input())) else "No")
