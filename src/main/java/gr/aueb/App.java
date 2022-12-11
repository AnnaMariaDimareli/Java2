package gr.aueb;

/**
 * App.java is our Main class
 * Here we have the command line interface we use to run our Social Media App
 */

public class App {
    public static void main(String[] args) {
        //no user created yet
        User currentUser = null;
        ExecutingClass runner = new ExecutingClass();
        //show the welcome menu
        runner.welcome();
        int selection;

        //keep the interface open untill the user makes a choice
        do {

            do {
                //show user's choices 
                selection = runner.printMainMenu();
            } while (selection != 1 && selection != 2 && selection != 3);

            switch (selection) {
                //initiate the signup process if selection is 1
                case 1:
                    currentUser = runner.signup();
                    break;
                 //initiate the login process if selection is 2    
                case 2:
                    boolean flag;
                    currentUser = runner.login();
                    break;
                //terminate the app if selection is 3
                case 3:
                    runner.exit();
            }

            do {
                //print the Home Screen Menu
                selection = runner.printUserHomeScreen(currentUser);
            } while (selection != 1 && selection != 2 && selection != 3 && selection != 4 && selection != 5);


        } while (true);
    }
}