package adi;

import java.io.PrintStream;

/**
 * 使用Spring 配置文件进行装配
 */
public class SlayDragonQuest implements Quest{

    private final PrintStream stream;

    public SlayDragonQuest(PrintStream stream) {
        this.stream = stream;
    }

    public void embark() {
        stream.println("Embarking on quest to slay the dragon!");
    }
}
