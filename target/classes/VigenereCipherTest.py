def vigenere_encrypt(text, key):
    alphabet = "AÁÄBCČDĎDZDŽEÉFGHCHIÍJKLĹMNŇOÓÔPQRŔSŠTŤUÚVWXYÝZŽ"
    key = key.upper()
    encrypted_text = ""

    key_index = 0

    for symbol in text:
        letter_index = alphabet.find(symbol.upper())

        if letter_index != -1:
            if symbol.isupper():
                encrypted_text += alphabet[(letter_index + alphabet.find(key[key_index])) % len(alphabet)]
            elif symbol.islower():
                encrypted_text += alphabet[(letter_index + alphabet.find(key[key_index])) % len(alphabet)].lower()

            key_index += 1
            if key_index == len(key):
                key_index = 0
        else:
            encrypted_text += symbol

    return encrypted_text


def vigenere_decrypt(text, key):
    alphabet = "AÁÄBCČDĎDZDŽEÉFGHCHIÍJKLĹMNŇOÓÔPQRŔSŠTŤUÚVWXYÝZŽ"
    key = key.upper()
    decrypted_text = ""

    key_index = 0

    for symbol in text:
        letter_index = alphabet.find(symbol.upper())

        if letter_index != -1:
            if symbol.isupper():
                decrypted_text += alphabet[(letter_index - alphabet.find(key[key_index])) % len(alphabet)]
            elif symbol.islower():
                decrypted_text += alphabet[(letter_index - alphabet.find(key[key_index])) % len(alphabet)].lower()

            key_index += 1
            if key_index == len(key):
                key_index = 0
        else:
            decrypted_text += symbol

    return decrypted_text

# Example usage
text = "Dobrý deň, ako sa máš?"
key = "tajnýkľúč"

encrypted_text = vigenere_encrypt(text, key)
print("Encrypted text:", encrypted_text)

decrypted_text = vigenere_decrypt(encrypted_text, key)
print("Decrypted text:", decrypted_text)
