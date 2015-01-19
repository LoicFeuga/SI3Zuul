import java.util.Vector;

public class Room {
	private boolean _isOpen;
	public Lesson _unnamed_Lesson_;
	public Vector<Item> _unnamed_Item_ = new Vector<Item>();
	public Game _unnamed_Game_;

	public boolean getIsOpen() {
		return this._isOpen;
	}

	public void setIsOpen(boolean aIsOpen) {
		this._isOpen = aIsOpen;
	}
}