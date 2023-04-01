import numpy as np
import collections
import string
from math import sqrt
import sys

# get ciphertext from command line argument
ct = sys.argv[1]



# Function to find the keylength
def finding_keylength(ciphertext):

    coincidence = []
    for i in range(2,31):
        count = 0
        for j in range(0,len(ct) - i):
            if ciphertext[j] == ciphertext[j + i]:
                count += 1
        coincidence.append(count) # a list

  #  for n in range(len(coincidence)):
  #      print("Number of coincidences for ",n + 2," shifts are ",coincidence[n],"\n" )

    # maximum coincidence is as follow:
    max_coincidence = max(coincidence) # a number

    # number of shift at which maximum coincidence occurs:
    shift = coincidence.index(max_coincidence) + 2 # index of maximum number of the list


    #listing the coincidences in increasing to decreasing order
    coincidence2 = list(set(coincidence)) #removing duplicates


    max2 = np.gcd(coincidence.index(max_coincidence)+2,coincidence.index(coincidence2[-2])+2)


    max3 = np.gcd(coincidence.index(max_coincidence)+2,coincidence.index(coincidence2[-3])+2)


    max4 = np.gcd(coincidence.index(max_coincidence)+2,coincidence.index(coincidence2[-4])+2)


    lst = [max2,max3,max4]
    return (max(set(lst), key = lst.count))


# Function to find the key
def finding_key(ciphertext, key_length):
    key = ""
    for k in range(key_length):
        # frequency in english text of A to Z:
        slovak_freq = [9.66, 1.13, 3.34, 2.98, 9.01, 0.72, 0.64, 2.33, 7.08, 2.41, 4.06, 2.86, 3.14, 6.2, 10.3, 2.78, 0,
                       4.63, 5.11, 6.44, 3.78, 4.31, 0, 0.16, 3.42, 3.5]



        substrings = [ciphertext[i::key_length] for i in range(key_length)]


        x = np.arange(25)
        data = np.full(26,0)

        for char in substrings[k]:
            lett = ord(char) - 65 # converting all letter from ASCII range to (0,25) range
            data[lett] += 1 # data is the frequency of each letter


        tot = 0
        tot2 = 0
        for i in range(25):
            tot += data[i]
            tot2 += slovak_freq[i]
        for i in range(25):
            data[i] = data[i]*tot2/tot

        error = []
        for shift in range(25):
            err = 0
            for i in range(25):
                err += sqrt((data[i] - slovak_freq[(i + shift) % 25]) ** 2)
            error.append(err)


        # Finding the best match
        guess = 0
        best = error[0]

        for i in range(25):
            if error[i] < best:
                guess = i
                best = error[i]


        key = key + chr((25-guess) % 25 + 65)

    return key

# Function to decrypt the ciphertext
def deciphering(ciphertext,key):
    plaintext = ""
    for i, c in enumerate(ciphertext):
        if c not in string.ascii_uppercase:
            plaintext += c
        else:
            shift = string.ascii_uppercase.index(key[i % len(key)])
            plaintext += string.ascii_uppercase[(string.ascii_uppercase.index(c) - shift) % 25]
    return plaintext



# Calling the functions to find the keylength, key and plaintext:

key_length = finding_keylength(ct)
#print("Key length is ",key_length)

key = finding_key(ct,key_length)
#print("Key is: ", key)

plaintext = deciphering(ct,key)
print(plaintext)