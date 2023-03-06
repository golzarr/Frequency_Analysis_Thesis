import sys
import os

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
        
    TestText2 = plain_text.encode('utf8')
    #print(plain_text)
    sys.stdout.buffer.write(TestText2)

if __name__ == "__main__":
	text_file = open(sys.argv[1], "r", encoding='utf-8')
	#read whole file to a string
	data = text_file.read()
	#close file
	text_file.close()
	
	text = data
	main(text)