package decorator;

public class Main {

	public static void main(String[] args) {
		EventDecorator clickDecorator = new ClickDecorator(new Button());
	    System.out.println(clickDecorator.getName());
	    clickDecorator.onEvent();
	}
}
