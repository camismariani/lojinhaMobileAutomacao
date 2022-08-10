package paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FormularioDeAdicaoDeNovoProdutoPage extends BaseTela{

    public FormularioDeAdicaoDeNovoProdutoPage(WebDriver app){
        super(app);
    }

    public FormularioDeAdicaoDeNovoProdutoPage informarNomeDoProduto(String nomeDoProduto){
        app.findElement(By.id("com.lojinha:id/productName")).click();
        app.findElement(By.id("com.lojinha:id/productName")).findElement(By.id("com.lojinha:id/editText")).sendKeys(nomeDoProduto);
        
       return this;
  
    }
    
    public FormularioDeAdicaoDeNovoProdutoPage informarValorDoProduto(String valorProduto){
        app.findElement(By.id("com.lojinha:id/productValue")).click();
        app.findElement(By.id("com.lojinha:id/productValue")).findElement(By.id("com.lojinha:id/editText")).sendKeys(valorProduto);

        return this;

    }
    
    public FormularioDeAdicaoDeNovoProdutoPage informarCoresDoProduto(String coresDoProduto){
        app.findElement(By.id("com.lojinha:id/productColors")).click();
        app.findElement(By.id("com.lojinha:id/productColors")).findElement(By.id("com.lojinha:id/editText")).sendKeys(coresDoProduto);

        return this;
    }

    public FormularioDeAdicaoDeNovoProdutoPage submeterFormularioComErro(){

        app.findElement(By.id("com.lojinha:id/saveButton")).click();

        return this;

    }

    public String obterMensagemDeErro(){
      return capturarToast();
    }


}
