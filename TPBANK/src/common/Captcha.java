package common;

public class Captcha {

    public StringBuilder createCaptcha(int size) {
        StringBuilder captcha = new StringBuilder();
        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789";
        for (int i = 0; i < size; i++) {
            int number = (int) (Math.random() * str.length() - 1);
            captcha.append(str.charAt(number));
        }
        return captcha;
    }

    public boolean checkCaptcha(StringBuilder str, StringBuilder captcha) {
        return str.toString().equals(captcha.toString());
    }
}
