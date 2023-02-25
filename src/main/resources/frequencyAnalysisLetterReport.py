def frequency_analysis(text):
    frequency = {}
    for char in text:
        if char in frequency:
            frequency[char] += 1
        else:
            frequency[char] = 1
    return frequency

def main():
    source = "Pm ol ohk hufaopun jvumpkluaphs av zhf, ol dyval pa pu jpwoly, aoha pz, if zv johunpun aol vykly vm aol slaalyz vm aol hswohila, aoha uva h dvyk jvbsk il thkl vba.".upper()
    frequency = frequency_analysis(source)
    print("Letter\t\tFrequency")
    for letter, count in frequency.items():
        print("{}\t\t{}".format(letter, count))

if __name__ == "__main__":
    main()