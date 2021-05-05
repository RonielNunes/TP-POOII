package Util;
import java.io.File;
import java.util.ArrayList;
/**
 *
 * @author Roniel Nunes
 */
public class ListaCaminhoCartas {
    
    public ListaCaminhoCartas() {
    }
    
    public  ArrayList<String> listagemArquivo(String caminho){
        try{
            File diretorioCartas = new File(caminho); //Faz a abertura o endereço
            File fileList[] = diretorioCartas.listFiles(); 
            ArrayList<String> arquivosListado = new ArrayList<>();  //Cria uma lista para armazena-los
            for (File fileList1 : fileList) {
                arquivosListado.add(fileList1.getAbsolutePath()); //Percorrer armazenando
            }
            return arquivosListado; //retorna a lista preenchida
        }catch(Exception ex){
            return null;
        }
    }
}
