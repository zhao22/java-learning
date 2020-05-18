package adi;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class KnightMain {
    /**
     * main() 方法基于 knights.xml 文件创建了 Spring 应用上下文。
     * 随后它调用该应用上下文获取一个ID为knight的bean。得到Knight 对象的引用后，只需简单调用
     * embarkOnQuest方法就可以执行所赋予的探险任务了。注意这个类完全不知道接收的是哪种探险任务。
     * 只有xml文件知道。
     *
     * @param args
     */
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:/knights.xml");
        Knight knight = context.getBean(Knight.class);
        knight.embarkOnQuest();
        context.close();
    }
}
