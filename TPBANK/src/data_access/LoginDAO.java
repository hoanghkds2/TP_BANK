
package data_access;

import common.Captcha;
import common.Validation;
import java.util.Locale;
import java.util.ResourceBundle;


public class LoginDAO {
    private static LoginDAO instance = null;
    private Validation valid = new Validation();
    private Captcha captcha = new Captcha();
    private Locale localeEN = new Locale("en");
    private Locale localevi = new Locale("vi");
    ResourceBundle labels;
    
    public static LoginDAO Instance(){
        if(instance == null){
            synchronized (LoginDAO.class) {
                if(instance == null){
                    instance = new LoginDAO();
                }
            }
        }
        return instance;
    }
    
    public void login(String type){
        if(type.equals("en")){
            labels = ResourceBundle.getBundle("prompt", localeEN);
        }
        else{
            labels = ResourceBundle.getBundle("prompt", localevi);
        }
        valid.inputNumber(labels.getString("Account_number"), 
                                                labels.getString("Wrong_number"));
        valid.inputPassWord(labels.getString("Password"), 
                                            labels.getString("Wrong_password"));
        StringBuilder checkCode = captcha.createCaptcha(6);
        System.out.print(labels.getString("Captcha"));
        System.out.println(": "+checkCode);
        valid.inputCaptcha(labels.getString("TypeCaptcha"),
                                        labels.getString("Wrong_captcha"),checkCode);
        System.out.println(labels.getString("Success"));
    }
}
