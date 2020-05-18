package baop;

import adi.Knight;
import adi.Quest;

public class BraveKnight implements Knight {

    private Quest quest;


    public BraveKnight(Quest quest) {
        this.quest = quest;
    }

    public void embarkOnQuest() {
//        minstrel.singBeforeQuest();
        quest.embark();
//        minstrel.singAfterQuest();
    }
}
