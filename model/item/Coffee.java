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
        if (!getPlayer().haveThisItem(this))
            System.err.println(Language.translate("Cannot") + " "
                    + Language.translate("use") + " "
                    + Language.translate("this") + ": '" + this + "'"); // XXX
        else {
            System.out.println(Language.translate("You drunk your") + " "
                    + Language.translate(getName()) + ", "
                    + Language.translate("and regain some energy."));
            game.upgradeEnergyStudent(moreEnergy);
            getPlayer().removeItem(this);
        }
    }
}