import sys, random


LETTERS = ''

def main(text,key,mode,pLetters):
    LETTERS = pLetters
    myMessage = text
    #print(key)
    myKey=normalizeKey(key,LETTERS)
    myMode = mode
    #print(text)
    #print(myKey)
    #print(mode)
    if not keyIsValid(myKey):
        sys.exit('There is an error in the key or symbol set.')
    if myMode == 'encrypt':
        translated = encryptMessage(myKey, myMessage)
    elif myMode == 'decrypt':
        translated = decryptMessage(myKey, myMessage)
    #print('Using key %s' % (myKey))
    #print('The %sed message is:' % (myMode))
    
    TestText2 = translated.encode('utf8')
    sys.stdout.buffer.write(TestText2)
    #print(translated)
    

def keyIsValid(key):
    keyList = list(key)
    lettersList = list(LETTERS)
    keyList.sort()
    lettersList.sort()

    return keyList == lettersList


def encryptMessage(key, message):
    return translateMessage(key, message, 'encrypt')


def decryptMessage(key, message):
    return translateMessage(key, message, 'decrypt')


def translateMessage(key, message, mode):
    translated = ''
    charsA = LETTERS
    charsB = key
    if mode == 'decrypt':
        # For decrypting, we can use the same code as encrypting. We
        # just need to swap where the key and LETTERS strings are used.
        charsA, charsB = charsB, charsA

    # Loop through each symbol in message:
    for symbol in message:
        if symbol.upper() in charsA:
            # Encrypt/decrypt the symbol:
            symIndex = charsA.find(symbol.upper())
            if symbol.isupper():
                translated += charsB[symIndex].upper()
            else:
                translated += charsB[symIndex].lower()
        else:
            # Symbol is not in LETTERS; just add it
            translated += symbol

    return translated


def getRandomKey():
    key = list(LETTERS)
    random.shuffle(key)
    return ''.join(key)


def normalizeKey(plain_text, ALPHABET):
    newKey_text = ''
    # we make the algorithm case insensitive
    plain_text = plain_text.upper()

    # consider all the letters in the Key
    for c in plain_text:
        ALPHABET= ALPHABET.replace(c, '')

    newKey_text=plain_text+ALPHABET
    return newKey_text


if __name__ == '__main__':
	
	text = sys.argv[1]
	key = sys.argv[2]
	mode = 'encrypt'
	
	if (sys.argv[3] == '1'):
		mode = 'encrypt'
	elif (sys.argv[3] == '2'):
		mode = 'decrypt'
		
	LETTERS = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ'
	
	if (sys.argv[4] == '1'):
		LETTERS = 'AÁÄBCČDĎDZDŽEÉFGHCHIÍJKLĹMNŇOÓÔPQRŔSŠTŤUÚVWXYÝZŽ'
	elif (sys.argv[4] == '2'):
		LETTERS = 'ABCDEFGHIJKLMNÑOPQRSTUVWXYZ'
	
	
	main(text,key,mode,LETTERS)