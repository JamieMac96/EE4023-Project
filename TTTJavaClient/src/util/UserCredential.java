package util;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jamie
 */
public class UserCredential {
    
    private String username;
    private String password;
    private String forename;
    private String surname;
    
    private UserCredential(){
        
    }
    
    public static class Builder{
        
        private String uName;
        private String pWord;
        private String fName;
        private String sName;

        public Builder setUsername(String username){
            this.uName = username;
            
            return this;
        }
        
        public Builder setPassword(String password){
            this.pWord = password;
            
            return this;
        }
        
        public Builder setForename(String forename){
            this.fName = forename;
            
            return this;
        }
        
        public Builder setSurname(String surname){
            this.sName = surname;
            
            return this;
        }
        
        public UserCredential build(){
            UserCredential uCred = new UserCredential();
            
            uCred.forename = this.uName;
            uCred.password = this.pWord;
            uCred.forename = this.fName;
            uCred.surname = this.sName;
            
            return uCred;
        }
    }
    
    public String getUsername(){
        return this.username;
    }

    public String getPassword() {
        return password;
    }

    public String getForename() {
        return forename;
    }

    public String getSurname() {
        return surname;
    }
    
    @Override
    public String toString(){
        return "Username: " + username
                + "Password: " + password
                + "Forename: " + forename
                + "Surname: " + surname;
    }
}
