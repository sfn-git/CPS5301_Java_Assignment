import java.util.Scanner;

class accountGen{

    public static void main(String args[]) {

        Scanner reader = new Scanner(System.in);

        // Gets First Name
        System.out.print("Enter your First Name: ");
        String firstName = reader.next();

        // Gets Last Name
        System.out.print("Enter your Last Name: ");
        String lastName = reader.next();

        // Gets Security Question
        System.out.print("(Security Question) Favorite car maker: ");
        String secQuestion = reader.next();

        // Gets Birth Year
        System.out.print("Enter your birth year: ");
        int birthYear = reader.nextInt();
        
        reader.close();

        // Gets the email and password
        String email = generateEmail(firstName, lastName);
        String password = generatePassword(lastName, secQuestion, birthYear);

        // Outputs result
        System.out.println(firstName+" "+lastName);
        System.out.println("Kean Email: "+email);
        System.out.println("Kean Password: "+password);

    }

    public static String generateEmail(String firstName, String lastName){

        // Gets the first letter of first name and converts to a string
        String fName = Character.toString(firstName.charAt(0)).toLowerCase();

        // Returns email
        return fName+"."+lastName.toLowerCase().trim()+"@kean.edu";

    }

    public static String generatePassword(String lastName, String secQuestion, int birthYear){
        
        String password = "";
        int lnSubString = 3;
        int sqSubString = 3;

        // Handles lastname and secQuestion being less than 3 chars
        if(lastName.length() < 3){
            lnSubString = lastName.length();
        }

        if(secQuestion.length() < 3){
            sqSubString = secQuestion.length();
        }

        password += lastName.substring(0, lnSubString).toUpperCase();
        password += Integer.toString(birthYear);
        password += secQuestion.substring(0,sqSubString).toUpperCase();

        return password;
    }

}