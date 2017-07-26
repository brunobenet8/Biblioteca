package catalogo;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.web.WebView;

public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    @FXML
    private TextField txtisbn;
    @FXML
    private TextField txttitulo;
    @FXML
    private TextField txtedicao;
    @FXML
    private TextField txtanoedicao;
    @FXML
    private TextField txtsuporte;
    @FXML
    private TextField txtpaginas;
    @FXML
    private TextField txteditora;
    @FXML
    private TextArea txtautores;
    @FXML
    private WebView webv;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        try{//ISBN
            String isbn = webv.getEngine().getDocument().getElementsByTagName("div")
                    .item(16).getChildNodes()
                    .item(3).getTextContent();
            txtisbn.setText(isbn.replaceAll(" ",""));
        }catch(Exception e){
            System.out.println(""+e);
        }//fim
        try{//titulo
            String titulo = webv.getEngine().getDocument().getElementsByTagName("div")
                    .item(17).getChildNodes()
                    .item(3).getTextContent();
            txttitulo.setText(titulo);
        }catch(Exception e){
            System.out.println(""+e);
        }//fim
        try{//edicao
            String edicao = webv.getEngine().getDocument().getElementsByTagName("div")
                    .item(18).getChildNodes()
                    .item(3).getTextContent();
            txtedicao.setText(edicao.replaceAll(" ",""));
        }catch(Exception e){
            System.out.println(""+e);
        }//fim
        try{//ano
            String ano = webv.getEngine().getDocument().getElementsByTagName("div")
                    .item(19).getChildNodes()
                    .item(3).getTextContent();
            txtanoedicao.setText(ano.replaceAll(" ",""));
        }catch(Exception e){
            System.out.println(""+e);
        }//fim
        try{//suporte
            String suporte = webv.getEngine().getDocument().getElementsByTagName("div")
                    .item(20).getChildNodes()
                    .item(3).getTextContent();
            txtsuporte.setText(suporte.replaceAll(" ",""));
        }catch(Exception e){
            System.out.println(""+e);
        }//fim
        try{//paginas
            String pagina = webv.getEngine().getDocument().getElementsByTagName("div")
                    .item(21).getChildNodes()
                    .item(3).getTextContent();
            txtpaginas.setText(pagina.replaceAll(" ",""));
        }catch(Exception e){
            System.out.println(""+e);
        }//fim
        try{//editora
            String editora = webv.getEngine().getDocument().getElementsByTagName("div")
                    .item(22).getChildNodes()
                    .item(3).getTextContent();
            txteditora.setText(editora.replaceAll(" ",""));
        }catch(Exception e){
            System.out.println(""+e);
        }//fim
        try{//autores
            String autores = webv.getEngine().getDocument().getElementsByTagName("div")
                    .item(23).getChildNodes()
                    .item(3).getTextContent();
            txtautores.setText(autores.replaceAll(" ",""));
        }catch(Exception e){
            System.out.println(""+e);
        }//fim
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        webv.getEngine().load("http://www.isbn.bn.br/website/consulta/cadastro");
    }    
    
}
