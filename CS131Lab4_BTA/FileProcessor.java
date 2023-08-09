import java.io.*;
import java.util.*;
import java.util.ArrayList;
public class FileProcessor {

	private String fileName;
	private int stringLength;
	private ArrayList<String> stringList = new ArrayList<String>(stringLength);
	private Scanner input = new Scanner(System.in);
	FileReader fr;
	BufferedReader reader;
	
	public FileProcessor(String fileName, int stringLength) 
	{
		this.fileName = fileName;
		this.stringLength = stringLength;			
	}//end empty-argument constructor
	
	public int getArrayListSize() 
	{
		return stringList.size();
	}//end getArrayListSize
	
	public void processFile()
	{
		FileReader fr;
		BufferedReader reader;
		try
		{		
			fr = new FileReader(fileName);
			String line;
			reader = new BufferedReader(fr);
			
			while((line = reader.readLine()) != null)
			{
				if(line.length() > stringLength)
				{
					throw new StringTooLongException();
				}//end if
				else System.out.println(line);		
			}//end while
			reader.close();
		}//end try
		catch(IOException e) 
			{
			System.out.println(e.getMessage());
			processFile();
			}//end catch
		catch(StringTooLongException e)
			{
			System.out.println(e.getMessage());
			}//end catch
		}//end processFile

	public String getFileName() 
	{
		return fileName;
	}//end getFileName

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}//end setFileName

	public int getStringLength() 
	{
		if(stringLength<5)
			stringLength=5;
		return stringLength;
	}//end getStringLength

	public void setStringLength(int stringLength) {
		this.stringLength = stringLength;
	}//end setStringLength
}//end class
