import matplotlib.pylab as plt
import sys

# these are the letters we are interested in when dealing with frequency-analysis
LETTERS = ''


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
    translated=freq;
    #freq = sorted(freq.items(), key=lambda x: x[1], reverse=True)
    #print(freq[0][0])
    #print(freq[1][0])
    #print(LETTERS.find(freq[0][0]))
    #print(LETTERS.find('E'))
    #print("The possible key value: %s" % (LETTERS.find(freq[0][0]) -
    #                                      LETTERS.find('E')))
    out = str(translated) +"\n"
    
    
    #for i in range(len(LETTERS)):
       #print(LETTERS[i])
       #out+=str(freq[i][0] +'-'+ str(freq[i][1])+"\n")
    
    print(out)
    
      
    
def printString(S, N):
	
	plaintext = [None] * 26
	
	freq = frequency_analysis(text)	
	T = "ETAOINSHRDLCUMWFGYPBVKJXQZ"
	curr = ""
		
	# Generate the probable ith plaintext
	# string using the shift calculated above
	for k in range(N):
			x = ord(T[k]) - 65
			if S[k] == ' ':
				curr += " "
				continue
			
			# Shift the kth letter of the
			# cipher by x
			y = ord(S[k]) - 65
			y += x
			
			if y < 0:
				y += 26
			if y > 25:
				y -= 26
			
			# Add the kth calculated/shifted
			# letter to temporary string	
			curr += chr(y + 65)
		
			plaintext[k] = curr
	
	for i in range(26):
		print(plaintext[i])



    
    

if __name__ == '__main__':

	text = sys.argv[1]
	mode = 'encrypt'
	
	if (sys.argv[2] == '1'):
		mode = 'encrypt'
	elif (sys.argv[2] == '2'):
		mode = 'decrypt'
		
	LETTERS = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ'
	
	if (sys.argv[3] == '1'):
		LETTERS = 'AÁÄBCČDĎDZDŽEÉFGHCHIÍJKLĹMNŇOÓÔPQRŔSŠTŤUÚVWXYÝZŽ'
	elif (sys.argv[3] == '2'):
		LETTERS = 'ABCDEFGHIJKLMNÑOPQRSTUVWXYZ'

	#cipher_text = 'cey jeiia seii ke mle nfnie'
	crack(text)
	
	S = text
	N = len(S)

	# Function Call
	printString(S, N)
    