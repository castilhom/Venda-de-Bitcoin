
public class Main {


    public static void main(String[] args) {
       Corretora corretora = new Corretora();
       Investidor investidor1 = new Investidor("Gabriela", corretora);
       Investidor investidor2 = new Investidor("Milena", corretora);
       
       investidor1.start();
       investidor2.start();
    } 
}