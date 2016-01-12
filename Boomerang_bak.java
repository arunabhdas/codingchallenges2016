import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class TextEditor 
{

	public static void main(String[] args) {

		File file = new File("example-input.txt");

		FileInputStream fis = null;

		try {
			fis = new FileInputStream(file);
			InputStreamReader isr =new InputStreamReader(fis);
            BufferedReader  bufferReader = new BufferedReader(isr);

			System.out.println("Total file size to read (in bytes) : "
					+ fis.available());

			String line;
            while ((line = bufferReader.readLine()) != null) {
                    for (String splitVal : line.split(" ")) {
						System.out.print("This is the character on line : " + splitVal + "\n");
    				}
            }

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fis != null)
					fis.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
}

