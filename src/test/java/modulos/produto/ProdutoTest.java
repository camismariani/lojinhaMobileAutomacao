package modulos.produto;


import io.github.cdimascio.dotenv.Dotenv;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

@DisplayName("Teste mobile do módulo de Produtos")
public class ProdutoTest {

    Dotenv dotenv = Dotenv.load();

    @Test
    @DisplayName("Validação do Valor de produto não Permitido")
    public void testValidacaoDoValorDeProdutoNaoPermitido() throws MalformedURLException {
        //Abrir o app
        DesiredCapabilities capacidades = new DesiredCapabilities();
        capacidades.setCapability("deviceName","Galaxy J7 Prime");
        capacidades.setCapability("platformName","Android");
        capacidades.setCapability("udid",dotenv.get("env_udid"));
        capacidades.setCapability("appPackage","com.lojinha");
        capacidades.setCapability("appActivity","com.lojinha.ui.MainActivity");
        //capacidades.setCapability("app","C:\\Users\\Zygo1\\Documents\\curso teste\\PTQS\\Módulo 11\\Lojinha Android Nativa\\lojinha-nativa.apk");

        WebDriver app = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"),capacidades);


        app.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //Fazer login
        app.findElement(By.id("com.lojinha:id/user")).click();
        app.findElement(By.id("com.lojinha:id/user")).findElement(By.id("com.lojinha:id/editText")).sendKeys(dotenv.get("env_user"));

        app.findElement(By.id("com.lojinha:id/password")).click();
        app.findElement(By.id("com.lojinha:id/password")).findElement(By.id("com.lojinha:id/editText")).sendKeys(dotenv.get("env_password"));

        app.findElement(By.id("com.lojinha:id/loginButton")).click();

        //Abrir formulário de novo produto

        app.findElement(By.id("com.lojinha:id/floatingActionButton")).click();

        // cadastrar um produto com valor invalido

        // validar que a msg de valor invalido foi apresentada


    }
}
