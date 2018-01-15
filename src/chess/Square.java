package chess;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import chess.model.pieces.King;
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
	private JLabel content;
	private Piece piece;
	JPanel painel = new JPanel();
	int x, y; // is public because this is to be accessed by all the other class
	private boolean isSelected = false;
	private boolean ischeck = false;

	// Constructors
	public Square(int x, int y, Piece p) {
		this.x = x;
		this.y = y;

		painel.setLayout(new BorderLayout());

		if ((x + y) % 2 == 0)
			painel.setBackground(new Color(113, 198, 113));

		else
			painel.setBackground(Color.white);

		if (p != null)
			setPiece(p);
	}

	// A constructor that takes a cell as argument and returns a new cell will the
	// same data but different reference
	public Square(Square cell) throws CloneNotSupportedException {
		this.x = cell.x;
		this.y = cell.y;
		painel.setLayout(new BorderLayout());
		if ((x + y) % 2 == 0)
			painel.setBackground(new Color(113, 198, 113));
		else
			painel.setBackground(Color.white);
		if (cell.getpiece() != null) {
			setPiece(cell.getpiece().getcopy());
		} else
			piece = null;
	}

	/*public void setPiece(Piece p) // Function to inflate a cell with a piece
	{
		piece = p;
		ImageIcon img = new javax.swing.ImageIcon(this.getClass().getResource(p.getPath()));
		content = new JLabel(img);
		this.painel.add(content);
	}

	public void removePiece() // Function to remove a piece from the cell
	{
		if (piece instanceof King) {
			piece = null;
			this.painel.remove(content);
		} else {
			piece = null;
			this.painel.remove(content);
		}
	}

	public Piece getpiece() // Function to access piece of a particular cell
	{
		return this.piece;
	}

	public void select() // Function to mark a cell indicating it's selection
	{
		this.painel.setBorder(BorderFactory.createLineBorder(Color.red, 6));
		this.isSelected = true;
	}

	public boolean isselected() // Function to return if the cell is under selection
	{
		return this.isSelected;
	}

	public void deselect() // Function to delselect the cell
	{
		this.painel.setBorder(null);
		this.isSelected = false;
	}

	public void setpossibledestination() // Function to highlight a cell to indicate that it is a possible valid move
	{
		this.painel.setBorder(BorderFactory.createLineBorder(Color.blue, 4));
		this.ispossibledestination = true;
	}

	public void removepossibledestination() // Remove the cell from the list of possible moves
	{
		this.painel.setBorder(null);
		this.ispossibledestination = false;
	}

	public boolean ispossibledestination() // Function to check if the cell is a possible destination
	{
		return this.ispossibledestination;
	}

	public void setcheck() // Function to highlight the current cell as checked (For King)
	{
		this.painel.setBackground(Color.RED);
		this.ischeck = true;
	}

	public void removecheck() // Function to deselect check
	{
		this.painel.setBorder(null);
		if ((x + y) % 2 == 0)
			painel.setBackground(new Color(113, 198, 113));
		else
			painel.setBackground(Color.white);
		this.ischeck = false;
	}

	public boolean ischeck() // Function to check if the current cell is in check
	{
		return ischeck;
	}*/
}