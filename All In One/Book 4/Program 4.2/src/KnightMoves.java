import java.util.Scanner;

//Notes


// Class Inventory // *A class inventory is a list of
//                    classes that are in the program
//
//                    followed directly by a brief 
//                    statement of the members that
//                    are contained in each class



/* This program contains two classes:
 * 
 *   public class KnightMoves
 *   class Pos
 * 
 * 
 * 
 * 
 * The KnightMoves class contains:
 * 
 *   public static void main(String[] args)
 *   public static void showKnightMoves()
 *   public static Pos convertSquareToPos(String square)
 *   public static String convertPosToSquare(Pos p)
 *   public static Pos calculateNewLos(Pos p, int x, int y)
 *   public static void printBoard(int[][] b)
 *   public static boolean getYourN(String prompt)
 *  
 *  
 * 
 *  
 * The Pos class contains public Pos(int x, y)
 * 
 * */



public class KnightMoves 
{
	static Scanner sc = new Scanner(System.in);
	
	// the following static array represents the 8
	// possible moves that a knight can make which
	// is why int[][] moves is an 8 x 2 array.
	static int[][] moves = {
			{-2, +1},
			{-1, +2},
			{+1, +2},
			{+2, +1},
			{+2, -1},
			{+1, -2},
			{-1, -2},			
			{-2, -1},		
	};
	
	public static void main(String[] args)
	{
		System.out.println("Welcome to the "
				+ "Knight Move calculator.\n");
		do
		{
			try
			{
				showKnightMoves();
			}
			catch (Exception e)
			{
				System.exit(1);
			}
		}
		while(getYourN("Do it again?"));
	}
	
	public static void showKnightMoves()
	{
		// The first dimension is the file a, b, c, d, e, f, g, or h.
		// The second dimension is the rank 1, 2, 3, 4, 5, 6, 7, or 8.
		// Thus, board[3][4] is square d5.
		// A value of 0 means that the square is empty.
		// A value of 1 means that the knight is on the square.
		// A value of 2 means that the knight could move to the square.
		int[][] board = new int [8][8];
		
		String kSquare; // the knight's position as a square
		Pos kPos;       // the knight's position as a Pos
	
		// get the knight's initial position
		do 
		{
			System.out.println("Enter the knight's position: ");
			kSquare = sc.nextLine();
			kPos = convertSquareToPos(kSquare);
		}while(kPos == null);
		
		board[kPos.x][kPos.y] = 1;
	
		System.out.println("\nThe knight is at square " + convertPosToSquare(kPos));
		System.out.println("From here the knight can move to:");		
		
		for(int move = 0; move < moves.length; move++) 
		{
			int x, y;
			x = moves[move][0]; // the x for this move
			y = moves[move][1]; // the y for this move
			Pos p = calculateNewPos(kPos, x, y);
			
			if(p != null) 
			{
				System.out.println(convertPosToSquare(p));
				board[p.x][p.y] = 2;
			}
		}
	
		printBoard(board);
		
	}

	// this method converts squares such as a1 or d5 
	// into x,y coordinates such as [0][0] or [3][4].
	public static Pos convertSquareToPos(String square) 
	{
		int x = -1;
		int y = -1;
		char rank, file;
		
		file = square.charAt(0);
		if(file == 'a') {x = 0;}
		if(file == 'b') {x = 1;}
		if(file == 'c') {x = 2;}
		if(file == 'd') {x = 3;}
		if(file == 'e') {x = 4;}
		if(file == 'f') {x = 5;}
		if(file == 'g') {x = 6;}
		if(file == 'h') {x = 7;}
		
		rank = square.charAt(1);
		if(rank == 1) {y = 0;}
		if(rank == 2) {y = 1;}
		if(rank == 3) {y = 2;}
		if(rank == 4) {y = 3;}
		if(rank == 5) {y = 4;}
		if(rank == 6) {y = 5;}
		if(rank == 7) {y = 6;}
		if(rank == 8) {y = 7;}

		// if either x or y are negative one 
		// then the move is off of the board
		if(x == -1 || y == -1)
		{
			return null;
		}
		else
		{
			return new Pos(x,y);
		}
	}
	
	// this method converts x,y coordinates such as 
	// [0][0] or [3][4] to squares such as a1 or d5.
	public static String convertPosToSquare(Pos p) 
	{
		String file = "";
		if(p.x == 0) {file = "a";}
		if(p.x == 1) {file = "b";}
		if(p.x == 2) {file = "c";}
		if(p.x == 3) {file = "d";}
		if(p.x == 4) {file = "e";}
		if(p.x == 5) {file = "f";}
		if(p.x == 6) {file = "g";}
		if(p.x == 7) {file = "h";}
		
		return file + (p.y + 1);
	}
	
	// this method calculates a new Pos given a
	// starting Pos, an x move, and a y move
	// it returns a null if the resulting
	// move would be off of the board
	public static Pos calculateNewPos(Pos p, int x, int y) 
	{
		// rule out legal moves
		if(p.x + x < 0) {return null;}
		if(p.x + x > 7) {return null;}
		if(p.y + y < 0) {return null;}
		if(p.y + y > 7) {return null;}
		// return new position
		return new Pos(p.x + x, p.y + y);
	}
	
	public static void printBoard(int[][] b) 
	{
		// y is seven and as long as is bigger than
		// or equal to zero it is going to get smaller.
		for(int y = 7; y >= 0; y--)
		{
			// x is zero and as long as it is less 
			// than eight it is going to get bigger.
			for(int x = 0; x < 8; x++)
			{
				if(b[x][y] == 1)
				{
					System.out.println(" X ");
				}
				else if(b[x][y] == 2)
				{
					System.out.println(" ? ");
				} 
				else
				{
					System.out.println(" - ");
				}
			}
			System.out.println();
		}
	}
	
	public static boolean getYourN(String prompt) 
	{
		while(true) 
		{
			String answer;
			System.out.println("\n" + prompt + " (Y or N) ");
			answer = sc.nextLine();
			
			if(answer.equalsIgnoreCase("Y"))      {return true; }
			else if(answer.equalsIgnoreCase("N")) {return false;}
		}
	}
}

// this class represents the x,y coordinates on the board:
class Pos
{
	public int x;
	public int y;
	
	public Pos(int x, int y) 
	{
		this.x = x;
		this.y = y;
	}
}