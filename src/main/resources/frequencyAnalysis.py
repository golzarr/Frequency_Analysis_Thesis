class AndrejThesis() :
    @staticmethod  
    def main() :
        # 		 * Tries all 25 possible shifts to produce a list of likely inputs to a
        # 		 * caesar-cipher encoded message. Displays the decryption possibility only when
        # 		 * the frequency of any vowel is above 5%.
        source = "Pm ol ohk hufaopun jvumpkluaphs av zhf, ol dyval pa pu jpwoly, aoha pz, if zv johunpun aol vykly vm aol slaalyz vm aol hswohila, aoha uva h dvyk jvbsk il thkl vba.".upper()
        # Checking if the user wants to exit
      
        print("Bye.")
            
        sourceText = [' '] * (len(source))
        unicode = [0] * (len(source))
        unicodeCopy = [0] * (len(source))
        # Moves source text into array
        count = 0
        while (count < len(source)) :
            sourceText[count] = source[count]
            count += 1
        hex = None
        dec = 0
        # Go through sourceText and translate each letter into unicode value.
        count = 0
        while (count < len(sourceText)) :
            # Convert to hex and then to decimal representation of char
            hex = str(hex(sourceText[count]))
            dec = Integer.parseInt(hex,16)
            unicode[count] = dec
            unicodeCopy[count] = dec
            count += 1
        shift = 1
        while (shift <= 25) :
            BulkUpload.AndrejThesis.smartShift(shift, unicode, unicodeCopy)
            shift += 1
    @staticmethod
    def smartShift( shift,  unicode,  unicodeCopy) :
        # Preserve values
        x = 0
        while (x <= len(unicode) - 1) :
            unicodeCopy[x] = unicode[x]
            # Shift and recovery
            if (unicode[x] >= 65 and unicode[x] <= 90) :
                unicodeCopy[x] += shift
                if (unicodeCopy[x] > 90) :
                    unicodeCopy[x] -= 26
            x += 1
        processed = [None] * (len(unicode))
        finalProcess = [' '] * (len(unicode))
        # Converts dec to hex string
        count = 0
        while (count < len(processed)) :
            processed[count] = str(hex(unicodeCopy[count]))
            # Convert the hex string into char:
            hexToInt = Integer.parseInt(processed[count],16)
            intToChar = chr(hexToInt)
            finalProcess[count] = intToChar
            count += 1
        # Basic frequency calculations
        total = 0
        aTotal = 0
        eTotal = 0
        iTotal = 0
        oTotal = 0
        uTotal = 0
        # Analyze array to count frequency of vowels
        for c in finalProcess :
            total += 1
            if (c=='A'):
                aTotal += 1
            elif(c=='E'):
                eTotal += 1
            elif(c=='I'):
                iTotal += 1
            elif(c=='O'):
                oTotal += 1
            elif(c=='U'):
                uTotal += 1
          
        # Frequency calculations
        finalCrypto = ""
        for c in finalProcess :
            finalCrypto += c
        if (eTotal / total >= 0.05 or aTotal / total >= 0.05 or iTotal / total >= 0.05 or oTotal / total >= 0.05 or uTotal / total >= 0.05) :
            print()
            print("\t" + finalCrypto)
            print("\t\tA Pct: " + str(aTotal / total))
            print("\t\tE Pct: " + str(eTotal / total))
            print("\t\tI Pct: " + str(iTotal / total))
            print("\t\tO Pct: " + str(oTotal / total))
            print("\t\tU Pct: " + str(uTotal / total))
        else :
            print()
            print("NOT Potential: " + finalCrypto)
    

if __name__=="__main__":
    print("File one executed when ran directly")
    AndrejThesis.main()
    print("File one executed when ran directly 2") 