/*
!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
1!1!1!
!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
 */
package com.park.parkinglot.util;

//import com.sun.istack.internal.logging.Logger;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
//import java.util.logging.Level;

/**
 *
 * @author Andrei Marica
 */
public class PasswordUtil {
    public static String convertToSha256(String password){
        try{
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(password.getBytes());
            byte[] digest = messageDigest.digest();
            String result = new BigInteger(1,digest).toString(16);
            return result;
        }
        catch (NoSuchAlgorithmException ex){
            //Logger.getLogger(PasswordUtil.class.getName()).log(Level.SEVERE,null,ex);     
        }
        return null;
    }
}
