package adi;

/**
 * 这类骑士业务面较广。可以根据创建时参数选择需要执行什么任务。
 */
public class BraveKnight implements Knight{

    private Quest quest;

    public BraveKnight(Quest quest) {
        this.quest = quest;
    }

    public void embarkOnQuest() {
        quest.embark();
    }
}
