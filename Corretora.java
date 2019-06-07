import java.util.logging.Level;
import java.util.logging.Logger;


public class Corretora {
    
    private int bitcoin;
    private float preco;
    
    public Corretora(){
        this.bitcoin = 100;
        this.preco = 30761.86f;
    }
    
    public synchronized void comprar() throws InterruptedException
    {
        while(this.bitcoin == 0) wait();
        System.out.println("Corretora vendendo bitcoins...");
        this.bitcoin--;
        this.preco += 30000f;
        Thread.sleep(5000);
        notifyAll();
    }
    
    public synchronized void vender() throws InterruptedException
    {
        while(this.bitcoin == 100) wait();
        System.out.println("Corretora comprando bitcoins...");
        this.bitcoin++;
        this.preco -= 30000f;
        Thread.sleep(5000);
        notifyAll();
    }

    public int getBitcoin() {
        return bitcoin;
    }

    public void setBitcoin(int bitcoin) {
        this.bitcoin = bitcoin;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }
}    