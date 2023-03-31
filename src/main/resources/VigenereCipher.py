import sys, random

LETTERS = ''


def main(text, key, mode, pLetters):
    LETTERS = pLetters
    myMessage = text
    myKey = key.upper()
    myMode = mode

    if myMode == 'encrypt':
        translated = encryptMessage(myKey, myMessage)
    elif myMode == 'decrypt':
        translated = decryptMessage(myKey, myMessage)

    TestText2 = translated.encode('utf8')
    sys.stdout.buffer.write(TestText2)


def encryptMessage(key, message):
    return translateMessage(key, message, 'encrypt')


def decryptMessage(key, message):
    return translateMessage(key, message, 'decrypt')


def translateMessage(key, message, mode):
    translated = []
    keyIndex = 0
    key = key.upper()

    for symbol in message:
        num = LETTERS.find(symbol.upper())
        if num != -1:
            if mode == 'encrypt':
                num += LETTERS.find(key[keyIndex])
            elif mode == 'decrypt':
                num -= LETTERS.find(key[keyIndex])

            num %= len(LETTERS)

            if symbol.isupper():
                translated.append(LETTERS[num])
            elif symbol.islower():
                translated.append(LETTERS[num].lower())
            keyIndex += 1
            if keyIndex == len(key):
                keyIndex = 0
        else:
            translated.append(symbol)

    return ''.join(translated)


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
          LETTERS = 'ABCDDDZEFGHCHIJKLMNOPQRSTUVWXYZ'
      #   LETTERS = 'AÁÄBCČDĎDZDŽEÉFGHCHIÍJKLĹĽMNŇOÓÔPQRŔSŠTŤUÚVWXYÝZŽ'
    elif (sys.argv[4] == '2'):
        LETTERS = 'ABCDEFGHIJKLMNÑOPQRSTUVWXYZ'

    main(text, key, mode, LETTERS)
