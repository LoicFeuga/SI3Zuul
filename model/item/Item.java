package model.item;

public abstract class Item {
    private Game game;
    private String name;
    private String description;

    public Item(Game game, String name, String description) {
        this.game = game;
        this.name = name;
        this.description = description;
    }
    
    // getters
    public Game getGame() {
        return player;
    }
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }

    // setters
    public void setName(String name) {
        this.name = name;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    // others methods
    abstract public void effect();

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Item)) {
            return false;
        }
        Item other = (Item) obj;
        return name.equals(other.getName())
                && description.equals(other.getDescription()));
    }
}