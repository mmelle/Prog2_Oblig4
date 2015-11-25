import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class ReadFromFileTest {

    @Mock
    File file;

    @Mock
    BufferedReader reader;

    @Test (expected = Exception.class)
    public void readFile_NoArg_ThrowsException() throws Exception {
        String[] args = new String[0];
        ReadFromFile.main(args);
    }

    @Test (expected = Exception.class)
    public void fileReader_InvalidArg_ThrowsException() throws Exception {
        String[] args = {"nonExistentFile"};
        ReadFromFile.main(args);
    }

    @Test
    public void fileReader_ReadsFile_Succeeds() throws Exception {

        reader = new BufferedReader(new FileReader(file));
        when(reader.readLine()).thenReturn("ok");
        System.out.println(file.getName());
        String[] args = {file.getName()};
        ReadFromFile.main(args);

    }


}