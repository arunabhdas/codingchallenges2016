import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Boomerang
{
	private static int mNumberOfNights;
	private	static int numBoxesInCurrentAppearance;
	private static int mNumberOfDistinctStarsInCurrentIteration = 1;
	private static int mPointer = 1; 
	private static int mCounter = 0;
   	private static ArrayList<Star> mStarsOnCurrentNight; 

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
            			mStarsOnCurrentNight = new ArrayList<Star>();
            			System.out.println("Stars coordinates in the next " + mNumberOfDistinctStarsInCurrentIteration + " lines");

            			mPointer = mPointer + 1 + mNumberOfDistinctStarsInCurrentIteration;
            		} else {
        				if (mNumberOfDistinctStarsInCurrentIteration == mCounter) {
        					String arr[] = line.split(" ", 2);
            				int xpos = Integer.parseInt(arr[0]);
            				int ypos = Integer.parseInt(arr[1]);
            				Star s = new Star(xpos, ypos);
            				mStarsOnCurrentNight.add(s);
            				s.toS();
            				mCounter++;

        				}

        				for (Star star : mStarsOnCurrentNight) {
        					star.toS();
        				}	

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

