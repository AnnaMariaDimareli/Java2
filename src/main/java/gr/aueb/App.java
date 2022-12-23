package gr.aueb;

/**
 * App.java is our Main class
 * Here we have the command line interface we use to run our Social Media App
 */

public class App {
    public static void main(String[] args) {
        //No user created yet
        User currentUser = null;
        ExecutingClass runner = new ExecutingClass();
        //Show the welcome menu
        runner.welcome();
        int selection;

        //Keep the interface open untill the user makes a choice
        do {

            do {
                //Show user's choices 
                selection = runner.printMainMenu();
            } while (selection != 1 && selection != 2 && selection != 3);

            switch (selection) {
                //Initiate the signup process if selection is 1
                case 1:
                    currentUser = runner.signup();
                    break;
                 //Initiate the login process if selection is 2    
                case 2:
                    boolean flag;
                    currentUser = runner.login();
                    break;
                //Terminate the app if selection is 3
                case 3:
                    runner.exit();
            }

            do {
                do {
                    //Print the Home Screen Menu
                    selection = runner.printUserHomeScreen(currentUser);
                } while (selection != 1 && selection != 2 && selection != 3 && selection != 4 && selection != 5);
                switch (selection) {
                    //Initiate the process if selection is 1
                    case 1:
                        runner.sendNewMessage(currentUser);
                        break;
                    //Initiate the process if selection is 2
                    case 2:

                        break;
                    //Terminate the app if selection is 3
                    case 3:
                        runner.exit();
                        break;
                    //Initiate the process if selection is 4
                    case 4:

                        break;
                    //Initiate the process if selection is 5
                    case 5:
                        if (currentUser instanceof Employer) {
                            runner.postCreator((Employer) currentUser);
                        }
                }
            } while (selection != 3);

        } while (true);
    }
}