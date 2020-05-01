package adapter.clazz;

public class VideoAdapter extends HDMIAdaptee implements Indicator{

	@Override
	public void showUseVGA() {
		outputUseHDMI();
		System.out.println("适配器接口转换中...");
		System.out.println("转换为VGA线输出");
	}

}
