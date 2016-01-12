import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class HighSecurity 
{
	private static int mNumberOfFacilities;
	private	static int numBoxesInCurrentAppearance;
	private static int mNumberOfColumns;
	private static int mNumberOfSequencesInCurrentAppearance;
	private static boolean mSecured = false;
    

	public enum CellState {
		EMPTY, OCCUPIED, GUARDPRESENT, SECURED
	}

	public static void main(String[] args) {

		File file = new File("example-input-highsecurity.txt");

		FileInputStream fis = null;

		int lineNumber = -1;

		int facilityNumber = -1;

			

		try {
			fis = new FileInputStream(file);
			InputStreamReader isr =new InputStreamReader(fis);
            BufferedReader  bufferReader = new BufferedReader(isr);

			String line;
            String firstRow = null;
            String secondRow = null;
			String firstRowSecured = null;
			String secondRowSecured = null;
            while ((line = bufferReader.readLine()) != null) {



            	if (lineNumber == -1) {
            		mNumberOfFacilities = Integer.parseInt(line);


            	} else {
            		boolean readInputForThisFacility = false;

					if ( (lineNumber %  3) == 0 ) {

						facilityNumber++;

						mNumberOfColumns = Integer.parseInt(line);


					} else {


						if (((lineNumber - 1) % 3) == 0) {
							firstRow = line;
							firstRowSecured = line;

						}

						if (((lineNumber - 2) % 3) == 0) {
							secondRow = line;
							secondRowSecured = line;
							if ((firstRowSecured != null) && (secondRowSecured != null)) {
								System.out.println("");
            					int humanReadableFacilityNumber = facilityNumber + 1;	
								System.out.println("Case #" + humanReadableFacilityNumber + ": " + " ------------------------------ " );
								System.out.println("firstRowSecured: " + firstRowSecured);
								System.out.println("secondRowSecured: "  + secondRowSecured);

								int i = 0;
								while (i< mNumberOfColumns-1) {
									if ((firstRowSecured.charAt(i) == '.')  && (secondRowSecured.charAt(i+1) == 'X')) {
									 	firstRowSecured = firstRowSecured.substring(0, i) + 'G' + firstRowSecured.substring(i+1);
										System.out.println("");
									 	System.out.println("> " + firstRowSecured + " <");
										System.out.println("> " + secondRowSecured + " <");

									} 

									if ((firstRowSecured.charAt(i) == 'X')  && (secondRowSecured.charAt(i+1) == '.')){
										secondRowSecured = secondRowSecured.substring(0, i) + 'G' + secondRowSecured.substring(i+1);	
									}
									i++;
								}

							}

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

