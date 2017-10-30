m = {
        0: "zero",
        1: "one",
        2: "two",
        3: "three",
        4: "four",
        5: "five",
        6: "six",
        7: "seven",
        8: "eight",
        9: "nine",
        10: "ten",
        11: "eleven",
        12: "twelve",
        13: "thirteen",
        14: "fourteen",
        15: "fifteen",
        16: "sixteen",
        17: "seventeen",
        18: "eighteen",
        19: "nineteen",
        20: "twenty",
        21: "twenty-one",
        25: "twenty-five",
        30: "thirty",
        32: "thirty-two",
        40: "forty",
        50: "fifty",
        58: "fifty-eight",
        60: "sixty",
        64: "sixty-four",
        70: "seventy",
        79: "seventy-nine",
        80: "eighty",
        83: "eighty-three",
        90: "ninety",
        99: "ninety-nine"
}
def main(x):
    if x in m:
        return m[x]
    else:
        s = str(x)
        return "{}-{}".format(m[int(s[0]) * 10], m[int(s[1])])

print(main(int(input())))

