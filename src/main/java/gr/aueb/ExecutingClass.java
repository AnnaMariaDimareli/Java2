package gr.aueb;

import java.security.GeneralSecurityException;
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

    //prints welcome message in command line
    public void welcome() {
        System.out.println("Welcome to our brand new Application. \n "+
                            "Are you interested in finding a new job? \n "+
                            "Are you looking for young aspiring employees? \n "+
                            "If your answer was positive, then we are here to help you!");
    }
    
    //prints main menu in command line
    public int printMainMenu() {
        System.out.println("Input your choice to continue: \n" +
                            "1.Sign up \n"+
                            "2.Log in \n"+
                            "3.Abort Mission \n");
        return input.nextInt();

    }

    //sign-up process
    public User signup() {
        input.nextLine(); //clear console
        System.out.println("Thanks for your interest in signing up \n " +
                "We just need some basic info \n");

        //asks for the user type and checks if the input is correct
        System.out.println("First of all, what type of user are you; (Employee or Employer)");
        String userType = selectTypeOfUser();

        //if the input above is acceptable, asks for username
        System.out.println("Next input your Username");
        String username = createUserName();

        //asks user for password and then it validates
        System.out.println("Input your Password");
        String password = createPassword();

        //asks for user's name, no check needed
        System.out.println("Input your First Name");
        String name = input.nextLine();

        //asks for user's surname, no check needed
        System.out.println("Input your Surname");
        String surname = input.nextLine();

        //asks for user's password and checks if it is acceptable
        System.out.println("Input your Email");
        String email = createEmail();
        
        //asks for user's date of birth, no check needed
        System.out.println("Input your Date of Birth");
        String dateOfBirth = input.nextLine();

        //checks the user type
        //depending on the type it creates the right object subclass (Employee-Employer)
        User currentUser;
        if (userType.equals("Employer")) {
            currentUser = new Employer(username, password, name, surname, email, dateOfBirth);
        } else {
            currentUser = new Employee(username, password, name, surname, email, dateOfBirth);
        }

        //returns the new user
        return currentUser;
    }

    //checks if the user's input type is acceptable and returns the chosen type
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
        //the loop ends when the user gives an acceptable type (Employee or Employer)
        return type;
    }

    //checks if the username is already taken
    //when a correct username is given the method ends and returns it
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
            //creates new password
            password = input.nextLine();
            //The user inputs the password twice 
            System.out.println("please repeat the password imputed");
            String repeatPassword = input.nextLine();
            //if it matches then the password is accepted and the method returns it
            flag = !Objects.equals(password, repeatPassword);
             //else the user is asked to input again
            if (flag) {
                System.out.println("The passwords dont seem to match please repeat both inputs");
            }
        } while (flag);
        return password;
    }

    //makes sure that the email address follows the correct email format
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

    //login process
    public User login() {
        input.nextLine(); //clear console
        System.out.println("Lets get you logged in. We will just need some info!");
        User currentUser;
        do {
            currentUser = null;
            //asks for user's credentials
            System.out.println("Input your username");
            String username = input.nextLine();
            System.out.println("Input your password");
            String password = input.nextLine();
            //calls login method from User class
            try {
                currentUser = User.login(username, password);
            } catch (GeneralSecurityException e) {
                System.out.println(e.getMessage());
            }
        } while (currentUser == null);
        
        return currentUser;
    }

    //print the user's home screen menu/the actions he can make depending on his type
    public int printUserHomeScreen(User currentUser) {

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
        //returns user's selection 
        return input.nextInt();
    }

    //exits the app
    public void exit() {
        exitScreen();
        try {
            TimeUnit.SECONDS.sleep(30);
        } catch (InterruptedException ignored) {
        } finally {
            System.exit(0);
        }
    }

    //prints some messages before exiting
    public void exitScreen() {
        System.out.println("Thanks for using our application");
        System.out.println("All relevant data has been saved");
        System.out.println("This window will close soon");
    }

}
