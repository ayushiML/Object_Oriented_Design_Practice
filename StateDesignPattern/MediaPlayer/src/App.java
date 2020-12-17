public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        Player player = new Player();
        PlayerUI ui = new PlayerUI(player);
        ui.init();
    }
}
