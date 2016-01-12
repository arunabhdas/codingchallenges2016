import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class Boomerang
{
	private static int mNumberOfNights;
	private	static int numBoxesInCurrentAppearance;
	private static int mNumberOfDistinctStarsInCurrentIteration = 1;
	private static int mPointer = 1; 
	private static int mContent = 1;
    

	public static void main(String[] args) {

		File file = new File("boomerang_constellations_example_input.txt");

		FileInputStream fis = null;

		int lineNumber = 0;

		try {
			fis = new FileInputStream(file);
			InputStreamReader isr =new InputStreamReader(fis);
            BufferedReader  bufferReader = new BufferedReader(isr);
			String line;
            while ((line = bufferReader.readLine()) != null) {

            	if (lineNumber == 0) {
            		mNumberOfNights = Integer.parseInt(line);

            	} else {

            		if (lineNumber == 1) {
            			mNumberOfDistinctStarsInCurrentIteration = Integer.parseInt(line);
            		} 

            		System.out.println("lineNumber : " + lineNumber + " mPointer : " + mPointer + " : " + mNumberOfDistinctStarsInCurrentIteration);
            		if (lineNumber == (mPointer)) {
            			mNumberOfDistinctStarsInCurrentIteration = Integer.parseInt(line);
            			System.out.println("Stars coordinates in the next " + mNumberOfDistinctStarsInCurrentIteration + " lines");
            			mPointer = mPointer + 1 + mNumberOfDistinctStarsInCurrentIteration;
            		} else {
            				
            		}

            	}

	           	lineNumber++;


            }

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				System.out.println("\n");
				if (fis != null)
					fis.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
}

