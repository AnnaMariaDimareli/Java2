import java.util.Scanner ;
import java.util.Date;
public class Post {
    User usr = new User();
    
    Employer emp = new Employer();
    
    private String creator ; 
    
    public Post(){
    
        this.creator = emp.getName() +" "+ emp.getSurname() ;
    
    }
    
    private int likeCount = 0 ;
    
    private boolean available = false ;
    
    Date dt = new Date(System.currentTimeMillis());
    
    private String creationDate; //The creation date of the certain post 
    
    public int getLikeCount() {
    
        return likeCount;
    
    }
    
    public void like(){ //if an employee wants to like a post then Employee class calls setLikeCount method to increase post's number of likes// 
    
    this.likeCount++;
    
    }
    
    public void getAvailable() {
    
        if (this.available == true) {
    
            System.out.print("The post is available") ; 

    
        } else {
    
            System.out.print("The post is not available");
    
        }
    
    }
    /* if the employer wants to make the post available then calls setAvailable with argument YES 
     * if he wants to set it as unavailable then calls setAvailable with argument NO 
     */
    public void setAvailable(String answer) { 
    
        if ( answer == "YES") {
    
            this.available = true ;

            emp.addUploadedPosts(this); //CHECK THE ARGUMENT.
    
        } else if ( answer == "NO") {
    
            this.available = false ;
    
        }
    
    }
    /*createPost method offers to Employers a template in order to create their job offering post .
     * If they just want to create a post to share their ideas about the labor market they choose the second option
    */
    public String createPost() {
        System.out.println("Do you want to create a job offering post or share your thoughts about the labor market ?. Type 1 or 2");
        this.creationDate = dt.toString();
    
        Scanner input = new Scanner(System.in);
        if (input.nextInt() == 1 ) {
            return String.format("Job Title : %s /n Company : %s /n Workplace type(On-site , Hybrid , Remote) : %s /n Job Location : %s /n Salary Range : %d - %d /n Description : %s /n" ,  input.nextLine() , input.nextLine() ,  , input.nextLine() , input.nextLine() , input.nextInt() , input.nextInt() ,  input.nextLine() );
        } else if ( input.nextInt() == 2 ) {
            return String.format("Share your thoughts with your network . /n %s" , input.nextLine()) ; 
        }
    }

    @Override
    
    public String toString() {
    
        return String.format("This post was created on %s by %s" , this.creationDate , this.creator);
    
    }




}












