public class Player extends Character {

    private int score;

    public Player() {
        super(100, 10, 10);
    }

    public int getScore() {
        return score;
    }

    public void changeStat(int x, String type) {
        switch(type) {
            case "health" -> health += x;
            case "attack" -> attack += x;
            case "agility" -> agility += x;
        }
        if (attack < 0) {
            attack = 0;
        }
        if (agility < 0) {
            agility = 0;
        }
    }

    public void win() {
        health += 50;
        score += 10;
    }

    @Override
    public String toString() {
        return "%s %-10s Score: %s".formatted(super.toString(),"",score);
    }
}
