# Problem Statement

Suppose an application want to send multiple payloads via its URL, but as there is a limit on number of characters

# My Solution-
using Huffman Coding for zero loss compression and than decompressing the payloads at server side

# Frequency Matrix
************
A       --      12
C       --      1
D       --      6
F       --      7
I       --      1
P       --      2
R       --      3
[       --      2
]       --      2
a       --      19
b       --      29
c       --      19
d       --      19
e       --      40
%       --      16
f       --      19
&       --      5
g       --      2
h       --      4
i       --      12
k       --      1
l       --      11
-       --      16
m       --      14
n       --      20
o       --      18
0       --      11
1       --      19
2       --      8
r       --      5
3       --      25
s       --      11
4       --      16
t       --      9
5       --      8
u       --      9
6       --      14
v       --      3
7       --      9
w       --      3
8       --      5
9       --      12
=       --      6
?       --      1

# Encoded Data
************
A       --      00110
C       --      110001000
D       --      010010
F       --      011001
I       --      110001001
P       --      10101100
R       --      0110000
[       --      10101101
]       --      10101110
a       --      11001
b       --      0111
c       --      11010
d       --      11011
%       --      10010
e       --      1111
&       --      1100011
f       --      11100
g       --      10101111
h       --      1000101
i       --      00111
k       --      110001010
l       --      00011
m       --      01101
-       --      10011
n       --      0000
o       --      10110
0       --      00100
1       --      11101
r       --      000100
2       --      100011
s       --      00101
3       --      0101
4       --      10100
t       --      101110
5       --      101010
u       --      101111
v       --      0110001
6       --      10000
w       --      1000100
7       --      110000
8       --      000101
9       --      01000
=       --      010011
?       --      110001011