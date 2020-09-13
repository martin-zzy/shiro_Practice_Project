package huike.Realm;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.junit.Test;

public class TestPassword {

    @Test
    public void TestMd5Hash(){
        String username = "admin";
        String password = "123";
        String salt = "salt";
        String md5hashString = new Md5Hash(password,salt).toString();
        System.out.println(md5hashString);
    }
}
