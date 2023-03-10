import sys, random

Alphabet = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ'

def main(myMessage,myKey,myMode):
    print(myKey)
    if not keyIsValid(myKey.upper()):
        sys.exit('There is an error in the key or symbol set.')
    if myMode == 'encrypt':
        translated = encryptMessage(myKey, myMessage)
    elif myMode == 'decrypt':
        translated = decryptMessage(myKey, myMessage)
    #print('Using key %s' % (myKey))
    #print('The %sed message is:' % (myMode))
    print(translated)


def keyIsValid(key):
    AlphabetList = list(Alphabet)
    AlphabetList.sort()
    return AlphabetList


def encryptMessage(key, message):
    return translateMessage(key, message, 'encrypt')


def decryptMessage(key, message):
    return translateMessage(key, message, 'decrypt')


def translateMessage(key, message, mode):
    translated = ''
    charsA = Alphabet
    charsB = key
    if mode == 'decrypt':
        # For decrypting, we can use the same code as encrypting. We
        # just need to swap where the key and Alphabet strings are used.
        charsA, charsB = charsB, charsA

    # Loop through each symbol in message:
    for symbol in message:
        if symbol.upper() in charsA:
            # Encrypt/decrypt the symbol:
            symIndex = charsA.find(symbol.upper())
            if symbol.isupper():
                translated += charsA[symIndex].upper()
            else:
                translated += charsA[symIndex].lower()
        else:
            # Symbol is not in Alphabet; just add it
            translated += symbol

    #return translated
    TestText2 = translated.encode('utf8')
    return TestText2


def getRandomKey():
    key = list(Alphabet)
    random.shuffle(key)
    return ''.join(key)


if __name__ == '__main__':
	
	plain_text = sys.argv[1]
	key = sys.argv[2]
	mode = 'encrypt'
	
	if (sys.argv[3] == '1'):
		mode = 'encrypt'
	elif (sys.argv[3] == '2'):
		mode = 'decrypt'
	
	print(mode)
	main(plain_text,key,mode)