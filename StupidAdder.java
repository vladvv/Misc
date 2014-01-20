public class StupidAdder {
	public static int add(int a, int b)
	{
		int carry = 0;		
		int mask = 1;		
		int result = 0;
		
		for(int i = 0; i < 32; i++)
		{ 
			int tempa = a & mask;
			int tempb = b & mask;
			int tempc = carry & mask;
			
			if( (tempa ^ tempb ^ tempc) != 0 )
				result |= mask;
			
			if( ( (tempa & tempb) | ( (tempa ^ tempb) & tempc) ) != 0)
				carry |= (mask<<1);
			mask<<= 1;
		}	
		return result;
	}
	
	public static void main(String[] args)
	{
		int temp = StupidAdder.add( 5, 7);
		System.out.println( temp );
	}	
	
	
}
