package SegundaTela;
import Util.ListaCaminhoCartas;
import Util.MensagemPontuacao;
import View.TelaInicial;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;
/**
 *
 * @author Roniel Nunes
 */
public class SegundaTelaJogoMemoria extends JFrame  implements ActionListener{
    private int totalCartas; //Variável para marcar a quantidade de cartas
    private int flagStatusMostrarOculta; //Flag para mostrar statusFinal
    private int primeiraEscolha; //Flag para marcar primeira escolha
    private int segundaEscolha; //Flag para marcar segunda escolha
    private int contadorJogadasAcertadasJogador; //Flag para contar o número de acertos feito pelo jogador
    private int contadorJogadasAcertadasComputador; //Flag para contar o número de acertos feito pelo computador
    private int controlaMemoriaComputador; //Flag para controlar a memoria do omputador
    private int flagFinalJogo; //Flag para controlar final do jogo
    private int levelMemoria; //Flag para marcar o número de cartas que o omputador lembra
    private JButton[]  listaBotoes; // Vetor de botoes com os endereços
    private boolean boolComparando; //Flag para verificar se ha comparacao
    private boolean opcaoEscolhaComputador; //opcao escolhida pelo cpmpputador
    private String enderecoDiretoriopath1; //String parar o endereco da imagem padrao
    private String enderecoDiretoriopath ; //String parar o endereco da imagem padrao
    private String imagemIconePadrao; //String parar o endereco da imagem padrao
    private String diretorioCartas; //String parar o endereco da imagem padrao
    private ArrayList<String> arrayListCartas; //String parar o endereco da imagem padrao
    private ArrayList<String> arrayListaCartasEmJogo; //Array parar listar as cartas que estão em jogo
    private ArrayList<Integer> arrayPossibilidadeCartaJogo; //Array que armazena os movimento
    private ArrayList<String> arrayMemoriaComputador;  //Array para memorizar as cartas
    private Timer timer; //Timer 
    private Timer timerExibicao; // timer para exibir
    private Timer timerDeComparacao; //Timer de comparação
    //Objetos
    private ListaCaminhoCartas listaCartasObjeto;  //Leitura do pasta, usado para armazenar os diretorio das imagens
 
    public SegundaTelaJogoMemoria (){
        //INSTÂNCIAÇÕES DAS VARIÁVEIS
        this.listaCartasObjeto = new ListaCaminhoCartas(); //String parar o endereco da imagem padrao
        this.enderecoDiretoriopath1 = SegundaTelaJogoMemoria.class.getProtectionDomain().getCodeSource().getLocation().getPath();//String parar o endereco da imagem padrao
        this.enderecoDiretoriopath = new File(".").getAbsolutePath();//String parar o endereco da imagem padrao
        this.imagemIconePadrao = "src\\ImagensAuxiliares\\IconePadrao.png";//String parar o endereco da imagem padrao
        this.diretorioCartas = "src\\ImgensCartas\\";//String parar o endereco da imagem padrao
        this.arrayListCartas = new ArrayList<>();//String parar o endereco da imagem padrao
        this.arrayListaCartasEmJogo = new ArrayList<>();//Array parar listar as cartas que estão em jogo
        this.arrayPossibilidadeCartaJogo = new ArrayList<>();//Array que armazena os movimento
        this.arrayMemoriaComputador = new ArrayList<>();//Array para memorizar as cartas
        this.opcaoEscolhaComputador = false;//opcao escolhida pelo cpmpputador
        this.boolComparando = false;//Flag para verificar se ha comparacao
        this.totalCartas = 16; //Inicializa com quantidade de cartas presente no jogo
        this.levelMemoria = 3; //número de movimentos lembrados pelo computador
        this.flagFinalJogo = 0;//Flag para controlar final do jogo
        this.contadorJogadasAcertadasComputador = 0;//Flag para contar o número de acertos feito pelo computador
        this.contadorJogadasAcertadasJogador = 0;//Flag para contar o número de acertos feito pelo jogador
        this.segundaEscolha = -1;//Flag para marcar segunda escolha
        this.primeiraEscolha = -1;//Flag para marcar primeira escolha
        this.flagStatusMostrarOculta = 0;//Flag para mostrar statusFinal
        this.controlaMemoriaComputador = 0;//Flag para controlar a memoria do omputador
        this.listaBotoes = new JButton[totalCartas]; //Array de botoes que serpa usado para armazenar as imagens das cartas
        //Modificando configuracao da janela
        this.setTitle("Jogo da Memória"); //Modifica o titulo da janela
        this.setLayout(null); //Deixa os componetes independetes para poder possicionar os demais com setBounds
        this.setSize(530,570); //Modifica o tamanho da tela
        this.setLocationRelativeTo(null); //Deixa a janela centralizada
        this.setResizable(false); //Não permite redimensionamento 
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //habilita o botao para fechar a janela
        enderecoDiretoriopath = enderecoDiretoriopath.substring(0, enderecoDiretoriopath.length()-1); //Pega o endereço menos o o ultmi caracter
        //For utilizado para inicializar os botoes presente no array listabotoes
        for(int i=0;i<totalCartas;i++){   
            listaBotoes[i]= new JButton(); //Intanciado cada botao indice a indice
            listaBotoes[i].setIcon(new ImageIcon(enderecoDiretoriopath+ imagemIconePadrao)); //Adiciona a imagem da carta no botao com auxilio dos enderecos pegos nas variaveis strings
            this.add(listaBotoes[i]); //Adiciona o botao ao jFrame
            listaBotoes[i].setVisible(true); //Deixa ele visivel
            listaBotoes[i].setEnabled(true); //E deixa habilitado para clique
        }       
        //Posicionamento dos botoes com o auxilio do setBounds, após desabilitar o layout do jframe
        listaBotoes[0].setBounds(40,40,100,100);  
        listaBotoes[1].setBounds(160,40,100,100);
        listaBotoes[2].setBounds(280,40,100,100); 
        listaBotoes[3].setBounds(400,40,100,100);
        listaBotoes[4].setBounds(40,160,100,100);
        listaBotoes[5].setBounds(160,160,100,100);
        listaBotoes[6].setBounds(280,160,100,100);
        listaBotoes[7].setBounds(400,160,100,100);
        listaBotoes[8].setBounds(40,280,100,100);
        listaBotoes[9].setBounds(160,280,100,100);
        listaBotoes[10].setBounds(280,280,100,100);
        listaBotoes[11].setBounds(400,280,100,100);
        listaBotoes[12].setBounds(40,400,100,100);
        listaBotoes[13].setBounds(160,400,100,100);
        listaBotoes[14].setBounds(280,400,100,100);
        listaBotoes[15].setBounds(400,400,100,100);
        //recebe novamente o diretorio das cartas
        arrayListCartas = listaCartasObjeto.listagemArquivo(enderecoDiretoriopath + diretorioCartas);
        //comando usado para embaralhar o conteudo do vetor
        Collections.shuffle(arrayListCartas);
        //Adiciona o vetor embaralhado parar o vetor ArrayListaCartasEmJogo
        for(int i =0; i < totalCartas/2 ; i++){
            arrayListaCartasEmJogo.add(arrayListCartas.get(i));
            arrayListaCartasEmJogo.add(arrayListCartas.get(i));
        } 
        //Embaralhanovamente para não ficar bem misturado
        Collections.shuffle(arrayListaCartasEmJogo);  
        temporizadorInicialCriacaoDeImgens(); //temporizador iniciar do jogo
        memoriaComputador(); //Inicializa a memoria do computador com o inicio do jogos
        timerDeComparacao = new Timer(2300, new SegundaTelaJogoMemoria.TemporizadorInicial());  
    }
    
    @Override //implementação do actionPerformed para executar quando ouver clique
    public void actionPerformed(ActionEvent e) {   
        for (int i = 0; i < listaBotoes.length; i++) { //Verifica qual botao foi cliacado
            if (e.getSource() == listaBotoes[i]) { //pegando o evento do botao
                if(boolComparando == false){  
                    exibeEscolhas(i); //Exibe as iamgem presente onde occoreu o clique
                    comparaEscolhas(); //Compara se são imagens iguais
                    timerDeComparacao.restart();  //temporizador para reinciar
                }
            }
       }
    } 
    //função de temporização de criação de iamgens nos botoes
    private void temporizadorInicialCriacaoDeImgens() { 
    timer = new Timer(1200, new SegundaTelaJogoMemoria.TemporizadorInicial()); //Timer de espera para inciar
    //Starta o cronometro
    timer.start();//Tamer iniciado
    timerExibicao = new Timer((400*totalCartas), new SegundaTelaJogoMemoria.TemporizadorInicial()); //Timer de esperar para exibição total
    //Starta o cronometro 
    timerExibicao.start();
            
    }
    //Temprozador para controlar quem joga e ações definidas
    public class TemporizadorInicial implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {  
            if(flagStatusMostrarOculta == 0){ //Quando a flag é inciada temos o valor 1,Sendo assim mostramos as imagens e alteramos seu valor
                mostraImagens(); 
                flagStatusMostrarOculta = 1;
            }else if(flagStatusMostrarOculta ==1){//Quando a flag é 1, temos o fechamento das cartas novamente
                retornaImagensPadrao();           //modificamos para o valor 2
                flagStatusMostrarOculta = 2; 
            }
            timer.stop(); //Fazemos a parada do tempo
            if(flagStatusMostrarOculta == 2){        
                timerExibicao.stop(); //Tempos de exibição é parado;
            }   
            if(flagStatusMostrarOculta == 2 || flagStatusMostrarOculta == 5){ //Fazemos a verficação se o jogo acabou nesses casos, caso n tenha nehuna carta ativa ou tempos sem movimentos
                verificarFinalDoJogo();  
            }
            if(flagStatusMostrarOculta == 3){   //Flag igual a 3, temos a escolhaOcutla para o pc
                flagStatusMostrarOculta =  4;  //Modificamos a flag para 4
                ocultaEscolhaErrada();  //Primeiro escolha sem memoria para o computador  
            }
            //Computador
            if(flagStatusMostrarOculta == 5){ //Flag igual a 5
                verificaPossibilidadeJogadasComputador(); //faz a verificação dos movimentos possiveis
                sorteiaPossibilidadeJogadasComputador(); //Sorteia os movimentos
                escolhePossibilidadeJogadasComputador(); //Escolhe a jogada a ser feita
            }
            if(flagStatusMostrarOculta == 6){ //Flag igual a 6
                exibeEscolhasComputador(); //Exibe as escolhas do computador
                comparaEscolhasComputador(); // Compara se as escolhas estão certas;
            }
            if(flagStatusMostrarOculta == 7){ //Flag igual a 7
                ocultaEscolhaErradaComputador();  //Oculta escolhas erradas feitas pelo pc
            } 
            if(flagStatusMostrarOculta == 6){ //flag = 6
                flagStatusMostrarOculta = 7; //modifica para 7 novamante;
            }
        }
    }
    //Função para mostrar as imagens
    public void mostraImagens() {
        for(int i=0;i<totalCartas;i++){   //Preenche o vetor botoes com as imagens embaralhadas e mostra na tela 
            listaBotoes[i].setIcon(new ImageIcon(arrayListaCartasEmJogo.get(i)));
        }
    }
    //faz a inicialização dos botões na tela com a imagem padrão e adiciona ações aos botões
    public void retornaImagensPadrao() {
            //cria botao por botao e seta na tela
        for(int index=0;index<totalCartas;index++){   
            listaBotoes[index].setIcon(new ImageIcon(enderecoDiretoriopath+ imagemIconePadrao));
            //seta a action para os botoes
            listaBotoes[index].addActionListener(this);  
       }
    }
    //Exibe as escolhas feitas
    public void exibeEscolhas(int i) {
        if(primeiraEscolha == -1){ //Primeira escolha
            primeiraEscolha = i;
            listaBotoes[primeiraEscolha].setIcon(new ImageIcon(arrayListaCartasEmJogo.get(primeiraEscolha)));
        }else if(primeiraEscolha != -1 && primeiraEscolha != i){
            segundaEscolha = i; //Segunda escolha
            listaBotoes[segundaEscolha].setIcon(new ImageIcon(arrayListaCartasEmJogo.get(segundaEscolha)));
        }
    }
    //Faz comparação das escolhas
    public void comparaEscolhas(){
        //se ambas as escolhas são diferentes de -1 temos duas escolhas realizadas
        if(primeiraEscolha != -1 && segundaEscolha != -1){
            boolComparando = true; //E feito a comáração delas para ver se são semelhantes as imagens
            if(listaBotoes[primeiraEscolha].getIcon().toString().equals(listaBotoes[segundaEscolha].getIcon().toString()) && primeiraEscolha != segundaEscolha){
                listaBotoes[primeiraEscolha].setEnabled(false); //Desabilita se n forem iguasi
                listaBotoes[segundaEscolha].setEnabled(false); //Desabilita se forem iguasi
                contadorJogadasAcertadasJogador ++; //Soma pares eonctrados pelo jogador 
                primeiraEscolha = -1; //Reinicia as variaveis com o valor -1
                segundaEscolha = -1;
                flagStatusMostrarOculta = 2; //Modifica o estatus para dois novamente  
                boolComparando = false; //E seta o booleando para falso novamente
            }else{
                flagStatusMostrarOculta = 3; //Se n forem iguais oculta as cartas novamnte e reinicia o tempo
                timerDeComparacao.restart();
            }
        }   
    }
    //Caso a escolha seja errada oculta novamente as cartas 
    public void ocultaEscolhaErrada() {
            opcaoEscolhasComputadorAleatorias();
            if(flagStatusMostrarOculta == 4){ 
                listaBotoes[primeiraEscolha].setIcon(new ImageIcon(enderecoDiretoriopath+ imagemIconePadrao)); 
                listaBotoes[segundaEscolha].setIcon(new ImageIcon(enderecoDiretoriopath+ imagemIconePadrao));
                primeiraEscolha = -1;
                segundaEscolha = -1;
                flagStatusMostrarOculta = 5;
                boolComparando = false;
            }
    }
    //Verifica final do jogo
    public void verificarFinalDoJogo() {
        int contadorFinal = 0;
        for(int i =0; i < totalCartas; i++){
            if(!listaBotoes[i].getIcon().toString().equals(enderecoDiretoriopath + imagemIconePadrao)){
                contadorFinal ++;
            } 
            if(totalCartas == contadorFinal){
                String vencedor = null;
                MensagemPontuacao resultado = new MensagemPontuacao(); 
                vencedor = resultado.vencedorJogo(contadorJogadasAcertadasJogador, contadorJogadasAcertadasComputador);

                flagStatusMostrarOculta = 8;
                int resp = JOptionPane.showConfirmDialog(null, vencedor+"\nJogador: " +contadorJogadasAcertadasJogador+" Pontos\nComputador: "+contadorJogadasAcertadasComputador+" Pontos \n","Resultado - Reiniciar?",  JOptionPane.INFORMATION_MESSAGE);
                if (resp == JOptionPane.YES_OPTION) {  
                    this.dispose();
                    new TelaInicial().setVisible(true);  
                }else{
                    this.dispose();
                }  
            }
        }
    }
    //Computador 
    //Verifica as possibilidades de jogadas para o computador
    public void verificaPossibilidadeJogadasComputador(){
        boolComparando = true;
        arrayPossibilidadeCartaJogo.clear(); //Verifica quais são as cartas validas parar escolher
        for(int i =0; i< arrayListaCartasEmJogo.size(); i++){
            if(!arrayListaCartasEmJogo.get(i).equals(listaBotoes[i].getIcon().toString()) 
                && (listaBotoes[i].getIcon().toString().equals(enderecoDiretoriopath+ imagemIconePadrao))
                && listaBotoes[i].isEnabled()){  
                arrayPossibilidadeCartaJogo.add(i);
            }
        }
    }
    //Memorização das cartas 
    private void memoriaComputador(){
        int Indice = 0;
        int indiceInicialValor = 0;
        for(int i =0; i < totalCartas; i++ ){ //Iniciliza o vetor de memória com vazio
            arrayMemoriaComputador.add("");
        }
        //Faz a escolha enquanto não atigir o limite de memoria
        while(Indice <  levelMemoria){
            indiceInicialValor = (int) (Math.random()* totalCartas ); //sorteia um valor entre 0 e 15
            if(arrayMemoriaComputador.get(indiceInicialValor).equals("")){ //Verifica se é igual a nulo
                Indice++; //Indice recebe mais um
            }//Seta quais cartas estão em jogo na memoria apartir do indice e do valor randomico para escolha
            arrayMemoriaComputador.set(indiceInicialValor , arrayListaCartasEmJogo.get(indiceInicialValor));
        }
    }
    //Sorteia qual serpa a jogada feita pelo computador
    public void sorteiaPossibilidadeJogadasComputador(){
        Collections.shuffle(arrayPossibilidadeCartaJogo);   
    }
    //Escolhe possibilidadeDejogadasRealizadasPeloComputador comparado quaiss são as possiveis soluções
    public void escolhePossibilidadeJogadasComputador(){
        opcaoEscolhaComputador = false;
        for(int index1 =0; index1 < totalCartas; index1++){
            for(int index2 =  index1 +1; index2 < totalCartas; index2++){
                //verifica se a opcao escolhida pelo computador é valida
                for(int index3 =0; index3 < arrayPossibilidadeCartaJogo.size(); index3++){
                    for(int index4 =index3 +1; index4 < arrayPossibilidadeCartaJogo.size(); index4++){
                        if((arrayMemoriaComputador.get(index1).equals(arrayMemoriaComputador.get(index2)) 
                            && index1 != index2  && opcaoEscolhaComputador == false) && 
                            (!arrayMemoriaComputador.get(index1).equals("") && !arrayMemoriaComputador.get(index2).equals(""))
                            && index1 == arrayPossibilidadeCartaJogo.get(index3) && index2 == arrayPossibilidadeCartaJogo.get(index4)){
                                primeiraEscolha = index1;
                                segundaEscolha = index2;
                                opcaoEscolhaComputador = true; //Quando consegue realizar duas escolhas validas
                                flagStatusMostrarOculta = 6;
                                break; 
                        }
                    }
                }

            }
        } 
        if(opcaoEscolhaComputador == false){ //Quando não tem escolhas validas na memoria
            primeiraEscolha = arrayPossibilidadeCartaJogo.get(0); //Pega as duas primeiras possibilidades do array
            segundaEscolha = arrayPossibilidadeCartaJogo.get(1);   
            opcaoEscolhaComputador = true;
            flagStatusMostrarOculta = 6;
         }
    } 
    //metodo criado para exibir quais sao es escolhas realizadas pelo computador
    public void exibeEscolhasComputador() {
        listaBotoes[primeiraEscolha].setIcon(new ImageIcon(arrayListaCartasEmJogo.get(primeiraEscolha)));
        listaBotoes[segundaEscolha].setIcon(new ImageIcon(arrayListaCartasEmJogo.get(segundaEscolha)));
    }
    //Compara as escolhas realizadas paeli computador
    public void comparaEscolhasComputador(){
        if(primeiraEscolha !=-1 && segundaEscolha !=-1){

            if(listaBotoes[primeiraEscolha].getIcon().toString().equals(listaBotoes[segundaEscolha].getIcon().toString()) && primeiraEscolha != segundaEscolha){
                listaBotoes[primeiraEscolha].setEnabled(false);
                listaBotoes[segundaEscolha].setEnabled(false);
                contadorJogadasAcertadasComputador  ++;

                primeiraEscolha = -1;
                segundaEscolha = -1;
                flagStatusMostrarOculta = 5; 
            }else{
                flagStatusMostrarOculta = 6;
                timerDeComparacao.restart();
            }
        }
    }
    //Oculta caso Escolha seja errada
    public void ocultaEscolhaErradaComputador() {
        opcaoEscolhasComputadorAleatorias(); 
        if(flagStatusMostrarOculta == 7){ 
            listaBotoes[primeiraEscolha].setIcon(new ImageIcon(enderecoDiretoriopath+ imagemIconePadrao)); 
            listaBotoes[segundaEscolha].setIcon(new ImageIcon(enderecoDiretoriopath+ imagemIconePadrao)); 
            primeiraEscolha = -1;
            segundaEscolha = -1;
            boolComparando = false;
            flagStatusMostrarOculta = 2;
        }
    } 
    //Gera escolhas aletarioas para o computador caso não tenha opções validas
    public void  opcaoEscolhasComputadorAleatorias(){    
        arrayMemoriaComputador.set(primeiraEscolha , arrayListaCartasEmJogo.get(primeiraEscolha));
        arrayMemoriaComputador.set(segundaEscolha , arrayListaCartasEmJogo.get(segundaEscolha));
    }

} 