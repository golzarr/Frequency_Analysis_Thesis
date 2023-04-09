import string
import sys
from collections import Counter


def frequency_analysis(ciphertext):
    english_freq = {
        'A': 0.08167, 'B': 0.01492, 'C': 0.02782, 'D': 0.04253,
        'E': 0.12702, 'F': 0.02228, 'G': 0.02015, 'H': 0.06094,
        'I': 0.06966, 'J': 0.00153, 'K': 0.00772, 'L': 0.04025,
        'M': 0.02406, 'N': 0.06749, 'O': 0.07507, 'P': 0.01929,
        'Q': 0.00095, 'R': 0.05987, 'S': 0.06327, 'T': 0.09056,
        'U': 0.02758, 'V': 0.00978, 'W': 0.02360, 'X': 0.00150,
        'Y': 0.01974, 'Z': 0.00074
    }

    ciphertext = ciphertext.upper()
    letter_count = Counter(ciphertext)
    total_letters = sum(letter_count.values())

    chi_squared = {}
    for shift in range(26):
        chi = 0
        for letter in string.ascii_uppercase:
            expected_frequency = english_freq[letter] * total_letters
            shifted_letter = chr(((ord(letter) - ord('A') + shift) % 26) + ord('A'))
            observed_frequency = letter_count.get(shifted_letter, 0)
            chi += (observed_frequency - expected_frequency) ** 2 / expected_frequency
        chi_squared[shift] = chi

    best_shift = min(chi_squared, key=chi_squared.get)
    return best_shift


def caesar_decrypt(ciphertext, shift):
    plaintext = ""
    for char in ciphertext:
        if char.isalpha():
            base = 'A' if char.isupper() else 'a'
            new_char = chr(((ord(char) - ord(base) - shift) % 26) + ord(base))
            plaintext += new_char
        else:
            plaintext += char
    return plaintext


ciphertext = sys.argv[1]
shift = frequency_analysis(ciphertext)
plaintext = caesar_decrypt(ciphertext, shift)
print(plaintext)
