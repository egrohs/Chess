package chess.model;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

import chess.model.pieces.Piece;

/**
 * This is the Cell Class. It is the token class of our GUI. There are total of
 * 64 cells that together makes up the Chess Board
 *
 */
public class Square implements Cloneable {
	// Member Variables
	private static final long serialVersionUID = 1L;
	private boolean ispossibledestination;
	//private JLabel content;
	private Piece piece;
	//JPanel painel = new JPanel();
	public int x, y; // is public because this is to be accessed by all the other class
	private boolean isSelected = false;
	private boolean ischeck = false;

	// Constructors
	public Square(int x, int y, Piece p) {
		this.x = x;
		this.y = y;

		if (p != null)
			setPiece(p);
	}

	// A constructor that takes a cell as argument and returns a new cell will the
	// same data but different reference
	public Square(Square cell) throws CloneNotSupportedException {
		this.x = cell.x;
		this.y = cell.y;

		if (cell.getpiece() != null) {
			setPiece(cell.getpiece().getcopy());
		} else
			piece = null;
	}

	public void setPiece(Piece p) // Function to inflate a cell with a piece
	{
		piece = p;
	}

	public void removePiece() // Function to remove a piece from the cell
	{
		piece = null;
	}

	public Piece getpiece() // Function to access piece of a particular cell
	{
		return this.piece;
	}

	public void select() // Function to mark a cell indicating it's selection
	{
		this.isSelected = true;
	}

	public boolean isselected() // Function to return if the cell is under selection
	{
		return this.isSelected;
	}

	public void deselect() // Function to delselect the cell
	{
		this.isSelected = false;
	}

	public void setpossibledestination() // Function to highlight a cell to indicate that it is a possible valid move
	{
		this.ispossibledestination = true;
	}

	public void removepossibledestination() // Remove the cell from the list of possible moves
	{
		this.ispossibledestination = false;
	}

	public boolean ispossibledestination() // Function to check if the cell is a possible destination
	{
		return this.ispossibledestination;
	}

	public void setcheck() // Function to highlight the current cell as checked (For King)
	{
		this.ischeck = true;
	}

	public void removecheck() // Function to deselect check
	{
		this.ischeck = false;
	}

	public boolean ischeck() // Function to check if the current cell is in check
	{
		return ischeck;
	}
}