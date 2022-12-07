public class Main {
    public static void main(String[] args) {
        IDandPasswords idandpasswords = new IDandPasswords();
        Login loginpage = new Login(idandpasswords.getlogininfo());
    }

}