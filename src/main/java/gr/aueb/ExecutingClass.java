package gr.aueb;

import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class ExecutingClass {
    /**
     * This class helps with the layout of App.java
     * Its considered an integral part of it.
     * It should not be viewed as stand-alone class
     */

    private final Scanner input = new Scanner(System.in);

    //Prints welcome message in command line
    public void welcome() {
        System.out.println("Welcome to our brand new Application. \n "
                + "Are you interested in finding a new job? \n "
                + "Are you looking for young aspiring employees? \n "
                + "If your answer was positive, then we are here to help "
                + "you!");
    }

    //Prints main menu in command line
    public int printMainMenu() {
        System.out.println(
                "Input your choice to continue: \n" + "1.Sign up \n"
                        + "2.Log in \n" + "3.Exit Application \n");
        return input.nextInt();

    }

    //Sign-up process
    public User signup() {
        input.nextLine(); //Clear console
        System.out.println("Thanks for your interest in signing up \n "
                + "We just need some basic info \n");

        //Asks for the user type and checks if the input is correct
        System.out.println(
                "First of all, what type of user are you; (Employee or "
                        + "Employer)");
        String userType = selectTypeOfUser();

        //If the input above is acceptable, asks for username
        System.out.println("Next input your Username");
        String username = createUserName();

        //Asks user for password and then it validates
        System.out.println("Input your Password");
        String password = createPassword();

        //Asks for user's name, no check needed
        System.out.println("Input your First Name");
        String name = input.nextLine();

        //Asks for user's surname, no check needed
        System.out.println("Input your Surname");
        String surname = input.nextLine();

        //Asks for user's password and checks if it is acceptable
        System.out.println("Input your Email");
        String email = createEmail();

        //Asks for user's date of birth, no check needed
        System.out.println("Input your Date of Birth");
        String dateOfBirth = input.nextLine();

        //Checks the user type
        //Depending on the type it creates the right object subclass
        // (Employee-Employer)
        User currentUser;
        if (userType.equals("employer")) {
            currentUser =
                    new Employer(username, password, name, surname, email,
                            dateOfBirth);
        } else {
            currentUser =
                    new Employee(username, password, name, surname, email,
                            dateOfBirth);
        }

        //Returns the new user
        return currentUser;
    }

    //Checks if the user's input type is acceptable and returns the
    // chosen type
    public String selectTypeOfUser() {

        boolean flag;
        String type;
        do {
            type = input.nextLine();
            type = type.toLowerCase();
            flag = Objects.equals(type, "employer") || Objects.equals(type,
                    "employee");

            if (!flag) {
                System.out.println("Hmm... That's a wrong section!");
                System.out.println("Type Employer or Employee!");
            }
        } while (!flag);
        //The loop ends when the user gives an acceptable type (Employee
        // or Employer)
        return type;
    }

    //Checks if the username is already taken
    //When a correct username is given the method ends and returns it
    public String createUserName() {
        boolean flag;
        String username;
        do {
            flag = true;
            username = input.nextLine();
            try {
                User.checkUserExistence(username);
            } catch (GeneralSecurityException e) {
                flag = false;
            }
            if (flag) {
                System.out.println(
                        "That username is taken please try again!");
            }
        } while (flag);
        return username;
    }

    public String createPassword() {
        boolean flag;
        String password;
        do {
            //Creates new password
            password = input.nextLine();
            //The user inputs the password twice
            System.out.println("please repeat the password inputed");
            String repeatPassword = input.nextLine();
            //If it matches then the password is accepted and the method
            // returns it
            flag = !Objects.equals(password, repeatPassword);
            //Else the user is asked to input again
            if (flag) {
                System.out.println(
                        "The passwords dont seem to match please repeat "
                                + "both inputs");
            }
        } while (flag);
        return password;
    }

    //Makes sure that the email address follows the correct email format
    public String createEmail() {
        boolean flag;
        String email;
        do {
            email = input.nextLine();
            //regex in accordance with RFC 5322
            String emailPattern = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\"
                    + ".[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\""
                    + "(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23"
                    + "-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c"
                    + "\\x0e-\\x7f])*\")@(?:(?:[a-z0-9]"
                    + "(?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9]"
                    + "(?:[a-z0-9-]*[a-z0-9])?|\\[(?:"
                    + "(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}"
                    + "(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9"
                    + "-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f"
                    + "\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b"
                    + "\\x0c\\x0e-\\x7f])+)\\])";
            Pattern pattern = Pattern.compile(emailPattern);
            Matcher matcher = pattern.matcher(email);
            flag = matcher.matches();
            if (!flag) {
                System.out.println(
                        "That email doesn't seem right! make sure its "
                                + "formatted as [...]@[domain]"
                                + ".[topLevenDomain] you entered: "
                                + email);
            }
        } while (!flag);
        return email;
    }

    //Login process
    public User login() {
        input.nextLine(); //Clear console
        System.out.println(
                "Lets get you logged in. We will just need some info!");
        User currentUser;
        do {
            currentUser = null;
            //Asks for user's credentials
            System.out.println("Input your username");
            String username = input.nextLine();
            System.out.println("Input your password");
            String password = input.nextLine();
            //Calls login method from User class
            try {
                currentUser = User.login(username, password);
            } catch (GeneralSecurityException e) {
                System.out.println(e.getMessage());
            }
        } while (currentUser == null);

        return currentUser;
    }

    //Print the user's home screen menu/the actions he can make
    // depending on his type
    public int printUserHomeScreen(final User currentUser) {
        System.out.println();
        System.out.println("Input your choice to continue: \n"
                + "1. Send a new Message \n"
                + "2. Read your new Messages \n" + "3. Log out \n"
                + "4. Change your profile info");
        //Employees can interact with posts, but not create
        if (currentUser instanceof Employee) {
            System.out.println("5. Read new Posts");
            //Employers can create new posts
        } else {
            System.out.println(
                    "5. Post home menu (Upload, Browse, Delete)");
        }
        System.out.println();
        //Returns user's selection
        return input.nextInt();
    }

    //Sends a new Message
    public void sendNewMessage(final User currentUser) {
        input.nextLine();
        boolean flag = true;
        while (flag) {
            try {
                System.out.println("Give receiver username: ");
                String username = input.nextLine();
                User receiver = User.getUserFromUsername(username);
                System.out.println("Give message contents: ");
                String contents = input.nextLine();
                Message message =
                        new Message(receiver, currentUser, contents);
                message.addUnseenMessage();
                flag = false;
            } catch (NullPointerException e) {
                System.out.println("The receiver that you want to"
                        + "send the message does not exist");
            }
        }
    }

    //Reads the unseen messages
    public void readNewMessages(final User currentUser) {
        ArrayList<Message> myUnseenMessages = currentUser.getNewMessages();
        if (myUnseenMessages.size() == 0) {
            System.out.println("You don't have new Messages");
        } else {
            System.out.println("You have new Messages");
            for (Message myUnseenMessage : myUnseenMessages) {
                myUnseenMessage.showMessage();
            }
        }
    }

    //Reads new posts
    public boolean checkNewPosts(final Employee currentUser) {
        ArrayList<Post> newPosts =
                new ArrayList<>(currentUser.getNewPosts());
        if (newPosts.isEmpty()) {
            System.out.println("No new posts");
            return false;
        } else {
            System.out.println("The posts you have not seen are: ");
            do {
                System.out.println(newPosts.remove(0));
            } while (!newPosts.isEmpty());
            return true;
        }
    }

    //Creates a post
    public void postCreator(final Employer currentUser) {
        input.nextLine(); //Clear scanner
        System.out.print("Job Title : ");
        String jobTitle = "Job Title : " + input.nextLine();
        System.out.println();
        System.out.print("Workplace(On-site , Hybrid , Remote) : ");
        String workPlace = "Workplace type(On-site , Hybrid , Remote) : "
                + input.nextLine() + " ";
        System.out.println();
        System.out.print("Job Location : ");
        String jobLocation = "Job Location : " + input.nextLine() + " ";
        System.out.println();
        boolean flag = true;
        String salaryRange = null;
        while (flag) {
            try {
                System.out.println("Salary Range ");
                System.out.print("   From: ");
                salaryRange = "Salary Range : " + input.nextInt() + "-";
                System.out.print("   To: ");
                salaryRange = salaryRange + input.nextInt() + " ";
                flag = false;
            } catch (InputMismatchException e1) {
                System.out.println(
                        "Hmm something went wrong. Please insert an "
                                + "integer value to "
                                + "keep the post creation process going");
                input.nextLine(); //Clear scanner
            } catch (Exception e) {
                System.out.println(
                        "Hmm something went wrong. Please try again to "
                                + "insert an integer value");
            }
        }
        System.out.println();
        System.out.print("Description : ");
        input.nextLine();
        String description = "Description : " + input.nextLine() + " ";
        System.out.println();
        String postContent =
                String.format("%s%n%s%n%s%n%s%n%s%n ", jobTitle, workPlace,
                        jobLocation, salaryRange, description);
        new Post(currentUser, postContent);
    }

    //Menu with actions on what he can change from his data
    public int printUserChangeInfoScreen() {
        System.out.println("Input your choice to continue: \n"
                + "1. Change Password \n" + "2. Change your Name \n"
                + "3. Cancel  \n");
        return input.nextInt();
    }

    //Method implements the change password method of the User class to
    // create a user-friendly dialog
    public void changePassword(final User currentUser) {
        boolean flag;
        do {
            flag = false;
            String oldPassword;
            String newPassword;
            input.nextLine();
            System.out.println("Please input your old password");
            oldPassword = input.nextLine();
            System.out.println("Please input your new password");
            newPassword = input.nextLine();
            try {
                currentUser.setPassword(oldPassword, newPassword);
            } catch (GeneralSecurityException e) {
                flag = true;
                System.out.println(e.getMessage());
            }
        } while (flag);
    }

    //Method implements the change name method of the User class to
    // create a user-friendly dialog
    public void changeName(final User currentUser) {
        boolean flag;
        input.nextLine();
        do {
            flag = false;
            String password;
            String newName;
            System.out.println("Please input your password");
            password = input.nextLine();
            System.out.println("Please input your new name");
            newName = input.nextLine();
            try {
                currentUser.setName(newName, password);
            } catch (GeneralSecurityException e) {
                flag = true;
                System.out.println(e.getMessage());
            }
        } while (flag);
    }

    //Exits the app
    public void exit() {
        exitScreen();
        try {
            TimeUnit.SECONDS.sleep(30);
        } catch (InterruptedException ignored) {
        }
        System.exit(0);
    }

    //Prints some messages before exiting
    public void exitScreen() {
        System.out.println("Thanks for using our application");
        System.out.println("All relevant data has been saved");
        System.out.println("This window will close soon");
    }

    //Implements various methods in order to like a post
    public void likeAPost(final Employee currentUser) {
        input.nextLine(); //Clear scanner

        int selection;
        Post postToLike;

        do {
            likeAPostMenu(); //Prints the menu
            selection = input.nextInt(); //Gets selection
            postToLike = Post.getPostFromPostNumber(
                    selection); // Gets Post or Null
            if (selection == -1) { // This is where we exit the loop if the
                // selection is -1
                break;
            } else if (postToLike == null) {
                System.out.println("That post number is not correct \n");

            } else if (currentUser.getLikedPosts().contains(
                    postToLike)) { //checks if the post was liked already
                System.out.println("You have already liked this Post! \n");
            } else {
                currentUser.addLikedPost(postToLike);
                System.out.println("Post was liked current like count is: "
                        + postToLike.getLikeCount());
                System.out.println();
            }
        } while (true); // Loop exits only on break line! under no other
        // condition
    }

    //Prints Post liking menu
    private void likeAPostMenu() {
        System.out.println("Input Post number to like\n"
                + "or input -1 to finish \n");
    }

    // Method prints a menu for the Employer and returns the input
    public int printEmployerPostManipulationScreen() {
        System.out.println();
        System.out.println("Input your choice to continue: \n"
                + "1. See your Draft Posts and their size \n"
                + "2. See Uploaded Posts and their size  \n"
                + "3. Make a Draft Post available (Upload it) \n"
                + "4. Delete a Draft Post \n" + "5. Create a Draft Post \n"
                + "6. Back to Home Screen \n");
        System.out.println();
        //Returns user's selection
        return input.nextInt();
    }

    public void printDraftPosts(final Employer employer) {
        System.out.println("You can find your draft posts below: \n");
        ArrayList<Post> myDraftPosts = employer.getDraftPosts();
        for (Post runMe : myDraftPosts) {
            System.out.println(runMe);
        }
    }

    //Implements various methods in order to upload a post
    public void uploadAPost(final Employer currentUser) {
        input.nextLine(); //Clear scanner

        int selection = 0;
        Post postToUpload;

        do {
            boolean flag = true;
            while (flag) {
                try {
                    uploadAPostMenu(); //Prints the menu
                    selection = input.nextInt(); //Gets selection
                    flag = false;
                } catch (Exception e) {
                    System.out.println(
                            "Something went wrong. You have to select an"
                                    + " integer value "
                                    + "to keep the process going");
                    input.nextLine();
                }
            }
            postToUpload = Post.getPostFromPostNumber(
                    selection); // Gets Post or Null
            if (selection == -1) { // This is where we exit the loop if the
                // selection is -1
                break;
            } else if (postToUpload == null) {
                System.out.println("That post number is not correct \n");
            } else if (!(currentUser.getDraftPosts().contains(
                    postToUpload))) { //checks if the currentUser is the
                // creator of the post
                System.out.println(
                        "You don't have permission to upload this post! "
                                + "\n");
            } else {
                postToUpload.setAvailable();
                System.out.println("The post has been uploaded!");
                System.out.println();
            }
        } while (true); // Loop exits only on break line! under no other
        // condition
    }

    //Prints Post uploading menu
    private void uploadAPostMenu() {
        System.out.println("Input Post number to upload\n"
                + "or input -1 to finish \n");
    }

    //Prints Draft Posts to be deleted menu
    private void deleteADraftPostMenu() {
        System.out.println("Input draft post number to delete\n"
                + "or input -1 to finish \n");
    }

    //Prints all uploaded Posts
    public void printUploadedPosts(final Employer emp) {
        System.out.println("You can find your uploaded posts below: \n");
        ArrayList<Post> uploadedPosts = emp.getUploadedPosts();
        for (Post i : uploadedPosts) {
            System.out.println(i);
        }
    }

    //Prints size of uploaded Posts
    public void printSizeOfUploadedPosts(final Employer emp) {
        System.out.println("The size of your uploaded posts is "
                + emp.sizeOfUploadedPosts());
    }

    //Prints size of Draft Posts
    public void printSizeOfDraftPosts(final Employer emp) {
        System.out.println("The size of your draft posts is "
                + (emp.sizeOfDraftPosts()));
    }

    //Implements functionality to delete a draft post
    public void deleteDraftPost(final Employer emp) {
        input.nextLine(); //Clear scanner
        int selection = 0;
        Post draftPostToDelete;
        do {
            boolean flag = true;
            while (flag) {
                try {
                    deleteADraftPostMenu(); //Prints the menu
                    selection = input.nextInt();
                    flag = false;
                } catch (Exception e) {
                    System.out.println(
                            "Something went wrong. You have to select an"
                                    + " integer value "
                                    + "to keep the process going");
                    input.nextLine();
                }
            }
            draftPostToDelete = Post.getPostFromPostNumber(selection);
            if (selection == -1) { // This is where we exit the loop if the
                // selection is -1
                break;
            } else if (draftPostToDelete == null) {
                System.out.println("That post number is not correct \n");
            } else if (!(emp.getDraftPosts().contains(
                    draftPostToDelete))) { //checks if the Employer emp
                // is the creator of the post
                System.out.println(
                        "You don't have permission to delete this post! "
                                + "\n");
            } else {
                emp.deleteDraftPost(draftPostToDelete);
                System.out.println("The post has been deleted!");
                System.out.println();
            }
        } while (true); // Loop exits only on break line! under no other
        // condition
    }

}

