package testdata;
import org.testng.annotations.DataProvider;

public class LoginData {

    @DataProvider(name = "loginData")
    public Object[][] loginData(){

        return new Object[][]{

                {"gopal1785954638247@gmail.com","12345678"},
                {"gopalmuruga001@gmail.com","1234567890"}
        };
    }



}
