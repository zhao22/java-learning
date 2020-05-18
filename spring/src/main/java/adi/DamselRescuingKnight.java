package adi;


/**
 * 由于这类骑士在构造时固定创建了营救少女任务，和这个任务耦合度过高。不能进行其他任务
 */
public class DamselRescuingKnight implements Knight{

    // 营救少女任务
    private RescueDamselQuest quest;

    public DamselRescuingKnight() {
        // 与RescueDamselQuest 紧耦合
        this.quest = new RescueDamselQuest();
    }

    public void embarkOnQuest() {
        quest.embark();
    }
}
