import sys

def frequency_analysis(text):
    frequency = {}
    for char in text:
        if char in frequency:
            frequency[char] += 1
        else:
            frequency[char] = 1
    return frequency

def main(source):
    #source = "Pm ol ohk hufaopun jvumpkluaphs av zhf, ol dyval pa pu jpwoly, aoha pz, if zv johunpun aol vykly vm aol slaalyz vm aol hswohila, aoha uva h dvyk jvbsk il thkl vba.".upper()
    frequency = frequency_analysis(source.upper())
    plain_text = "Letter\t\tFrequency"+ "\r\n"
    for letter, count in frequency.items():
        plain_text = plain_text + "{}\t\t{}".format(letter, count) + "\r\n"
        
    print(plain_text)

if __name__ == "__main__":
    text = sys.argv[1]
    main(text)