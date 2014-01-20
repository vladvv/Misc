import java.io.*;

public class dictionaryStuff{
	static final String fileName = "/usr/share/dict/words";
	
	
	public static boolean isOrdered(String string)
	{
		
		char[] chars = string.toUpperCase().toCharArray();
		for(int i = 0; i < chars.length - 1; i++)
		{
			if( chars[i] > chars[i+1])
				return false;
		}
		return true;
	}
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader in = new BufferedReader( new FileReader(fileName) );
		
		String temp = "";
		while( (temp = in.readLine()) != null)
		{
			String word = temp.trim();
			
			if( isOrdered(word) && word.length() == 6 )
				System.out.println(temp);
		}	
	}

}
