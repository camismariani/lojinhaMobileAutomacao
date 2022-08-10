package paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ListaDeProdutosPage extends BaseTela {

    public ListaDeProdutosPage(WebDriver app){
        super(app);
    }
    public FormularioDeAdicaoDeNovoProdutoPage acessarFormularioAdicaoNovoProduto(){
        app.findElement(By.id("com.lojinha:id/floatingActionButton")).click();

        return new FormularioDeAdicaoDeNovoProdutoPage(app);
    }
}
