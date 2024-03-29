# With the alphabet we convert letters into numerical values
# To be able to use mathematical operations (NO encrypting the spaces or characters)
ALPHABET = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ'
KEY = 3


def caesar_encrypt(plain_text):
    # the encrypted message
    cipher_text = ''
    # we make the algorithm case insensitive
    plain_text = plain_text.upper()

    # consider all the letters in the plain_text
    for c in plain_text:
        # find the numerical representation (index) associated with
        # that character in the alphabet

        index = ALPHABET.find(c)
        # print("index 2:" + c)
        # print("index 3:",  index)
        if (index == -1):
            # print("index :"+c)
            cipher_text = cipher_text + c
        else:
            # caesar encryption is just a simple shift of characters according
            # to the key use modular arithmetic to transform the values within
            # the range [0,num_of_letters_in_alphabet]
            index = (index + KEY) % len(ALPHABET)
            # keep appending the encrypted character to the cipher_text
            cipher_text = cipher_text + ALPHABET[index]

    return cipher_text


def caesar_decrypt(cipher_text):

    plain_text = ''

    for c in cipher_text:
        index = ALPHABET.find(c)
        if(index==-1):
           plain_text = plain_text + c
        else:
            index = (index - KEY) % len(ALPHABET)
            plain_text = plain_text + ALPHABET[index]

    return plain_text


if __name__ == '__main__':

    m = 'Welcome to the Andrej Frequency Analysis Project'
    encrypted = caesar_encrypt(m)
    print(encrypted)
    print(caesar_decrypt(encrypted))

