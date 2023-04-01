import numpy as np
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
        english_freq = [8.2, 1.5, 2.8, 4.3, 13, 2.2, 2, 6.1, 7, 0.15, 0.77, 4, 2.4, 6.7, 7.5, 1.9, 0.095, 6, 6.3, 9.1, 2.8, 0.98, 2.4, 0.15, 2, 0.074]

        substrings = [ciphertext[i::key_length] for i in range(key_length)]


        x = np.arange(26)
        data = np.full(26,0)

        for char in substrings[k]:
            lett = ord(char) - 65 # converting all letter from ASCII range to (0,25) range
            data[lett] += 1 # data is the frequency of each letter


        tot = 0
        tot2 = 0
        for i in range(26):
            tot += data[i]
            tot2 += english_freq[i]
        for i in range(26):
            data[i] = data[i]*tot2/tot

        error = []
        for shift in range(26):
            err = 0
            for i in range(26):
                err += sqrt((data[i] - english_freq[(i + shift) % 26]) ** 2)
            error.append(err)


        # Finding the best match
        guess = 0
        best = error[0]

        for i in range(26):
            if error[i] < best:
                guess = i
                best = error[i]


        key = key + chr((26-guess) % 26 + 65)

    return key

# Function to decrypt the ciphertext
def deciphering(ciphertext,key):
    plaintext = ""
    for i, c in enumerate(ciphertext):
        if c not in string.ascii_uppercase:
            plaintext += c
        else:
            shift = string.ascii_uppercase.index(key[i % len(key)])
            plaintext += string.ascii_uppercase[(string.ascii_uppercase.index(c) - shift) % 26]
    return plaintext



# Calling the functions to find the keylength, key and plaintext:

key_length = finding_keylength(ct)
#print("Key length is ",key_length)

key = finding_key(ct,key_length)
#print("Key is: ", key)

plaintext = deciphering(ct,key)
print(plaintext)