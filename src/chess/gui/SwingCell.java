package chess.gui;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import chess.model.Square;
import chess.model.pieces.Piece;

public class SwingCell extends JPanel {
	// Member Variables
	int x, y;
	private JLabel content;
	private boolean isSelected;
	Square sq;

	// Constructors
	// A constructor that takes a cell as argument and returns a new cell will the
	// same data but different reference
	public SwingCell(Square sq) throws CloneNotSupportedException {
		this.sq = sq;
		this.x = sq.x;
		this.y = sq.y;
		setLayout(new BorderLayout());
		if ((x + y) % 2 == 0)
			setBackground(new Color(113, 198, 113));
		else
			setBackground(Color.white);
	}

	public void setPiece(Piece p) // Function to inflate a cell with a piece
	{
		ImageIcon img = new javax.swing.ImageIcon(this.getClass().getResource(p.getPath()));
		content = new JLabel(img);
		this.add(content);
		sq.setPiece(p);
	}

	public void removePiece() // Function to remove a piece from the cell
	{
		this.remove(content);
		sq.removePiece();
	}

	public void select() // Function to mark a cell indicating it's selection
	{
		this.setBorder(BorderFactory.createLineBorder(Color.red, 6));
		this.isSelected = true;
		sq.select();
	}

	public boolean isselected() // Function to return if the cell is under selection
	{
		return this.isSelected;
	}

	public void deselect() // Function to delselect the cell
	{
		this.setBorder(null);
		this.isSelected = false;
		sq.deselect();
	}

	public void setpossibledestination() // Function to highlight a cell to indicate that it is a possible valid move
	{
		this.setBorder(BorderFactory.createLineBorder(Color.blue, 4));
		sq.setpossibledestination();
	}

	public void removepossibledestination() // Remove the cell from the list of possible moves
	{
		this.setBorder(null);
		sq.removepossibledestination();
	}

	public void setcheck() // Function to highlight the current cell as checked (For King)
	{
		this.setBackground(Color.RED);
		sq.setcheck();
	}

	public void removecheck() // Function to deselect check
	{
		this.setBorder(null);
		if ((x + y) % 2 == 0)
			setBackground(new Color(113, 198, 113));
		else
			setBackground(Color.white);
		sq.removecheck();
	}
}