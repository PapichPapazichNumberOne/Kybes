public class GameLogic {
    private Dice dice;
    private Player player;
    private Player computer;

    public GameLogic(String playerName) {
        dice = new Dice();
        player = new Player(playerName);
        computer = new Player("Компьютер");
    }

    public void rollDice() {
        int playerRoll = dice.roll();
        int computerRoll = dice.roll();
        int playerSum = playerRoll + computerRoll;
        int computerSum = dice.roll() + dice.roll();

        if (playerSum > computerSum) {
            player.addScore(1);
        } else if (playerSum < computerSum) {
            computer.addScore(1);
        }
    }

    public int getPlayerScore() {
        return player.getScore();
    }

    public int getComputerScore() {
        return computer.getScore();
    }

    public String getWinner() {
        if (player.getScore() > computer.getScore()) {
            return player.getName();
        } else if (player.getScore() < computer.getScore()) {
            return computer.getName();
        } else {
            return "Ничья";
        }
    }
}
