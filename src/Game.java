import java.util.*;

public class Game {

    public static void main(String[] args) {

        Player player = new Player();
        boolean flag = true;

        while (flag) {

            if (player.getHealth() <= 0) {
                System.out.println("You've lost :( Your score is: " + player.getScore());
                break;
            }

            Menu.printDoors();
            System.out.println("Player: " + player);
            System.out.println("Choose the door you want to open");

            Random rand = new Random();
            Enemy enemy = new Enemy(
                    rand.nextInt(50,150),
                    rand.nextInt(5,10),
                    rand.nextInt(5,10));

            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();

            switch (input.toUpperCase().charAt(0)) {
                case '1','2','3' -> {
                    int option = getOptions().get(Integer.parseInt(input) - 1);
                    if (option == 0) {
                        boolean result = battle(player, enemy);
                        if (result) {
                            player.win();
                            System.out.println("You've won the battle!");
                        }
                    } else {
                        List<String> stats = new ArrayList<>(List.of("health", "attack", "agility"));
                        Collections.shuffle(stats);
                        String stat = stats.get(0);
                        if (stat.equals("health")) option *= 5;
                        player.changeStat(option, stat);
                        String change = (option < 0) ? "decreased" : "increased";
                        System.out.println("Your " + stat + " is " + change + " by " + Math.abs(option));
                    }
                }
                case 'Q' -> {
                    System.out.println("Quitting the game");
                    flag = false;
                }
                default -> System.out.println("Incorrect input");
            }
        }
    }

    public static List<Integer> getOptions() {
        Random rand = new Random();
        List<Integer> list = new ArrayList<>(List.of(
                rand.nextInt(-10, -1),
                0,
                rand.nextInt(1, 10)
        ));
        Collections.shuffle(list);
        return list;
    }

    public static boolean battle(Player player, Enemy enemy) {
        Character attacking = player;
        Character defending = enemy;
        int count = 0;

        while(defending.getHealth() > 0) {
            if (count % 2 == 0) {
                attacking = player;
                defending = enemy;
            } else {
                attacking = enemy;
                defending = player;
            }
            attacking.attack(defending);
            count++;
        }

        return defending != player;
    }
}
