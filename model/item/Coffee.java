package model.item;

/**
 * Describe a coffe, effect() restore energy.
 * 
 * @author Corentin Hardy
 * 
 */
public class Coffe extends Item {
    private final int normalCoffe = 10;
    private final int moreEnergy;

    public Coffe(Player player) {
        super(player, "normal coffe", "a delicious coffe");
        moreEnergy = normalCoffe;
    }

    @Override
    public void effect() {
        game.upgradeEnergyStudent(moreEnergy);
        if (getPlayer().haveThisItem(this))
            getPlayer().removeItem(this);
    }
}