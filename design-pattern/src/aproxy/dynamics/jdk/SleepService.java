package proxy.dynamics.jdk;

public class SleepService implements BaseService{

	@Override
	public void handle(long times) {
		System.out.println("sleeping ...");
		try {
			Thread.sleep(times);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public long handleAndReturn(long times) {
		System.out.println("sleeping ...");
		try {
			Thread.sleep(times);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return times;
	}
}
