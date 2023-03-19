import matplotlib.pylab as plt
import sys

# these are the letters we are interested in when dealing with frequency-analysis
LETTERS = ''
letters_frequency = ''

# the method to do frequency analysis: we just count the occurrences of the given characters
def frequency_analysis(text):
    # the text we analysis
    text = text.upper()

    # we use a dictionary to store the letter-frequency pair
    letter_frequency = {}

    # initialize the dictionary (of course with 0 frequencies)
    for letter in LETTERS:
        letter_frequency[letter] = 0

    # let's consider the text we want to analyse
    for letter in text:
        # we keep incrementing the occurrence of the given letter
        if letter in LETTERS:
            letter_frequency[letter] += 1

    return letter_frequency


# plot the histogram of the letter-frequency pairs
def plot_distribution(letter_frequency):
    plt.bar(letter_frequency.keys(), letter_frequency.values())
    plt.show()


def crack(text):
    translated=''
    freq = frequency_analysis(text)
    freq = sorted(freq.items(), key=lambda x: x[1], reverse=True)
    #print(freq[1][0])
    #print(LETTERS.find(freq[0][0]))
    #print(LETTERS.find('E'))
    #print("The possible key value: %s" % (LETTERS.find(freq[0][0]) -
    #                                      LETTERS.find('E')))
    text = text.upper()
    out=''
    outPosible=''
    for i in range(len(LETTERS)):
       out+=str(freq[i][0] +'-'+ str(freq[i][1])+";")
       if(freq[i][1] > 0):
          text = text.replace(freq[i][0],letters_frequency[i])
          outPosible+="Possible Value: "+text+"\n"
     
    print(out+"\n"+outPosible) 
    
if __name__ == '__main__':

	text = sys.argv[1]
	mode = 'encrypt'
	
	if (sys.argv[2] == '1'):
		mode = 'encrypt'
	elif (sys.argv[2] == '2'):
		mode = 'decrypt'
		
	LETTERS = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ'
	letters_frequency = "ETAOINSHRDLCUMWFGYPBVKJXQZ"
	
	if (sys.argv[3] == '1'):
		LETTERS = 'AÁÄBCČDĎDZDŽEÉFGHCHIÍJKLĹMNŇOÓÔPQRŔSŠTŤUÚVWXYÝZŽ'
		letters_frequency = 'AOESNITRVLKDMCUPZYHJGFBQWX'
	elif (sys.argv[3] == '2'):
		LETTERS = 'ABCDEFGHIJKLMNÑOPQRSTUVWXYZ'
		letters_frequency = 'EAOSRNIDLCTUMPBGYÍVQÓHFZJÉÁÑXÚÜWK'

	#cipher_text = 'cey jeiia seii ke mle nfnie'
	crack(text)