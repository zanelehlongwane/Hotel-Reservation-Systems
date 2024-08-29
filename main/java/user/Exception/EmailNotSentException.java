/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package user.Exception;

/**
 *
 * @author user
 */
public class EmailNotSentException extends Exception
{

    public EmailNotSentException(String message) {
        super(message);
    }
    
    public EmailNotSentException() {
        
        this("Error, could not send email");
    }
    public EmailNotSentException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
