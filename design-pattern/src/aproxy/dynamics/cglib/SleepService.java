package aproxy.dynamics.cglib;

public class SleepService{

	public void handle(long times) {
		System.out.println("sleeping ...");
		try {
			Thread.sleep(times);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public long handleAndReturn(long times) {
		System.out.println("sleeping ...");
		try {
			Thread.sleep(times);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return times;
	}
}
