package adapter.objects;

public class VideoAdapter implements Indicator{

	private HDMIAdaptee adaptee;
	
	public VideoAdapter(HDMIAdaptee adaptee) {
		this.adaptee = adaptee;
	}
	
	@Override
	public void showUseVGA() {
		adaptee.outputUseHDMI();
		System.out.println("适配器接口转换中...");
		System.out.println("转换为VGA线输出");
	}
	
}
