package gr.aueb;

import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExecutingClass {
    /**
     * This class helps with the layout of App.java
     * Its considered an integral part of it.
     * It should not be viewed as stand-alone class
     */

    Scanner input = new Scanner(System.in);

    //Prints welcome message in command line
    public void welcome() {
        System.out.println("Welcome to our brand new Application. \n "+
                            "Are you interested in finding a new job? \n "+
                            "Are you looking for young aspiring employees? \n "+
                            "If your answer was positive, then we are here to help you!");
    }
    
    //Prints main menu in command line
    public int printMainMenu() {
        System.out.println("Input your choice to continue: \n" +
                            "1.Sign up \n"+
                            "2.Log in \n"+
                            "3.Abort Mission \n");
        return input.nextInt();

    }

    //Sign-up process
    public User signup() {
        input.nextLine(); //Clear console
        System.out.println("Thanks for your interest in signing up \n " +
                "We just need some basic info \n");

        //Asks for the user type and checks if the input is correct
        System.out.println("First of all, what type of user are you; (Employee or Employer)");
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
        //Depending on the type it creates the right object subclass (Employee-Employer)
        User currentUser;
        if (userType.equals("Employer")) {
            currentUser = new Employer(username, password, name, surname, email, dateOfBirth);
        } else {
            currentUser = new Employee(username, password, name, surname, email, dateOfBirth);
        }

        //Returns the new user
        return currentUser;
    }

    //Checks if the user's input type is acceptable and returns the chosen type
    public String selectTypeOfUser() {

        boolean flag;
        String type;
        do {
            type = input.nextLine();

            flag = Objects.equals(type, "Employer") || Objects.equals(type, "Employee");

            if (!flag) {
                System.out.println("Hmm... That's a wrong section!");
                System.out.println("Type Employer or Employee!");
            }
        } while (!flag);
        //The loop ends when the user gives an acceptable type (Employee or Employer)
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
                System.out.println("That username is taken please try again!");
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
            System.out.println("please repeat the password imputed");
            String repeatPassword = input.nextLine();
            //If it matches then the password is accepted and the method returns it
            flag = !Objects.equals(password, repeatPassword);
             //Else the user is asked to input again
            if (flag) {
                System.out.println("The passwords dont seem to match please repeat both inputs");
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
            //TODO consider using regex in accordance with RFC 5322 Official Standard. Ask if its ok!
            String emailPattern = "^(.+)@(.+)\\.(.+)$";
            Pattern pattern = Pattern.compile(emailPattern);
            Matcher matcher = pattern.matcher(email);
            flag = matcher.matches();
            if (!flag) {
                System.out.println("That email doesn't seem right! make sure its formatted as [...]@[domain].[topLevenDomain] you entered: " + email);
            }
        } while (!flag);
        return email;
    }

    //Login process
    public User login() {
        input.nextLine(); //Clear console
        System.out.println("Lets get you logged in. We will just need some info!");
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

    //Print the user's home screen menu/the actions he can make depending on his type
    public int printUserHomeScreen(User currentUser) {
        System.out.println();
        System.out.println("Input your choice to continue: \n" +
                "1. Send a new Message \n" +
                "2. Read your new Messages \n" +
                "3. Log out \n" +
                "4. Change your profile info");
        //Employees can interact with posts, but not create        
        if (currentUser instanceof Employee) {
            System.out.println("5. Read new Posts");
        //Employers can create new posts
        } else {
            System.out.println("5. Create a new Post");
        }
        System.out.println();
        //Returns user's selection 
        return input.nextInt();
    }

    //Sends a new Message
    public void sendNewMessage(User currentUser) {
        System.out.println("Give receiver username: ");
        String username = input.nextLine();
        User receiver = User.getUserFromUsername(username);
        System.out.println("Give message contents: ");
        String contents = input.nextLine();
        Message message = new Message(receiver, currentUser, contents);
    }

    //Reads the unseen messages
    public void readNewMessages(User currentUser) {
        System.out.println("You have new Messages"); //FIXME what if i dont have messages????
        ArrayList<Message> myUnseenMessages = currentUser.getNewMessages();
        for (Message myUnseenMessage : myUnseenMessages) {
            System.out.println(myUnseenMessage.toString());
        }
    }

    //Reads new posts
    public boolean checkNewPosts(Employee currentUser) {
        ArrayList<Post> newPosts =new ArrayList<>(currentUser.getNewPosts());
        if(newPosts.isEmpty()){
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
    public void postCreator(Employer currentUser) {
        if (input.hasNext()) {input.nextLine();}
        System.out.print("Job Title : ");
        String jobTitle = "Job Title : " + input.nextLine();
        System.out.println();
        System.out.print("Workplace(On-site , Hybrid , Remote) : ");
        String workPlace = "Workplace type(On-site , Hybrid , Remote) : " + input.nextLine() + " ";
        System.out.println();
        System.out.print("Job Location : ");
        String jobLocation = "Job Location : " + input.nextLine() + " ";
        System.out.println();
        System.out.println("Salary Range ");
        System.out.print("   From: ");
        String salaryRange = "Salary Range : " + input.nextInt() + "-";
        System.out.print("   To: ");
        salaryRange=salaryRange + input.nextInt() + " ";
        System.out.println();
        System.out.print("Description : ");
        String description = "Description : " + input.next() + " ";
        System.out.println();
        String postContent = String.format("%s\n%s\n%s\n%s\n%s\n " ,jobTitle ,workPlace ,jobLocation ,salaryRange ,description);
        Post post = new Post(currentUser, postContent);
        post.setAvailable(); //FIXME remove when issue #13 is fixed
    }

    //Menu with actions on what he can change from his data
    public int printUserChangeInfoScreen() {
        System.out.println("Input your choice to continue: \n" +
                "1. Change Password \n" +
                "2. Change your Name \n" +
                "3. Cancel  \n"
        );
        return input.nextInt();
    }

    //Method implements the change password method of the User class to create a user-friendly dialog
    public void changePassword(User currentUser) {
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
                flag=true;
                System.out.println(e.getMessage());
            }
        }while(flag);
    }

    //Method implements the change name method of the User class to create a user-friendly dialog
    public void changeName(User currentUser) {
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
                currentUser.setName(newName,password);
            } catch (GeneralSecurityException e) {
                flag=true;
                System.out.println(e.getMessage());
            }
        }while(flag);
    }

    //Exits the app
    public void exit() {
        exitScreen();
        try {
            TimeUnit.SECONDS.sleep(30);
        } catch (InterruptedException ignored) {
        } finally {
            System.exit(0);
        }
    }

    //Prints some messages before exiting
    public void exitScreen() {
        System.out.println("Thanks for using our application");
        System.out.println("All relevant data has been saved");
        System.out.println("This window will close soon");
    }

    public void likeAPost(Employee currentUser) {
        if (input.hasNext()) {input.nextLine();}
        int selection;
        likeAPostMenu();
        selection = input.nextInt();
        while (selection != -1) {
            Post postToLike;
            do {
                postToLike = Post.getPostFromPostNumber(selection);
                if (postToLike == null || currentUser.getLikedPosts().contains(postToLike)) {
                    System.out.println("That post number is not correct or you have already liked it!");
                }
            } while (postToLike == null|| currentUser.getLikedPosts().contains(postToLike));
            currentUser.addLikedPost(postToLike);
            System.out.println("Post was liked current like count is: "+postToLike.getLikeCount());
            System.out.println();
            likeAPostMenu();
            selection = input.nextInt();
        }
    }

    private void likeAPostMenu() {
        System.out.println("Input Post number to like\n" +
                "or input -1 to finish \n");
    }
}
