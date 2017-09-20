#!/usr/bin/env python3
fibs = [0, 1]
for i in range(2, 5001):
    fibs.append(fibs[i-1] + fibs[i-2])
while True:
    try:
        n = int(input())
        print("The Fibonacci number for {} is {}".format(n, fibs[n]))
    except Exception as e:
        break
