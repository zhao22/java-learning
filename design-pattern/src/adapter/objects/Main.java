package adapter.objects;

public class Main {

	public static void main(String[] args) {
		Indicator indicator = new VideoAdapter(new HDMIAdaptee());
		indicator.showUseVGA();
	}
}
