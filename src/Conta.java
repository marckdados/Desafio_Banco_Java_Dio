public abstract class Conta implements  IntefaceConta{

    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;
    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Cliente cliente;

    public Conta(Cliente cliente){
        this.agencia = AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
    }
    private double getSaldo() {
        return saldo;
    }
    @Override
    public void sacar(double valor){
        if(valor <= saldo){
            saldo -= valor;
            System.out.println("Valor sacado com sucesso, valor atual: R$ "+getSaldo());
        }else {
            System.out.println("Seu saldo e insuficiente, pois seu saldo atual e: R$ "+getSaldo());
        }
    }
    @Override
    public void depositar(double valor){
        saldo += valor;
    }
    @Override
    public void transferir(Conta contaDestino, double valor){
        if(valor <= saldo){
            this.sacar(valor);
            contaDestino.depositar(valor);
            System.out.println("Valor transferido com sucesso, valor atual: R$ "+getSaldo());
        }else{
            System.out.println("Seu saldo e insuficiente, pois seu saldo atual e: R$ "+getSaldo());
        }
    }
    protected void imprimirInfosComuns(){
        System.out.println(String.format("Cliente: %s, de CPF (%s)" , this.cliente.nome, this.cliente.cpf));
        System.out.println(String.format("Agencia: %d", this.agencia));
        System.out.println(String.format("Numero: %d", this.numero));
        System.out.println(String.format("Saldo: %.2f", this.saldo));
    }

}
