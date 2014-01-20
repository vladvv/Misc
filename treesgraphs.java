import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.Integer;
import java.lang.StringBuilder;
import java.util.*;


class treesgraphs {

	static class Node
	{
		Node adjacent[];
		char data;
		
		public Node(char data)
		{
			this.data = data;
			adjacent = new Node[2];
			for(Node n : adjacent)
				n = null;
		}	
	
	
		static int testBalanced(Node root)
		{
			if(root == null)
				return 0;
			int heightLeft = testBalanced( root.adjacent[0] );
			int heightRight = testBalanced( root.adjacent[1] );
			if( Math.abs(heightLeft - heightRight) > 1 | heightLeft < 0 | heightRight < 0) 
				return -1;
			return Math.max(heightLeft, heightRight) + 1;			
		}
		
		static void printInorder(Node root)
		{
			if(root == null)
				return;
			printInorder( root.adjacent[0] );
			System.out.println( root.data );
			printInorder( root.adjacent[1] );
		
		}
	}	






	public static void main(String[] args)
	{	
		Node a = new Node( 'a' );
		Node b = new Node( 'b' );
		Node c = new Node( 'c' );
		Node d = new Node( 'd' );
		Node e = new Node( 'e' );
		Node f = new Node( 'f' );

		a.adjacent[0] = b;
		a.adjacent[1] = c;		
		
		b.adjacent[0] = d;
		
		c.adjacent[0] = e;
		c.adjacent[1] = f;
		
		//--
		
		Node z = new Node( 'z' );
		e.adjacent[1] = z;
		
		Node x = new Node( 'x' );
		z.adjacent[0] = x;
		

		Node.printInorder(a);
		
		System.out.println( Node.testBalanced(a) );
	}

}
