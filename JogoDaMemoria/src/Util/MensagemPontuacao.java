package Util;
/**
 * @author Roniel Nunes
 */
public class MensagemPontuacao {
    private final String mensagemEmpate;
    private final String mensagemVitoria;
    private final String mensagemDerrota;
    
    public MensagemPontuacao(){
        this.mensagemEmpate = "Empate!";
        this.mensagemVitoria = "Você venceu!";
        this.mensagemDerrota = "Você perdeu!";
    }
    
    public String vencedorJogo(int pontuacaoJogador, int pontucaoComputador){ 
        if(pontuacaoJogador == pontucaoComputador){
            return mensagemEmpate;
        
        }else if(pontuacaoJogador > pontucaoComputador){
            return mensagemVitoria;
        
        }else if(pontuacaoJogador < pontucaoComputador){
            return mensagemDerrota;  
        }
        return null;
    }
}
