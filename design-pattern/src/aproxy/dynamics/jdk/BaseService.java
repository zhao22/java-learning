package aproxy.dynamics.jdk;

public interface BaseService {

	void handle(long times);
		
	long handleAndReturn(long times);
}
