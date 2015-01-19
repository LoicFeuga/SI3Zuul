package model.item;
public class Coffee extends Item {
	private int energy;

	public void drink() {
		throw new UnsupportedOperationException();
	}

	public int getEnergy() {
		return this.energy;
	}

	public void setEnergy(int energy) {
		this.energy = energy;
	}
}