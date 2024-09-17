public class Main {
    public static void main(String[] args) {
        Player player = new Player();

        player.shoot(new Weapon());
        player.shoot(new Pistol());
    }
}