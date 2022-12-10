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
     * Its considered an integral part of it
     * It should not be viewed as stand-alone class
     */


    Scanner input = new Scanner(System.in);

    public void welcome() {
        System.out.println("Welcome to our brand new Application. /n "+
                            "Are you interested in finding a new job? /n "+
                            "Are you looking for young aspiring employees? /n "+
                            "If your answer was positive, then we are here to help you!");
    }

    public int printMainMenu() {
        System.out.println("Input your choice to continue: /n" +
                            "1.Sign up /n"+
                            "2.Log in /n"+
                            "3.Abort Mission /n");
        return input.nextInt();

    }

    public User signup() {
        System.out.println("Thanks for your interest in signing up /n " +
                "We just need some basic info /n /n");

        System.out.println("First of all, what type of user are you; (Employee or Employer)");
        String userType = selectTypeOfUser();

        System.out.println("Next input your Username");
        String username = createUserName();

        System.out.println("Input your Password");
        String password = createPassword();

        System.out.println("Input your First Name");
        String name = input.nextLine();

        System.out.println("Input your Surname");
        String surname = input.nextLine();

        System.out.println("Input your Surname");
        String email = createEmail();

        System.out.println("Input your Date of Birth");
        String dateOfBirth = input.nextLine();

        User currentUser;
        if (userType.equals("Employer")) {
            currentUser = new Employer(username, password, name, surname, email, dateOfBirth);
        } else {
            currentUser = new Employee(username, password, name, surname, email, dateOfBirth);
        }
        return currentUser;
    }

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
        return type;
    }

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
            password = input.nextLine();
            System.out.println("please repeat the password imputed");
            String repeatPassword = input.nextLine();
            flag = !Objects.equals(password, repeatPassword);
            if (flag) {
                System.out.println("The passwords dont seem to match please repeat both inputs");
            }
        } while (flag);
        return password;
    }

    public String createEmail() {
        boolean flag;
        String email;
        do {
            email = input.nextLine();
            String emailPattern = "^(.+)@(.+)$";
            Pattern pattern = Pattern.compile(emailPattern);
            Matcher matcher = pattern.matcher(email);
            flag = matcher.matches();
            if (!flag) {
                System.out.println("That email dosent seem right! make sure its formated as [...]@[domain].[topLevenDomain] you entered: " + email);
            }
        } while (!flag);
        return email;
    }

    public User login() {
        System.out.println("Lets get you logged in. We will just need some info!");
        User currentUser;
        do {
            currentUser = null;
            System.out.println("Input your username");
            String username = input.nextLine();
            System.out.println("Input your password");
            String password = input.nextLine();
            try {
                currentUser = User.login(username, password);
            } catch (GeneralSecurityException e) {
                System.out.println(e.getMessage());
            }
        } while (currentUser == null);

        return currentUser;
    }

    public int printUserHomeScreen(User currentUser) {

        System.out.println("Input your choice to continue: /n" +
                "1. Send a new Message /n" +
                "2. Read your new Messages /n" +
                "3. Log out /n" +
                "4. Change your profile info /n");
        if (currentUser instanceof Employee) {
            System.out.println("5. Read new Posts");
        } else {
            System.out.println("5. Create a new Post");
        }
        return input.nextInt();
    }

    public void exit() {
        exitScreen();
        try {
            TimeUnit.SECONDS.sleep(30);
        } catch (InterruptedException ignored) {
        } finally {
            System.exit(0);
        }
    }

    public void exitScreen() {
        System.out.println("Thanks for using our application");
        System.out.println("All relevant data has been saved");
        System.out.println("This window will close soon");
    }

}
