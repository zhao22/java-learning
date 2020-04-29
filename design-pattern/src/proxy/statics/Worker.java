package proxy.statics;

public class Worker implements IStaff{


    @Override
    public void receiveWages(Double wages) {
        System.out.println("==========工人===========");
        System.out.println("工资到账" + wages + "元");
        System.out.println("=======================");
    }
}
