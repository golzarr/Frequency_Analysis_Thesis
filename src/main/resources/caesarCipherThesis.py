import sys
# we need the alphabet because we convert letters into numerical values
# to be able to use mathematical operations (NO encrypting the spaces or characters)
ALPHABET = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ'



def caesar_encrypt(plain_text, KEY):
    # the encrypted message
    cipher_text = ''
    # we make the algorithm case insensitive
    plain_text = plain_text.upper()

    # consider all the letters in the plain_text
    for c in plain_text:
        # find the numerical representation (index) associated with
        # that character in the alphabet
        index = ALPHABET.find(c)
        # ingnoring the blank spaces
        if (index == -1):
            cipher_text = cipher_text + c
        else:    
        	# caesar encryption is just a simple shift of characters according
        	# to the key use modular arithmetic to transform the values within
        	# the range [0,num_of_letters_in_alphabet]
        	index = (index + int(KEY)) % len(ALPHABET)
        	# keep appending the encrypted character to the cipher_text
        	cipher_text = cipher_text + ALPHABET[index]

    return cipher_text


def caesar_decrypt(cipher_text,KEY):

    plain_text = ''

    for c in cipher_text:
        index = ALPHABET.find(c)
        # ingnoring the blank spaces
        if(index==-1):
           plain_text = plain_text + c
        else:
           index = (index - int(KEY)) % len(ALPHABET)
           plain_text = plain_text + ALPHABET[index]

    return plain_text


if __name__ == '__main__':
    #Arguments
    m = sys.argv[3]
    
    if (sys.argv[1] == '0'):
        encrypted = caesar_encrypt(m,sys.argv[2])
        print(encrypted)
    
    elif (sys.argv[1] == '1'):
    	print(caesar_decrypt(m,sys.argv[2]))
        #print(caesar_decrypt(encrypted))

