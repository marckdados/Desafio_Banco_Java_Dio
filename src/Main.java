public class Main {
    public static void main(String[] args) {
        Cliente bismarck = new Cliente("Bismarck", "710000000");
        ContaCorrente cc = new ContaCorrente(bismarck);
        ContaPoupanca cp = new ContaPoupanca(bismarck);

        cc.depositar(55);
        cc.transferir(cp,30);
        cc.imprimirExtrato();
        cp.imprimirExtrato();
    }
}
