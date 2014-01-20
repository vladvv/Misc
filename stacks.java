import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.Integer;
import java.lang.StringBuilder;
import java.util.*;

public class stacks {	

	public static class MyStack<T>
	{			
	
		static class Node<T> {
			Node<T> next;
			T data;
			public Node(T data)
			{
				this.data = data;
			}
		}
		int count;
		Node<T> top;
		
		
		
		public MyStack()
		{
			top = null;
			count = 0;
		}
		T pop()
		{
			if(top != null) {
				T item = top.data;
				top = top.next;
				count--;
				return item;
			}
			return null;
		}
		
		void push(T item){
			Node<T> t = new Node<T>(item);
			t.next = top;
			top = t;
			count++;
		}
		
		Object peek()
		{
			return top.data;
		}
		
		public int getCount()
		{
			return count;
		}
		
		public String toString(){
			Node<T> temp = top;
			StringBuilder sb = new StringBuilder();
			while(temp != null)
			{
				sb.append(temp.data + " ");
				temp = temp.next;
			}
			return sb.toString();
		
		}
		
	}
	
	
	static class SetOfStacks<T>
	{
		static final int CAP = 3;
		ArrayList<MyStack<T>> stacks;
		int current;
		public SetOfStacks()
		{
			stacks = new ArrayList<MyStack<T>>();
			stacks.add( new MyStack<T>() );
			current = 0;
		}
		
		public void push(T item)
		{
			if(stacks.get(current).getCount() >= CAP)
			{
				current++;
				stacks.add(new MyStack<T>());
			}
			stacks.get(current).push(item);
		}
		
		public T pop()
		{
			T t = stacks.get(current).pop();
			if(stacks.get(current).count == 0 && current > 0)
			{			
				stacks.remove(current);
				current--;
			}
			return t;
		}
		
		
		public String toString(){
			StringBuilder sb = new StringBuilder();
			for(MyStack<T> stack : stacks)
			{
				sb.append( "[" + stack + "]" );
			}
			return sb.toString();
		}
	}

	
	
	public static void main(String[] args)
	{
		SetOfStacks<Integer> testStack = new SetOfStacks<Integer>();
		
		testStack.push(5);
		testStack.push(5);
		testStack.push(5);
		testStack.push(5);
		testStack.push(5);
		testStack.push(6);
		testStack.push(6);
		testStack.push(6);
		testStack.push(6);
		testStack.push(6);
		
		System.out.println( testStack );
		
		testStack.pop();
		testStack.pop();
		testStack.pop();
		testStack.pop();
		testStack.pop();
		testStack.pop();
				
				System.out.println( testStack );
	}
}
