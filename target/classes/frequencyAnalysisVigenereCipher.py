import numpy as np
import string
from math import sqrt
import sys

ct = sys.argv[1]




def determine_key_length(cipher_text):

    coincidences = []
    for i in range(2,31):
        count = 0
        for j in range(0,len(ct) - i):
            if cipher_text[j] == cipher_text[j + i]:
                count += 1
        coincidences.append(count)


    max_coincidence = max(coincidences)


    change = coincidences.index(max_coincidence) + 2



    coincidence2 = list(set(coincidences))


    max2 = np.gcd(coincidences.index(max_coincidence)+2,coincidences.index(coincidence2[-2])+2)
    max3 = np.gcd(coincidences.index(max_coincidence)+2,coincidences.index(coincidence2[-3])+2)
    max4 = np.gcd(coincidences.index(max_coincidence)+2,coincidences.index(coincidence2[-4])+2)


    lst = [max2,max3,max4]
    return (max(set(lst), key = lst.count))



def compute_key(ciphertext, key_length):
    key = ""
    for k in range(key_length):
        english_freq = [8.2, 1.5, 2.8, 4.3, 13, 2.2, 2, 6.1, 7, 0.15, 0.77, 4, 2.4, 6.7, 7.5, 1.9, 0.095, 6, 6.3, 9.1, 2.8, 0.98, 2.4, 0.15, 2, 0.074]

        substrings = [ciphertext[i::key_length] for i in range(key_length)]


        x = np.arange(26)
        data = np.full(26,0)

        for char in substrings[k]:
            lett = ord(char) - 65
            data[lett] += 1


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



        guess = 0
        best = error[0]

        for i in range(26):
            if error[i] < best:
                guess = i
                best = error[i]


        key = key + chr((26-guess) % 26 + 65)

    return key


def decrypt_text(ciphertext,key):
    decrypted_text  = ""
    for i, c in enumerate(ciphertext):
        if c not in string.ascii_uppercase:
            decrypted_text += c
        else:
            shift = string.ascii_uppercase.index(key[i % len(key)])
            decrypted_text += string.ascii_uppercase[(string.ascii_uppercase.index(c) - shift) % 26]
    return decrypted_text





key_length = determine_key_length(ct)


key = compute_key(ct,key_length)

plaintext = decrypt_text(ct,key)
print(plaintext)