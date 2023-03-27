import sys
import matplotlib.pyplot as plt
from collections import Counter

# These are the letters we are interested in when dealing with frequency analysis
LETTERS = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ'
letters_frequency = "ETAOINSHRDLCUMWFGYPBVKJXQZ"

def frequency_analysis(text):
    text = text.upper()
    letter_frequency = Counter(letter for letter in text if letter in LETTERS)
    return letter_frequency

def plot_distribution(letter_frequency):
    plt.bar(letter_frequency.keys(), letter_frequency.values())
    plt.show()

def decrypt(text, substitution):
    decrypted_text = ''
    text = text.upper()

    for letter in text:
        if letter in substitution:
            index = substitution.index(letter)
            decrypted_text += LETTERS[index]
        else:
            decrypted_text += letter
    return decrypted_text

def crack(text):
    freq = frequency_analysis(text)
    freq = sorted(freq.items(), key=lambda x: x[1], reverse=True)

    substitution = ''.join([pair[0] for pair in freq])
    decrypted_text = decrypt(text, substitution)

    print(f"Substitution: {substitution}")
    print(f"Decrypted text: {decrypted_text}")

if __name__ == '__main__':
    text = sys.argv[1]
    crack(text)
