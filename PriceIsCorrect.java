import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class PriceIsCorrect 
{
	private static int mNumberOfAppearances;
	private	static int numBoxesInCurrentAppearance;
	private static int maxSumInCurrentAppearance;
	private static int mNumberOfSequencesInCurrentAppearance;

	public static void main(String[] args) {

		// File file = new File("example-input-priceiscorrect.txt");
		File file = new File("the_price_is_correct.txt");

		FileInputStream fis = null;

		int lineNumber = 0;

		int showAppearanceNumber = 0;

		

		try {
			fis = new FileInputStream(file);
			InputStreamReader isr =new InputStreamReader(fis);
            BufferedReader  bufferReader = new BufferedReader(isr);

			String line;

            while ((line = bufferReader.readLine()) != null) {

            	if (lineNumber == 0) {
            		mNumberOfAppearances = Integer.parseInt(line);


            	} else {
					if (!( (lineNumber & 1) == 0 )) {

						showAppearanceNumber++;
						String arr[] = line.split(" ", 2);
						// System.out.println("This is your " + showAppearanceNumber + " appearance on the show");
						numBoxesInCurrentAppearance = Integer.parseInt(arr[0]);
						// System.out.println("There are " + arr[0] + " boxes in front of you");

						maxSumInCurrentAppearance = Integer.parseInt(arr[1]);
						// System.out.println("The sum of all boxes must not exceed " + arr[1]);


					} else {
						mNumberOfSequencesInCurrentAppearance = 0;
						// System.out.println("The following boxes are in front of you " + line + "\n");
						String boxContentArr[] = line.split(" ", numBoxesInCurrentAppearance);
						for (String boxContent: boxContentArr) {
							// System.out.println(" Box |" + boxContent + "| ");

						}
						for (int a=0; a<boxContentArr.length; a++) {
						long sumOfSequenceBoxContents = 0;
							sumOfSequenceBoxContents += Long.parseLong(boxContentArr[a]);
							if (sumOfSequenceBoxContents <=maxSumInCurrentAppearance) {
								mNumberOfSequencesInCurrentAppearance++;
							}
							for (int b=a+1; b<boxContentArr.length; b++) {
								sumOfSequenceBoxContents += Long.parseLong(boxContentArr[b]);
								// System.out.println("sumOfSequenceBoxContents " + sumOfSequenceBoxContents);
								if (sumOfSequenceBoxContents <= maxSumInCurrentAppearance) {
									mNumberOfSequencesInCurrentAppearance++;
								}	
							}
						}

						System.out.println("Case #" + showAppearanceNumber + ": " + mNumberOfSequencesInCurrentAppearance);

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

