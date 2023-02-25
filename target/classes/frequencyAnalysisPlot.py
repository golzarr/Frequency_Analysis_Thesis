import matplotlib.pylab as plt
import sys

# these are the letters we are interested in when dealing with frequency-analysis
# WHITE SPACE IS THE MOST FREQUENT 'LETTER' IN THE ENGLISH ALPHABET !!!
LETTERS = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ'


# the method to do frequency analysis: we just count the occurrences
# of the given characters
def frequency_analysis(text):
    # the text we analyse
    text = text.upper()

    # we use a dictionary to store the letter-frequency pair
    letter_frequencies = {}

    # initialize the dictionary (of course with 0 frequencies)
    for letter in LETTERS:
        letter_frequencies[letter] = 0

    # let's consider the text we want to analyse
    for letter in text:
        if letter in LETTERS:
            letter_frequencies[letter] += 1

    return letter_frequencies


def plot_distribution(frequencies):
    plt.bar(frequencies.keys(), frequencies.values())
    plt.show()


if __name__ == '__main__':

    plain_text = sys.argv[1]
    freq = frequency_analysis(plain_text)
    plot_distribution(freq)
