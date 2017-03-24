# http://www.mathopenref.com/squarediagonals.html

import math

(s, r) = map(int, input().split(' '))

SA = s * s # Square area
GA = math.pi * r * r # Goat area
d = math.sqrt(s * s + s * s) # Square diagonal

res = 0
if 2 * r < s: # Goat area is entirely contained in room
    res = GA
elif 2 * r * r >= s * s: # Goat has eaten the entire room
    res = SA
else:
    half = s / 2.0
    n = math.sqrt(r * r - half * half)
    z = math.asin(n / r) * r * r - n * half
    res = GA - (4 * z)
    
print("%.3f" % res)
