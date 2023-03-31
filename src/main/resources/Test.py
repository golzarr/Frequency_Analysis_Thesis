import sys
from collections import Counter

# Frequencies of each letter in Slovak language
slovak_freq = [9.06, 1.69, 1.33, 3.22, 0.13, 7.75, 0.31, 0.29, 1.23, 6.07, 1.90, 3.76, 3.73, 3.20, 6.34, 9.51, 3.27, 5.05, 4.74, 4.54, 2.65, 5.14, 0.06, 1.53, 1.99]

# Function to find the index of coincidence for a given string
def index_of_coincidence(ciphertext):
    freqs = Counter(ciphertext)
    n = sum(freqs.values())
    ic = 0.0
    for letter, count in freqs.items():
        ic += (count * (count - 1))
    ic /= (n * (n - 1))
    return ic

# Function to calculate the frequency distribution of letters in a string
def frequency_distribution(ciphertext):
    freqs = [0] * 26
    n = 0
    for c in ciphertext:
        if c.isalpha():
            freqs[ord(c.upper()) - ord('A')] += 1
            n += 1
    for i in range(26):
        freqs[i] /= n
    return freqs

# Function to calculate the frequency deviation between two frequency distributions
def frequency_deviation(frequencies):
    deviation = 0.0
    for i in range(26):
        deviation += abs(frequencies[i] - (slovak_freq[i] / 100))
    return deviation

# Function to find the key length of a Vigenere cipher
def find_key_length(ciphertext):
    n = len(ciphertext)
    max_kl = min(n // 3, 20) # set a maximum key length of 20
    ic_values = []
    for kl in range(1, max_kl + 1):
        ics = []
        for i in range(kl):
            substring = ciphertext[i::kl]
            ics.append(index_of_coincidence(substring))
        ic_avg = sum(ics) / kl
        ic_values.append((kl, ic_avg))
    ic_values.sort(key=lambda x: x[1], reverse=True)
    return ic_values[0][0]

# Function to find the most likely key for a given Vigenere ciphertext and key length
def find_key(ciphertext, key_length):
    key = ""
    for i in range(key_length):
        substring = ""
        for j in range(i, len(ciphertext), key_length):
            substring += ciphertext[j]
        freqs = frequency_distribution(substring)
        deviations = []
        for shift in range(26):
            shifted_freqs = freqs[-shift:] + freqs[:-shift]
            deviation = frequency_deviation(shifted_freqs)
            deviations.append((shift, deviation))
        deviations.sort(key=lambda x: x[1])
        key += chr(deviations[0][0] + ord('A'))
    return key

# Function to decrypt a Vigenere ciphertext using a given key
def decrypt_vigenere(ciphertext, key):
    """Decrypts a Vigenere cipher given a ciphertext and key.

    Args:
        ciphertext (str): The ciphertext to be decrypted.
        key (str): The key used to encrypt the ciphertext.

    Returns:
        str: The plaintext message.

    """
    # Convert the key to uppercase
    key = key.upper()

    # Generate the full key by repeating the key until its length matches the ciphertext
    full_key = key
    while len(full_key) < len(ciphertext):
        full_key += key

    # Decrypt the ciphertext using the Vigenere cipher algorithm
    plaintext = ""
    for i in range(len(ciphertext)):
        ciphertext_char = ciphertext[i]
        key_char = full_key[i]
        if ciphertext_char.isalpha():
            # Use the key to calculate the shift value for this character
            shift_value = ord(key_char) - ord('A')
            if ciphertext_char.islower():
                shift_value += 32
            # Shift the character backwards in the alphabet
            plaintext_char = chr((ord(ciphertext_char) - shift_value - 65) % 26 + 65)
            if ciphertext_char.islower():
                plaintext_char = plaintext_char.lower()
            # Append the decrypted character to the plaintext message
            plaintext += plaintext_char
        else:
            # Append non-alpha characters as-is
            plaintext += ciphertext_char

    return plaintext



# function to decrypt the Vigenere cipher
def vigenere_decryption(ciphertext, key):
    plaintext = ""
    key_index = 0
    for char in ciphertext:
        if char.isalpha():
            char_num = ord(char.upper()) - ord('A')
            key_num = ord(key[key_index].upper()) - ord('A')
            new_char = chr(((char_num - key_num) % 26) + ord('A'))
            plaintext += new_char
            key_index = (key_index + 1) % len(key)
        else:
            plaintext += char
    return plaintext

# main function to decrypt the ciphertext
def main(ciphertext):
    # use frequency analysis to find the key length
    key_length = finding_key_length(ciphertext)
    print("Key length: ", key_length)

    # use frequency analysis to find the key
    key = finding_key(ciphertext, key_length)
    print("Key: ", key)

    # decrypt the ciphertext using the key
    plaintext = vigenere_decryption(ciphertext, key)
    print("Plaintext: ", plaintext)

# run the main function with the ciphertext
ciphertext = "TGHJRJRUQGETEGODEBSCHDUJJQHFJBAGRBBKUQRMDCBPIHHBEXRUVAUXHEPCSCWHYHSCDKVLNURUVZAIDXBKUPDJBWKUZCVZOOLRRCSZDDEZIHWDGYYHNRUPEDQRCZTUYLQQJHYYYBANVCJLIVLTRJKDLYUEEDDMHJKNNKVDEBSIPJZDLCYQZAYRCKETSIVZTGHUUCMHXJJMSCYYCHCXBKJBEBVDGTPZZGPYOIDZVAIDWTPDUTLGVGSCDZSFBZYGEXECRIEDICDHFLHZZHCJKZWYUBAHMYGCRNGFJBEBDGPLTNNYACNUQRQMECHRUWVPHJRFHZYHYWPGHUEGAPNRTWRZVEEGADDDUCSCDELWCCHDZWNNYJAQVDLTPZIQRCYQVNZXRHPGLTMJDTDDBDOHWRAFZZZIVYOIRKCCRAODRQDHWYCHEHWYUQBZODUJSIHKJGEDNPTDOTZDJZODRCYCTANHUYUGHGGWIBHKVPEHLKBGATLRYCBZWLEZTNURQFSNRKVGAGNYFHTZQYFCLZZHFDEDXUPJBLVRUQVGDKPZIIURCWNNPJWCKZMGDZEHWUJZINWGPY"
main(ciphertext)
