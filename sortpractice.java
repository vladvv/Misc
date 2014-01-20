import java.util.Arrays;

public class sortpractice{

	public static void mergeSort(int[] array)
	{
		int[] helper = new int[array.length];
		mergeSort(array,helper,0,helper.length-1);
	}

	private static void mergeSort(int[] array, int[] helper, int low, int high)
	{		
		if(low < high) {
			int middle = (low + high) /2;
			mergeSort(array, helper, low, middle);
			mergeSort(array, helper, middle+1, high);
			merge(array, helper, low, middle, high);
			
		}
	}

	public static void merge(int[] array, int[] helper, int low, int middle, int high)
	{
		System.arraycopy(array, low, helper, low, (high-low) + 1);
		
		int current = low;
		int leftCursor = low;
		int rightCursor = middle + 1;
	
		while(leftCursor <= middle && rightCursor <= high)
		{
			if(helper[leftCursor] < helper[rightCursor])
			{
				array[current] = helper[leftCursor];
				current++;
				leftCursor++;
			} else {
				array[current] = helper[rightCursor];
				current++;
				rightCursor++;
			}
		}
	
		while(leftCursor <= middle)
		{
			array[current] = helper[leftCursor];
			current++;
			leftCursor++;
		}
	}
	
	public static void partialPrint(int[] array, int low, int high)
	{	
		System.out.print("[");
		for(int i = low; i <= high; i++)
		{
			System.out.print(array[i] +" ");
		}
		
		System.out.println("]");
	}
	
	public static void quickSort(int[] array)
	{
		
		
		quickSort(array, 0, array.length - 1);
	
	}
	
	public static void quickSort(int[] array, int low, int high)
	{
		int middle = partition(array, low, high);
		
		if(low < middle - 1)
			quickSort(array, low, middle-1);
		if(middle < high)
			quickSort(array, middle, high);
	
	}
	
	private static int partition(int[] array, int low, int high)
	{
	
		System.out.println( Arrays.toString(array) + " partitioning " + low + " to " + high );
		
		int pivot = array[(high + low) / 2];
		
		while(low <= high)
		{
			while(array[low] < pivot)
				low++;
				
			while(array[high] > pivot)
				high--;
				
			if(low <= high)
			{
				swap(array, low, high);
				low++;
				high--;
			
			}		
		}
		
		System.out.println( Arrays.toString(array) + " left " + low );
		
		return low;
		
		
	
	}
	
	private static void swap(int[] array, int a, int b)
	{
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}

	public static void main(String[] args)
	{
		//int[] inOrder = {3, 2, 1, 4};
		//int[] reversed = {9, 8, 7, 6, 5, 4, 3, 2, 1};
		int[] random = {5, 4, 7, 1, 2, 9, 10, 7, 9};
	
		//System.out.println( Arrays.toString(inOrder) );
		//System.out.println( Arrays.toString(reversed) );
		System.out.println( Arrays.toString(random) );
		
		//mergeSort( inOrder );
		//mergeSort( reversed );
		quickSort( random );
		
		//System.out.println( Arrays.toString(inOrder) );
		//System.out.println( Arrays.toString(reversed) );
		System.out.println( Arrays.toString(random) );
		
		
		/*System.out.println( "-------------" );
		
		int[] testArray1 = {3, 2};
		int[] helper = new int[8];
		
		System.out.println( Arrays.toString(testArray1) );
		merge( testArray1, helper, 0, 1, 1);
		
		System.out.println( Arrays.toString(testArray1) );*/
		
		

	}
}
