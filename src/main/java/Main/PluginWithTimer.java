package Main;

import Interfaces.TSProvider;
import Interfaces.TestSummary;
import core.ConcreteTS;

import java.util.*;

public class PluginWithTimer extends TSProvider {
    public PluginWithTimer() {
        super();
        initTimer();
    }
    @Override
    public TestSummary getTS(String userStory) {
        return new ConcreteTS(randomTest());
    }
    private void initTimer(){
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                try {
                    notifyNewChanges(randomTest());
                }
                catch(NullPointerException e){
                    System.out.println("---\nEl observer de TSProvider no esta inicializado aun.\n---");
                    e.printStackTrace();
                }
            }
        }, new Date(), 10000);
    }
    private Map<String, Boolean> randomTest(){
        Map<String, Boolean> ret = new HashMap<>();
        Random r = new Random();
        for (int i = 0; i < 5; i++) {
            ret.put("US"+i, r.nextBoolean());
        }
        return ret;
    }

}
