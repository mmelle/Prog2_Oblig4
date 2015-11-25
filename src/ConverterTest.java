import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ConverterTest {
Converter converter;

    @Before
    public void setUp(){
    converter = new Converter();
    }

    @Test
    public void bitToInt_GivenEmptyString_ReturnsZero(){
        assertEquals(converter.bitToInt(""), 0);
    }

    @Test
    public void bitToInt_GivenString11_ReturnsThree(){
        assertEquals(converter.bitToInt("11"), Integer.parseInt("11", 2));
    }

    @Test
    public void bitToInt_GivenString110101_Returns53(){
        assertEquals(converter.bitToInt("110101"), Integer.parseInt("110101", 2));
    }

    @Test
    public void bitToInt_GivenFullString_ReturnsParseIntValue(){
        assertEquals(converter.bitToInt("110100110111000101101100"),
                Integer.parseInt("110100110111000101101100", 2));
    }

    @Test (expected = IllegalArgumentException.class)
    public void bitToInt_GivenTooLongString_ThrowsIllegalArgumentException(){
        converter.bitToInt("0000110110100110100111100");
    }

    @Test (expected = IllegalArgumentException.class)
    public void bitToInt_GivenStringWithInvalidChars_ThrowsIllegalArgumentException(){
        converter.bitToInt("01ab011002");
    }

    @Test
    public void intToBit_GivenZero_ReturnsZero(){
        assertEquals(converter.intToBit(0), "0");
    }

    @Test
    public void intToBit_GivenOne_ReturnsOne(){
        assertEquals(converter.intToBit(1), "1");
    }

    @Test
    public void intToBit_GivenTwo_ReturnsOneZero(){
        assertEquals(converter.intToBit(2), "10");
    }

    @Test
    public void intToBit_GivenSixFortyFour_ReturnBinaryValue(){
        assertEquals(converter.intToBit(644), "1010000100");
    }

    @Test
    public void hexToInt_GivenEmptyString_ReturnsZero(){
        assertEquals(converter.hexToInt(""), 0);
    }

    @Test
    public void hexToInt_GivenThree_ReturnsThree(){
        assertEquals(converter.hexToInt("3"), 3);
    }

    @Test
    public void hexToInt_GivenC_ReturnsTwelve(){
        assertEquals(converter.hexToInt("C"), 12);
    }

    @Test
    public void hexToInt_GivenFiveA_ReturnsNinety(){
        assertEquals(converter.hexToInt("5a"), 90);
    }

    @Test
    public void hexToInt_GivenFullString_ReturnsIntValue(){
        assertEquals(converter.hexToInt("c0FfeE"), 12648430);
    }

    @Test (expected = IllegalArgumentException.class)
    public void hexToInt_GivenTooLongString_ThrowsIllegalArgumaentException(){
        converter.hexToInt("0abcdef");
    }

    @Test (expected = IllegalArgumentException.class)
    public void hexToInt_GivenInvalidString_ThrowsIllegalArgumentException(){
        converter.hexToInt("o4qr9b");
    }

    @Test
    public void intToHex_GivenZero_ReturnsZero(){
        assertEquals(converter.intToHex(0), "0");
    }

    @Test
    public void intToHex_GivenFour_ReturnsFour(){
        assertEquals(converter.intToHex(4), "4");
    }

    @Test
    public void intToHex_GivenTen_ReturnsA(){
        assertEquals(converter.intToHex(10), "A");
    }

    @Test
    public void intToHex_GivenNinety_ReturnsFiveA(){
        assertEquals(converter.intToHex(90), "5A");
    }

    @Test
    public void intToHex_GivenHighestInt_ReturnsFullF(){
        assertEquals(converter.intToHex(16777215), "FFFFFF");
    }
}