package aproxy.statics;

public class Farmer implements IStaff{

    @Override
    public void receiveWages(Double wages) {
        System.out.println("==========农民===========");
        System.out.println("工资到账" + wages + "元");
        System.out.println("=======================");
    }
}
