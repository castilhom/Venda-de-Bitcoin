import java.util.logging.Level;
import java.util.logging.Logger;



public class Investidor extends Thread {
    private String nome;
    private float capital;
    private int bitcoin;
    private Corretora corretora;
    
    public Investidor(String nome, Corretora corretora)
    {
        this.nome = nome;
        this.capital = 1000000f;
        this.bitcoin = 0;
        this.corretora = corretora;
    }
    
    public void comprar() throws InterruptedException
    {
        System.out.println("Investidor " + this.nome + " está  comprando bitcoin");
        this.corretora.comprar();
        this.capital -= corretora.getPreco();
        this.bitcoin++;
        corretora.setPreco(corretora.getPreco() + 30000f);
        System.out.println("Investidor " + this.nome + " possui " + this.bitcoin + " bitcoins");
        System.out.println("Investidor " + this.nome + " possui " + this.capital + " reais de capital");
    }
    
    public void vender() throws InterruptedException
    {
        System.out.println("Investidor " + this.nome + " está  vendendo bitcoin");
        this.corretora.vender();
        this.capital += corretora.getPreco();
        this.bitcoin--;
        corretora.setPreco(corretora.getPreco() - 30000f);
        System.out.println("Investidor " + this.nome + " possui " + this.bitcoin + " bitcoins");
        System.out.println("Investidor " + this.nome + " possui " + this.capital + " reais de capital");
    }
    
    public void regraNegocio() throws InterruptedException
    {
        if(this.bitcoin == 0)
        {
            this.comprar();
        }else if(this.capital >= this.corretora.getPreco())
        {
            this.comprar();
        }else if(this.corretora.getBitcoin() == 0)
        {
            this.vender();
        }else if(this.capital < this.corretora.getPreco() && this.bitcoin > 0)
        {
            this.vender();
        }
    }
    
    @Override
    public void run()
    {
        while(true)
        {
            try {
                this.regraNegocio();
            } catch (InterruptedException ex) {
                Logger.getLogger(Investidor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getCapital() {
        return capital;
    }

    public void setCapital(float capital) {
        this.capital = capital;
    }

    public int getBitcoins() {
        return bitcoin;
    }

    public void setBitcoins(int bitcoin) {
        this.bitcoin = bitcoin;
    }
}