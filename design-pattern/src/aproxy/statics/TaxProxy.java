package aproxy.statics;

public class TaxProxy implements IStaff{

    private IStaff staff;

    TaxProxy(IStaff staff) {
        this.staff = staff;
    }

    @Override
    public void receiveWages(Double wages) {
        System.out.println("========扣除税费=========");
        System.out.println("扣除税费:" + wages * 0.1);
        System.out.println("========扣除税费=========");
        staff.receiveWages(wages * 0.9);
    }
}
