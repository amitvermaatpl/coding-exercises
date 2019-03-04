package otpDemo;

import java.util.Random;

public class GeneratePassword {

	public static void main(String[] args) {
		// Length of password should be 10 //
		
		int pwd_len=10;
		System.out.println(generatePwd(pwd_len));
	}

	private static char[] generatePwd(int pwd_len) {
		
		System.out.println("Generating password using random() : "); 
        System.out.print("Your new password is : "); 
        
		// strong password has Cap_chars, Lower_chars, numeric value and characters //
		String Capital_chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"; 
        String Small_chars = "abcdefghijklmnopqrstuvwxyz"; 
        String numbers = "0123456789"; 
        String symbols = "!@#$%^&*_=+-/.?<>)"; 
				
        String values= Capital_chars + Small_chars + numbers + symbols;
        
        // Using RANDOM class to generate a random password //
        Random pwdGenerator= new Random();
        
        char[] password= new char[pwd_len];
        
        for(int i=0; i<pwd_len; i++) {
        	password[i]= values.charAt(pwdGenerator.nextInt(values.length()));
        }
        
		
		return password;
	}

}
