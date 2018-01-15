package chess.gui;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import chess.Square;
import chess.model.pieces.King;
import chess.model.pieces.Piece;

public class TrataCell {
	// Member Variables
	private JLabel content;

	// Constructors
	public TrataCell(Piece p) {
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
	public TrataCell(Square cell) throws CloneNotSupportedException {
		painel.setLayout(new BorderLayout());
		if ((x + y) % 2 == 0)
			painel.setBackground(new Color(113, 198, 113));
		else
			painel.setBackground(Color.white);
	}

	public void setPiece(Piece p) // Function to inflate a cell with a piece
	{
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
	}

	public void removepossibledestination() // Remove the cell from the list of possible moves
	{
		this.painel.setBorder(null);
	}

	public void setcheck() // Function to highlight the current cell as checked (For King)
	{
		this.painel.setBackground(Color.RED);
	}

	public void removecheck() // Function to deselect check
	{
		this.painel.setBorder(null);
		if ((x + y) % 2 == 0)
			painel.setBackground(new Color(113, 198, 113));
		else
			painel.setBackground(Color.white);
	}
}