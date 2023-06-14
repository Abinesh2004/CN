def binary(a1,a2):
    a3 = ""
    a4 = ""
    ad = ""
    c = 0
    for i in range(len(a1)-1,-1,-1):
        if(c==0):
            if (a1[i]=="0" and a2[i]=="0"):
                a3 += a1[i] 
            elif (a1[i]=="0" and a2[i]=="1"):
                a3 += str(1)
            elif (a1[i]=="1" and a2[i]=="0"):
                a3 += str(1)
            elif (a1[i]=="1" and a2[i]=="1"):
                a3 += str(0)    
                c = 1
        
        elif (c==1):
            if (a1[i]=="0" and a2[i]=="0"):
                a3 += str(1)
                c = 0
            elif (a1[i]=="0" and a2[i]=="1"):
                a3 += str(0)
                c = 1
            elif (a1[i]=="1" and a2[i]=="0"):
                a3 += str(0)
                c = 1
            elif (a1[i]=="1" and a2[i]=="1"):
                a3 += str(1)    
                c = 1
    for i in range(len(a1)):
        if(c==1):
            if (a3[i]=="0"):
                a4 += str(1) 
                c = 0
                
            elif (a3[i]=="1"):
                a4  += str(0)
                c = 1
                
        elif (c==0):
            a4 += a3[i]
    a4 = (a4[::-1])
    return a4

def flip(c):
    return '1' if (c == '0') else '0'

def onecomplement(bin):

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

def conv(x):
    res = "{0:08b}".format(int(x, 16))
    return res

n = int(input())
a=""
for i in range(n):
    x = input()
    x = conv(x)
    ad = ""
    if(len(x)<16):
        ad = "0"*(16-len(x))
        x = ad + x
    if(i==0):
        a = x
    else:
        a = binary(a,x) 
y = onecomplement(a)
str =""
for i in y:
    str += i
y = int(str,2)
y = hex(y)
y = y[2:] 
if(len(y)<4):
    y = "0"*(4-len(y)) + y
y = y.upper()
print(y)
