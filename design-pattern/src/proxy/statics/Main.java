package proxy.statics;

public class Main {

    private static IStaff workerWithoutTax = new Worker();

    private static IStaff workerWithTax = new TaxProxy(workerWithoutTax);

    public static void main(String[] args) {
        double wages = 5000;
        workerWithoutTax.receiveWages(wages);
        workerWithTax.receiveWages(wages);
    }
}
