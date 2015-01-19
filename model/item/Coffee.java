public class Coffee extends Item {
	private int _energy;

	public void drink() {
		throw new UnsupportedOperationException();
	}

	public int getEnergy() {
		return this._energy;
	}

	public void setEnergy(int aEnergy) {
		this._energy = aEnergy;
	}
}