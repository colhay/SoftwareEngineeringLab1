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
     * @throws IllegalArgumentException if amount is less than 0, or if there are insufficient funds.
     */
    public void withdraw (double amount) {
        if(amount < 0) throw new IllegalArgumentException("Cannot withdraw amount less than 0");
        if(amount > balance) throw new IllegalArgumentException("Insufficient Funds for withdrawl.");
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

        String[] emailParts = email.split("@", 2);
        if(emailParts.length < 2) return false;
        String local = emailParts[0];
        String domain = emailParts[1];
        String notFirst = ".-_";
        String notContained = " <>()[];:,@\\";


        // Check local
        if(local.length() <= 0) {
            return false;
        }
        else if(Character.isDigit(local.charAt(0)) || notFirst.indexOf(local.charAt(0)) != -1) {
            return false;
        }
        else if(local.contains(" ")) {
            return false;
        }

        for(int i=0; i<local.length(); i++) {
            if(notContained.indexOf(local.charAt(i)) != -1) {
                return false;
            }
        }

        // Check domain
        if(domain.indexOf('.') != domain.length() - 4) {
            return false;
        }
        else if(domain.length() < 5) {
            return false;
        }

        return true;
    }

    /**
     * Checks a given amount to see if it is valid. An amount is valid if
     * <p><ul>
     *     <li>The amount has no more than 2 decimal places
     *     <li>The amount is not negative
     * </ul><p>
     *
     * @param amount the amount who's validity is in question
     * @return the validity of the given amount
     */
    public static boolean isAmountValid(double amount) {
        return false;
    }
}
