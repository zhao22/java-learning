package decorator;

public class ClickDecorator implements EventDecorator{

	private Element element;
	
	public ClickDecorator(Element element) {
		this.element = element;
	}
	
	@Override
	public String getName() {
		return "添加了点击事件的" + element.getName();
	}
	
	
	@Override
	public void onEvent() {
		System.out.println(element.getName() + "被点击了");
	}

}
