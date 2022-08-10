package paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BaseTela {

    public LoginPage(WebDriver app){
        super(app);
    }

    public LoginPage informarUsuario(String usuario){
        app.findElement(By.id("com.lojinha:id/user")).click();
        app.findElement(By.id("com.lojinha:id/user")).findElement(By.id("com.lojinha:id/editText")).sendKeys(usuario);

        return this;
    }

    public LoginPage informarSenha(String senha){
        app.findElement(By.id("com.lojinha:id/password")).click();
        app.findElement(By.id("com.lojinha:id/password")).findElement(By.id("com.lojinha:id/editText")).sendKeys(senha);

        return this;

    }

    public ListaDeProdutosPage submeterLogin(){
        app.findElement(By.id("com.lojinha:id/loginButton")).click();
        return new ListaDeProdutosPage(app);
    }


}
