package otpDemo;

import java.util.Random;

public class GenerateOtp {

	public static void main(String[] args) {
		// generate an OTP of 6 digits //
		int otp_len=6;
		System.out.println(generateOtp(otp_len));		

	}

	private static char[] generateOtp(int otp_len) {
		String numbers = "123456789";
		
		Random otpGenerator= new Random();
		
		char[] otp= new char[otp_len];
		
		for(int i=0; i<otp_len; i++) {
			otp[i]= numbers.charAt(otpGenerator.nextInt(numbers.length()));
		}
		return otp;
	}

}
