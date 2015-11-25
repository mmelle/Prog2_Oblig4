import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by Mathias on 06.11.2015.
 */
public class ReadFromFile {

    public static void main(String[] args) throws Exception {
        if(args.length != 1){
            throw new Exception("Usage: java FileReader targetFile");
        }

        File targetFile = new File(args[0]);
        File dataCollection = new File("mdCollection.txt");
        File log = new File("mdLog.txt");

        if(!targetFile.exists()){
            throw new Exception("ERROR: Target file does not exist.");
        }

        if(!dataCollection.exists()){
            dataCollection.createNewFile();
        }

        if(!log.exists()){
            log.createNewFile();
        }

        Converter converter = new Converter();
        Scanner input = new Scanner(targetFile);
        FileWriter output = new FileWriter("mdCollection.txt", true);
        FileWriter logOut = new FileWriter("mdLog.txt", true);


        while (input.hasNext()){
            String id = input.next();
            int bitOp = input.nextInt();
            String bitString1 = input.next();
            String bitString2 = input.next();
            int bitInt1 = converter.bitToInt(bitString1);
            int bitInt2 = converter.bitToInt(bitString2);
            int finalInt;

            Scanner logIn = new Scanner(dataCollection);

            while (logIn.hasNext()){
                String idToCheck = logIn.next();
                if(id.equals(idToCheck)){
                    logOut.write(id + " " + bitString1 + " " + bitInt1 + " " +
                            bitString2 + " " + bitInt2 + "\n");
                    logOut.close();
                    throw new Exception("ERROR: Duplicate ID (Written to log");
                }
                logIn.nextLine();
            }

            switch (bitOp){
                case 1: finalInt = bitInt1 & bitInt2;
                        break;
                case 2: finalInt = bitInt1 | bitInt2;
                        break;
                default: logOut.write(id + " " + bitString1 + " " + bitInt1 + " " +
                         bitString2 + " " + bitInt2 + "\n");
                         logOut.close();
                    throw new Exception("ERROR: Invalid bit operator (Written to log");
            }

            String finalBit = converter.intToBit(finalInt);

            output.write(id + " " + bitString1 + " " + bitInt1 + " " +
                              bitString2 + " " + bitInt2 + " " + finalBit +
                            " " + finalInt + "\n");

        }
        output.close();

    }
}
