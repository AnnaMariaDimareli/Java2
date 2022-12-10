package gr.aueb;

public class ExecutingClass {
    /**
     * This class helps with the layout of App.java
     * Its considered an integral part of it
     * It should not be viewed as stand-alone class
     *
     */
    import java.util.Scanner;

public class Shit {
    
    Scanner input = new Scanner(System.in);

    public void welcome() {
        System.out.printf("Welcome to our brand new Application. /n "+
                            "Are you interested in finding a new job? /n "+ 
                            "Are you looking for young aspiring employees? /n "+ 
                            "If your answer was positive, then we are here to help you!");
    }

    public int printMainMenu() {
        System.out.prinf("Input your choice to continue: /n" +
                            "1.Sign up /n"+
                            "2.Log in /n"+
                            "3.Abbort Mission /n");
        return int answer = input.nextInt();
        input.clear();
    }

    public void loginScreen() throws GeneralSecurityException {
        System.out.println("Input your username");
        String name = input.nextLine();
        System.out.println("Input your password");
        String pass = input.nextLine();
        User currentUser = User.login(name,password);
    }

    public void signUpScreen() {
        System.out.println("Input your username");
        String username = input.nextLine();
        System.out.println("Input your password");
        String password = input.nextLine();
        System.out.println("Input your name");
        String name = input.nextLine();
        System.out.println("Input your surname");
        String surname = input.nextLine();
        System.out.println("Input your mail");
        String mail = input.nextLine();
        System.out.println("Input your Date of Birth");
        String dateOfBirth = input.nextLine();
        User currentUser = User(username, password, name, surname, mail, dateOfBirth);
    }
}
