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
            } while (integerNotContainedInRange(1, 3, selection));

            switch (selection) {
                //Initiate the signup process if selection is 1
                case 1:
                    currentUser = runner.signup();
                    break;
                //initiate the login process if selection is 2
                case 2:
                    currentUser = runner.login();
                    break;
                //Terminate the app if selection is 3
                default:
                    runner.exit();
            }

            do {
                int localSelection;
                do {
                    //Print the Home Screen Menu
                    selection = runner.printUserHomeScreen(currentUser);
                    if (integerNotContainedInRange(1, 5, selection)) {
                        System.out.println("Wrong selection please try again");
                    }
                } while (integerNotContainedInRange(1, 5, selection));
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
                        } while (integerNotContainedInRange(1, 3, localSelection));

                        switch (localSelection) {
                            //Initiate the process if selection is 1
                            case 1:
                                runner.changePassword(currentUser);
                                System.out.println("Your password has changed!");
                                break;
                            //Initiate the process if selection is 2
                            case 2:
                                runner.changeName(currentUser);
                                System.out.println("Your Username has changed!");
                                break;
                            //Exit if selection is 3
                        }
                        break;
                    //Initiate the process if selection is 5
                    case 5:
                        if (currentUser instanceof Employer) {
                            do {
                                do {
                                    localSelection = runner.printEmployerPostManipulationScreen();

                                    if (integerNotContainedInRange(1, 6, localSelection)) {
                                        System.out.println("Wrong selection please try again");
                                    }
                                } while (integerNotContainedInRange(1, 6, localSelection));

                            switch (localSelection) {
                                //Initiate the process if selection is 1 (See draft Posts and size)
                                case 1:
                                    System.out.println("The size of the draft posts is " + (((Employer)currentUser).sizeOfDraftPosts()));
                                    System.out.println("You can find your draft posts below: ");
                                    runner.printMyDraftPosts((Employer)currentUser);
                                    break;
                                //Initiate the process if selection is 2 (See uploaded Posts and size)
                                case 2:
                                    runner.printUploadedPosts((Employer)currentUser);
                                    runner.printSizeOfUploadedPosts((Employer)currentUser);
                                    break;
                                //Initiate the process if selection is 3 (Upload a Draft Post)
                                case 3:
                                    runner.uploadAPost((Employer) currentUser);
                                    break;
                                //Initiate the process if selection is 4 (Delete a Draft Post)
                                case 4:
                                    runner.deletDraftPost((Employer)currentUser);
                                    break;
                                //Initiate the process if selection is 5 (Create a Draft Post)
                                case 5:
                                    runner.postCreator((Employer) currentUser);
                                    break;
                                //Exit if selection is 6
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

    //Checks if an integer is not contained in a CLOSED range. Includes from and to!
    public static boolean integerNotContainedInRange(int from, int to, int x) {
        boolean flag = false;
        for (int i = from; i < to + 1; i++) { //check if an integer is contained in range
            flag = flag || i == x;
        }
        return !flag; //return the opposite
    }
}