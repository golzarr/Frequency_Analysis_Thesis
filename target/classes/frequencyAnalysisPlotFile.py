import matplotlib.pylab as plt
import sys
import os


# the method to do frequency analysis: we just count the occurrences
# of the given characters
def frequency_analysis(text,LETTERS):
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
    #plain_text = sys.argv[1]
    #freq = frequency_analysis(plain_text)
    #plot_distribution(freq)
	LETTERS = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ'
	
	if (sys.argv[2] == '1'):
		LETTERS = 'AÁÄBCČDĎDZDŽEÉFGHCHIÍJKLĹMNŇOÓÔPQRŔSŠTŤUÚVWXYÝZŽ'
	elif (sys.argv[2] == '2'):
		LETTERS = 'ABCDEFGHIJKLMNÑOPQRSTUVWXYZ'

	
	
	text_file = open(sys.argv[1], "r", encoding='utf-8')
 
	#read whole file to a string
	data = text_file.read()
 
	#close file
	text_file.close()
	
	
	plain_text = data
	freq = frequency_analysis(plain_text,LETTERS)
	plot_distribution(freq)