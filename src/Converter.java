/**
 * Created by Mathias on 06.11.2015.
 */
public class Converter{

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

    public String intToBit(){
        return null;
    }

    public int hexToInt(String hs) {
        if(hs.length() > 6){
            throw new IllegalArgumentException("ERROR: Hex string too long.");
        } else {
            for(int i = 0; i < hs.length(); i++){
                if((hs.charAt(i) >= 48 && hs.charAt(i) <= 57)
                    || (hs.charAt(i) >= 65 && hs.charAt(i) <= 70)
                        || (hs.charAt(i) >= 97 && hs.charAt(i) <= 102)) {
                } else {
                    throw new IllegalArgumentException("ERROR: Hex string contains invalid characters.");
                }
            }
        }

        int result = 0;

        //result = bitString(hs);

        return result;
    }

    public String intToHex(){
        return null;
    }
}
