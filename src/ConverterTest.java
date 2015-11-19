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
    public void hexToInt_GivenEmptyString_ReturnsZero(){
        assertEquals(converter.hexToInt(""), 0);
    }

    @Test
    public void hexToInt_Given3_Returns3(){
        assertEquals(converter.hexToInt("3"), 3);
    }

    @Test (expected = IllegalArgumentException.class)
    public void hexToInt_GivenTooLongString_ThrowsIllegalArgumaentException(){
        converter.hexToInt("0abcdef");
    }

    @Test (expected = IllegalArgumentException.class)
    public void hexToInt_GivenInvalidString_ThrowsIllegalArgumentException(){
        converter.hexToInt("o4qr9b");
    }

}