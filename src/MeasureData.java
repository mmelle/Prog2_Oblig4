import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * Created by Mathias on 25.11.2015.
 */
public class MeasureData {
    private int id;
    private String bitString;
    private int bitInt;
    private File targetFile;


    public MeasureData(int id, String bitString, int bitInt, File targetFile) throws FileNotFoundException {
        this.id = id;
        this.bitString = bitString;
        this.bitInt = bitInt;
        PrintWriter output = new PrintWriter(targetFile);
        output.println();
    }
}
