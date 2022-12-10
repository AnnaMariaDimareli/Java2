package gr.aueb;

/**
 * Hello world!
 */

public class App {
    public static void main(String[] args) {
        User currentUser = null;
        ExecutingClass runner = new ExecutingClass();
        runner.welcome();
        int selection;

        do {

            do {
                selection = runner.printMainMenu();
            } while (selection != 1 && selection != 2 && selection != 3);

            switch (selection) {
                case 1:
                    currentUser = runner.signup();
                    break;
                case 2:
                    boolean flag;
                    currentUser = runner.login();
                    break;
                case 3:
                    runner.exit();
            }

            do {
                selection = runner.printUserHomeScreen(currentUser);
            } while (selection != 1 && selection != 2 && selection != 3 && selection != 4 && selection != 5);


        } while (true);
    }
}

class Interface {

}