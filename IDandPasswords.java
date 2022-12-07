import java.util.HashMap;

public class IDandPasswords {
    HashMap<String, String> logininfo = new HashMap<String, String >();

    IDandPasswords(){
        logininfo.put("Aastha","12345");
    }
    protected HashMap getlogininfo(){
        return logininfo;
    }
}
