def checksum(bin_array):
    result = 0
    for num in bin_array:
        result += num
        if result >= 256:
            result -=255 
    return result

def checksum_binstrs(ascii_bin_array):
    bin_array = list(map(lambda x: int(x,2),ascii_bin_array))
    result = checksum(bin_array)
    return bin(result)

def flip(c):
    return '1' if (c == '0') else '0'

def printOneComplement(bin):

    n = len(bin)
    ones = ""
    twos = ""
    
    for i in range(n):
        ones += flip(bin[i])

    ones = list(ones.strip(""))
    twos = list(ones)
    for i in range(n - 1, -1, -1):
    
        if (ones[i] == '1'):
            twos[i] = '0'
        else:        
            twos[i] = '1'
            break
    i -= 1    
    if (i == -1):
        twos.insert(0, '1')

    return ones

a = int(input())
l = []
for i in range(a):
    n = int(input(),2)
    l.append(n)
m = []
for j in range(len(l)):
    m.append((bin(l[j])))
b = int(input())
c = checksum_binstrs(m)
final = [str((int(bin(b),2))),c[2::]]
check = (checksum_binstrs(final))
bin = check[2::]
one = (printOneComplement(bin.strip("")))
if ( one == ['0', '0', '0', '0', '0', '0', '0', '0'] ):
    print("Error free")
else:
    print("Error")
