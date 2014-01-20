import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.Integer;
import java.lang.StringBuilder;
import java.util.*;

public class question1 {

	static char[][] testArray = new char[][]
	{
		{ 'a', 'b', 'c', 'd' },
		{ 'e', 'f', 'g', 'h' },
		{ 'i', 'j', 'k', 'l' },
		{ 'm', 'n', 'o', 'p' }
		
	};
	
	static int[][] intMatrix = new int[][]
	{
		{ 1, 1, 1, 1 },
		{ 1, 1, 0, 1 },
		{ 1, 1, 1, 1 },
		{ 1, 1, 1, 1 }
		
	};
		
	public static String reverseString(String inputString)
	{
		int length = inputString.length();
		char[] characters = inputString.toCharArray();
		for(int i = 0; i < length/2; i++)
		{
			char temp = characters[i];
			characters[i] = characters[length - 1 - i];
			characters[length - 1 - i] = temp;		
		}
		return new String(characters);
	}

	public static long fib(long n){
		return (n <= 1) ? n : fib(n-1) + fib(n-2);
	
	}
	
	public static void multTable(int dimension){
		for(int row = 1; row <= dimension; row++)
		{
			for(int col = 1; col <= dimension; col++)
			{
				System.out.print( String.format( "%4d", row * col) );
			}
			System.out.println("");
		}
	
	}

	public static long sumInts(String fileName)
	{
		long sum = 0;
		
		
		try{
		
			BufferedReader in = new BufferedReader(new FileReader(fileName) );
			String tempLine = in.readLine();
			
			while( tempLine != null ){
				sum += Integer.parseInt(tempLine);
				tempLine = in.readLine();
			}			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sum;
	}
	
	public static int largest ( int[] input ) {
		int largest = input[0];
		for(int i : input)
		{
			if (i > largest)
				largest = i;
		}
		return largest;
	}

	public static String formatRGB(int[] input){
		return Integer.toHexString(input[0])
			 + Integer.toHexString(input[1])
			  + Integer.toHexString(input[2]) ;
	
	}
	
	public static void sofast(){
		for(int i = 2; i < 100; i++)
			System.out.println( i + "fast" + (i + 2) + "u" );
	}

	public static void bittest(){
		int i = (1<<5);
		
		//String fs = ;
		System.out.println( String.format("Output: %h", i) );
	
	}

	public static boolean uniqueCharacters(String in) throws Exception
	{
		if(in == null)
			throw new Exception("Input is null");
			
		char characters[] = in.toCharArray();
		
		int count[] = new int[150];
		
		for(char c : characters ) {
			if(count[c] == 0)
				count[c]++;
			else
				return false;		
		}
	
		return true;
	}
	
	public static boolean uniqueCharacters2(String in) throws Exception
	{
		if(in == null)
			throw new Exception("Input is null");
		char characters[] = in.toCharArray();
		
		Arrays.sort(characters);
		
		for(int i = 0; i < characters.length - 1; i++)
		{
			if(characters[i] == characters[i+1])
				return false;
		
		}
		return true;
	}
	
	public static void replaceSpaces(char[] in, int length)
	{
		for(int i = 0; i < length; i++)
		{
			if(in[i]==' ')
			{
				for(int j = in.length - 1; j > (i + 2); j--)
				{
					in[j] = in[j-2];
				}
				in[i] = '%';
				in[i+1] = '2';
				in[i+2] = '0';
			}	
		}
	}
	
	
	public static String stringCompress(String input)
	{
		StringBuilder sb = new StringBuilder();
		
		char previous = 0; 
		int count = 0;
		
		for(int i = 0; i < input.length(); i++)
		{
			if (input.charAt(i) != previous)
			{
				if(count > 0)
					sb.append(count);
				sb.append( input.charAt(i) );
				count = 1;
			} else {
				count++;
			}
			previous = input.charAt(i);
		}
		sb.append(count);
		
		if(input.length() < sb.length())
			return input;
		else
			return sb.toString();	
	}
	
	public static char[][] rotate(char[][] array)
	{
		char[][] newArray = new char[array.length][array.length];
		
		for(int row = 0; row < array.length; row++)
		{
			for(int col = 0; col < array.length; col ++)
			{
				newArray[row][col] = array[array.length - 1 - col][row];
			
			}		
		}
		return newArray;
	}
	
	public static void prettyPrint(char[][] array)
	{
		for(int row = 0; row < array.length; row++)
		{
			for(int col = 0; col < array[row].length; col++)
			{
				System.out.print( array[row][col] + " ");
			}
			System.out.println("");
		}
	}
	
	public static void prettyPrintInt(int[][] array)
	{
		for(int row = 0; row < array.length; row++)
		{
			for(int col = 0; col < array[row].length; col++)
			{
				System.out.print( array[row][col] + " ");
			}
			System.out.println("");
		}
	}
	
	public static void rotateInPlace(char[][] array)
	{
		int last = array.length - 1;
		char temp;
		for(int row = 0; row < array.length/2; row++)
		{
			for(int col = 0; col < array[row].length/2; col++)
			{
				temp = array[row][col];
				array[row][col] = array[last-col][row];
				array[last-col][row] = array[last-row][last-col];
				array[last-row][last-col] = array[col][last-row];
				array[col][last-row] = temp;
			
			}		
		}	
	}
	
	public static void zeroRowCol(int[][] matrix)
	{
		int side = matrix.length;
		boolean zeroRow[] = new boolean[side];
		boolean zeroCol[] = new boolean[side];
		
		for(int row = 0; row < side; row++)
		{
			for(int col = 0; col < side; col++)
			{
				if(matrix[row][col] == 0)
				{
					zeroRow[row] = true;
					zeroCol[col] = true;
				}	
			}
		}
		
		for(int row = 0; row < side; row++)
		{
			for(int col = 0; col < side; col++)
			{
				if(zeroRow[row] | zeroCol[col])
				{
					matrix[row][col] = 0;
				}	
			}
		}
	}
	
	public static String rotate(String input, int i)
	{
		return input.substring(i) + input.substring(0,i);
	}
	
	public static void substringRotateProblem(String input)
	{
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < input.length(); i++)
		{
			sb.append( rotate(input, i) );
			sb.append('|');
		}
		
		System.out.println(sb.toString() );
	}
	
	
	static class Node {
		Node next;
		int data;
		
		public Node(int data) {
			this.data = data;
		}
		
		public String toString() {
			StringBuilder sb = new StringBuilder();
			Node temp = this;
			
			while(temp != null)
			{
				sb.append("[" + temp.data + "] ");
				temp = temp.next;			
			} 
			
			return sb.toString();
		}
		
		public int getData(){
			return data;
		}
		
		Node appendToTail(int d){
			Node end = new Node(d);
			Node temp = this;
			
			while(temp.next != null)
			{
				temp = temp.next;
			}
			temp.next = end;
			
			return end;
		
		}
		
		Node deleteNode(int d){
			if(data == d)
			{
				return next;
			}
			
			Node temp = this;		
			while(temp.next != null)
			{
				if(temp.next.data == d)
				{
					temp.next = temp.next.next;
					return this;
				}
				temp = temp.next;
			}
			
			return this;
		}
		
		void removeDuplicates(){

			Hashtable table = new Hashtable();
			
			Node temp = this;
			Node prev = this;
			while(temp != null)
			{
				if(table.containsKey( temp.data ) )
				{
					//since node with this data exists, delete it
					prev.next = temp.next;
					
				} else {
					table.put(temp.data, true);	
					prev = temp;		
									
				}
				temp = temp.next;	
							
			}
		}
		
		int ntolast(int index) throws Exception{
			Node ahead = this;
			Node behind = this;
			while(index > 0)
			{
				if(ahead == null)
					throw new Exception("list is too short");
				ahead = ahead.next;
				index--;
			}
			while(ahead.next != null)
			{
				ahead = ahead.next;
				behind = behind.next;
			}		
			
			return behind.data;
		}
		
		Node partitionByX(int x)
		{
			Node tempLess = new Node(0);
			Node tempMore = new Node(0);
		
			Node endOfLess = null;
		
			Node temp = this;
			while(temp != null)
			{
				if(temp.data < x)
				{
					endOfLess = tempLess.appendToTail(temp.data);
				} else {
					tempMore.appendToTail(temp.data);
				}
			
			
				temp = temp.next;
			}
		
			endOfLess.next = tempMore.next;
			return tempLess.next;
		
		}
		
		static Node addList(Node first, Node second)
		{
			int carry = 0;
			Node result = new Node(0);
			while(first != null)
			{
				int sum = first.data + second.data + carry;
				carry = sum / 10;
				sum = sum % 10;
				result.appendToTail(sum);
				first = first.next;
				second = second.next;
			}
			if(carry > 0)
				result.appendToTail(carry);
				
			return result.next;
		}
	
	}
	
	
	
	
	public static void main(String[] args) throws Exception{
		Node first = new Node(7);
		first.appendToTail( 1 );
		first.appendToTail( 6 );
		
		
		Node second = new Node(7);
		second.appendToTail( 9 );
		second.appendToTail( 6 );
		

		

		System.out.println( first.toString() );
		System.out.println( second.toString() );
		
		Node result = Node.addList(first, second);
		
		System.out.println( result );
		
		
	}
}
