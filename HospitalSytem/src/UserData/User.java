/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserData;

/**
 *
 * @author Geri
 */
abstract public class User {
    protected String ID;
    
    protected String firstName;
    protected String surname;
    protected String address;
    protected String password;
    
    public User(){
        this.ID = "";
        this.firstName = "";
        this.surname = "";
        this.address = "";
        this.password = "";
    }
    
    public User(String userType, String firstName, String surname, String address, String password){
        this.ID = generateID(userType);
        this.firstName = firstName;
        this.surname = surname;
        this.address = address;
        this.password = password;
    }
    
    public User(User user){
        this.ID = user.ID;
        this.firstName = user.firstName;
        this.surname = user.surname;
        this.address = user.address;
        this.password = user.password;
    }
    
    public User CreateCorrectUser(User user){
        if (user.getID().startsWith("A")) {
            return new Administrator(user);
        }
        else if (user.getID().startsWith("D")) {
            return new Doctor(user);
        }
        else if (user.getID().startsWith("S")){
            return new Secretary(user);
        }
        else if (user.getID().startsWith("P")) {
            //* return a patient
        }
        
        return null;
    }
    
    
    private String generateID(String userType){
        String idNumbers = "";
        
        //* current maxid = Find number of said type *//
        //* idNumbers = maxid + 1 *//
        

        // Ensure that ID has correct length
        if (idNumbers.length() == 1) {
            idNumbers = "00" + idNumbers;
        }
        else if (idNumbers.length() == 2) {
            idNumbers = "0" + idNumbers;
        }
        
        return String.format("%s%s", userType, idNumbers);
    }
    
    
    //Getter & Setters


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
    
    
}
