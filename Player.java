/**
 * Player
 */
public class Player {

    private String name;
    private char symbol;

    public Player(String name, char symbol) {
        setName(name);
        setSymbol(symbol);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSymbol(char symbol) {
        if (symbol != '\0')
            this.symbol = symbol;
    }

    public char getSymbol() {
        return this.symbol;
    }

    public String getName() {
        return this.name;
    }
}