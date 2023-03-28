import sys

def frequency_analysis(text):
    frequency = {}
    for char in text:
        if char.isalpha():  # Check if the character is alphabetic (ignoring special characters and numbers)
            if char in frequency:
                frequency[char] += 1
            else:
                frequency[char] = 1
    return frequency

def main(source):
    frequency = frequency_analysis(source.upper())
    plain_text = "Letter\t\tFrequency" + "\r\n"
    for letter, count in frequency.items():
        plain_text = plain_text + "{}\t\t{}".format(letter, count) + "\r\n"

    TestText2 = plain_text.encode('utf8')
    sys.stdout.buffer.write(TestText2)

if __name__ == "__main__":
    text = sys.argv[1]
    main(text)
