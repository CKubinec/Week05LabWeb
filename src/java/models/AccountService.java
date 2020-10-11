package models;

import java.util.HashMap;
import java.util.Map;

public class AccountService {
    private Map<String, String> userMap = new HashMap<String, String>()
    {{this.put("Abe", "password");
      this.put("Barb", "password");}};
    public AccountService() {
    }

    public User login(String userName, String password){
        String storedPassword = userMap.get(userName);
        if(!userMap.containsKey(userName)){
            return null;
        } else if (password.equals(storedPassword)) {
            return new User(userName, null);
        }
        return null;
    }
}
