/**
 * Created by Mathias on 06.11.2015.
 */
public class Converter{
    char[] charTable = {'0', '1', '2', '3', '4', '5', '6', '7', '8',
                        '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public int bitToInt(String bs) {
        if(bs.length() > 24){
            throw new IllegalArgumentException("ERROR: Bit string too long.");
        } else {
            for(int i = 0; i < bs.length(); i++){
                if(bs.charAt(i) != '0' && bs.charAt(i) != '1'){
                    throw new IllegalArgumentException("ERROR: Bit string contains invalid characters.");
                }
            }
        }

        int result = 0;

        for(int j = bs.length() - 1 ; j >= 0; j--){
            if(bs.charAt(j) == '1'){
                result += Math.pow(2, (bs.length() - j - 1));
            }
        }
        return result;
    }

    public String intToBit(int i){
        StringBuilder result = new StringBuilder();

        if (i == 0){
            result.append(0);
        } else {
            while (i > 0) {
                int bitValue = i % 2;
                int nextNumber = i / 2;
                result.insert(0, bitValue);
                i = nextNumber;
            }
        }
        return result.toString();
    }

    public int hexToInt(String hs) {
        int result = 0;
        hs = hs.toUpperCase();
        if(hs.length() > 6){
            throw new IllegalArgumentException("ERROR: Hex string too long.");
        } else if (hs.length() == 0) {
            return 0;
        } else {
            for(int i = 0; i < hs.length(); i++){
                if((hs.charAt(i) >= 48 && hs.charAt(i) <= 57)
                    || (hs.charAt(i) >= 65 && hs.charAt(i) <= 70)) {
                } else {
                    throw new IllegalArgumentException("ERROR: Hex string contains invalid characters.");
                }
            }
        }

        int[] separateNumbers = new int[hs.length()];

        for(int i = 0; i < hs.length(); i++){
            if ((hs.charAt(i) >= 65 && hs.charAt(i) <= 70)){
                separateNumbers[i] = (int) hs.charAt(i) - 55;
            } else {
                separateNumbers[i] = (int) hs.charAt(i) - 48;
            }
            result = (16 * result) + separateNumbers[i];
        }

        return result;
    }

    public String intToHex(int i){
        int number = -1;
        int hexlength = 0;
        StringBuilder result = new StringBuilder();

        while (number < i){
            number = (int) Math.pow(16, hexlength+1);
            hexlength++;
        }

        for(int j = hexlength; j > 0; j--){
            int remainder = i % 16;
            result.insert(0, charTable[remainder]);
            i = i/16;
        }

        return result.toString();
    }
}
