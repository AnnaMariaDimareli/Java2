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
                //initiate the login process if selection is 2
                case 2:
                    boolean flag;
                    currentUser = runner.login();
                    break;
                //Terminate the app if selection is 3
                case 3:
                    runner.exit();
            }

            do {
                int localSelection;
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
                        runner.readNewMessages(currentUser);
                        break;
                    //Terminate the app if selection is 3
                    case 3:
                        break;
                    //Initiate the process if selection is 4
                    case 4:
                        do {
                            localSelection = runner.printUserChangeInfoScreen();
                        } while (localSelection != 1 && localSelection != 2 && localSelection != 3);

                        switch (localSelection) {
                            //initiate the process if selection is 1
                            case 1:
                                runner.changePassword(currentUser);
                                System.out.println("Your password has changed!");
                                break;
                            //initiate the process if selection is 2
                            case 2:
                                runner.changeName(currentUser);
                                System.out.println("Your Username has changed!");
                                break;
                            //exit if selection is 3
                        }
                        break;
                    //Initiate the process if selection is 5
                    case 5:
                        if (currentUser instanceof Employer) {
                            do {
                                localSelection = runner.printEmployerPostManipulationHomeScreen();

                                if (localSelection != 1 && localSelection != 2 && localSelection != 3 && localSelection != 4 && localSelection != 5 && localSelection != 6) {
                                    System.out.println("Wrong selection please try again");
                                }
                            } while (localSelection != 1 && localSelection != 2 && localSelection != 3 && localSelection != 4 && localSelection != 5 && localSelection != 6);

                            switch (localSelection) {
                                //initiate the process if selection is 1 (See draft Posts and size)
                                case 1:
                                    // TODO see issue #13 case 1
                                    break;
                                //initiate the process if selection is 2 (See uploaded Posts and size)
                                case 2:
                                    // TODO see issue #13 case 2
                                    break;
                                //initiate the process if selection is 3 (Upload a Draft Post)
                                case 3:
                                    // TODO see issue #13 case 3
                                    break;
                                //initiate the process if selection is 4 (Delete a Draft Post)
                                case 4:
                                    // TODO see issue #13 case 4
                                    break;
                                //initiate the process if selection is 5 (Create a Draft Post)
                                case 5:
                                    runner.postCreator((Employer) currentUser);
                                    break;
                                //exit if selection is 6
                            }

                        } else {
                            if (runner.checkNewPosts((Employee) currentUser)) {
                                runner.likeAPost((Employee) currentUser);
                            }
                        }
                }
            } while (selection != 3);

        } while (true);
    }
}