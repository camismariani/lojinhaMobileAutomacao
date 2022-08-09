package modulos.produto;


import io.github.cdimascio.dotenv.Dotenv;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import paginas.LoginPage;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

@DisplayName("Teste mobile do módulo de Produtos")
public class ProdutoTest {

    private WebDriver app;

    Dotenv dotenv = Dotenv.load();

    @BeforeEach
    public void beforeEach() throws MalformedURLException {
        //Abrir o app
        DesiredCapabilities capacidades = new DesiredCapabilities();
        capacidades.setCapability("deviceName","Galaxy J7 Prime");
        capacidades.setCapability("platformName","Android");
        capacidades.setCapability("udid",dotenv.get("env_udid"));
        capacidades.setCapability("appPackage","com.lojinha");
        capacidades.setCapability("appActivity","com.lojinha.ui.MainActivity");
        //capacidades.setCapability("app","C:\\Users\\Zygo1\\Documents\\curso teste\\PTQS\\Módulo 11\\Lojinha Android Nativa\\lojinha-nativa.apk");

        this.app = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"),capacidades);

        this.app.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @Test
    @DisplayName("Validação do Valor de produto não Permitido")
    public void testValidacaoDoValorDeProdutoNaoPermitido()  {

        //Fazer login
       new LoginPage(app)
               .informarUsuario(dotenv.get("env_user"))
               .informarSenha(dotenv.get("env_password"))
               .submeterLogin();




        //Abrir formulário de novo produto

        app.findElement(By.id("com.lojinha:id/floatingActionButton")).click();

        // cadastrar um produto com valor invalido

        app.findElement(By.id("com.lojinha:id/productName")).click();
        app.findElement(By.id("com.lojinha:id/productName")).findElement(By.id("com.lojinha:id/editText")).sendKeys("Bolacha");

        app.findElement(By.id("com.lojinha:id/productValue")).click();
        app.findElement(By.id("com.lojinha:id/productValue")).findElement(By.id("com.lojinha:id/editText")).sendKeys("700001");

        app.findElement(By.id("com.lojinha:id/productColors")).click();
        app.findElement(By.id("com.lojinha:id/productColors")).findElement(By.id("com.lojinha:id/editText")).sendKeys("rosa,marrom");

        app.findElement(By.id("com.lojinha:id/saveButton")).click();


        // validar que a msg de valor invalido foi apresentada
        String mensagemApresentada = app.findElement(By.xpath("//android.widget.Toast")).getText();
        Assertions.assertEquals("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00",mensagemApresentada);

    }

    @AfterEach
    public void afterEach(){
        app.quit();
    }
}
