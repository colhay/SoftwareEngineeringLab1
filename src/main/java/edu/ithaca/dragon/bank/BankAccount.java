package edu.ithaca.dragon.bank;

public class BankAccount {

    private String email;
    private double balance;

    /**
     * @throws IllegalArgumentException if email is invalid
     */
    public BankAccount(String email, double startingBalance){
        if (isEmailValid(email)){
            this.email = email;
            this.balance = startingBalance;
        }
        else {
            throw new IllegalArgumentException("Email address: " + email + " is invalid, cannot create account");
        }
    }

    public double getBalance(){
        return balance;
    }

    public String getEmail(){
        return email;
    }

    /**
     * @post reduces the balance by amount if amount is non-negative and smaller than balance
     */
    public void withdraw (double amount)  {
        balance -= amount;

    }

    /**
     * Checks a given string and returns whether it is a valid email. A valid email is structured
     * as a local@domain.tld. The email must end in a .(3 character string), and the domain must not be blank.
     * The local portion of the email follows these rules:
     * <p><ul>
     * <li>It must not be blank
     * <li>Uses alphanumeric characters.
     * <li>Does not use the following characters < > ( ) [ ] ; : , @ \
     * <li>Cannot start with a number (0-9), a period (.), a dash (-), or an underscore (_). These characters are acceptable withing the address
     * <li>Cannot contain null characters (space)
     * </ul><p>
     *
     * @param email The email to check validity
     * @return The validity of the email
     */
    public static boolean isEmailValid(String email){
        if (email.indexOf('@') == -1){
            return false;
        }
        else {
            return true;
        }
    }
}
