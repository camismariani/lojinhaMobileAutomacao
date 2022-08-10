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

        String mensagemApresentada = new LoginPage(app)
               .informarUsuario(dotenv.get("env_user"))
               .informarSenha(dotenv.get("env_password"))
               .submeterLogin()
               .acessarFormularioAdicaoNovoProduto()
               .informarNomeDoProduto("Bolacha Trakinas")
               .informarValorDoProduto("700001")
               .informarCoresDoProduto("Marrom,Rosa")
               .submeterFormularioComErro()
               .obterMensagemDeErro();

        // validar que a msg de valor invalido foi apresentada

        Assertions.assertEquals("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00",mensagemApresentada);

    }

    @AfterEach
    public void afterEach(){
        app.quit();
    }
}
