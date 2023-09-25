import java.util.Random;

public class Character {

    int health;
    int attack;
    int agility;

    public Character(int health, int attack, int agility) {
        this.health = health;
        this.attack = attack;
        this.agility = agility;
    }

    public int getHealth() {
        return health;
    }

    public void attack(Character character) {
        character.health -= attack;
        System.out.println(character.getClass().getSimpleName() + " health is now " + character.health);
    }

    public boolean duck() {
        Random rand = new Random();
        if (rand.nextInt(1,10) * agility > 90) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Health: %-5d Attack: %-5d Agility: %d".formatted(health, attack, agility);
    }
}
