package pluginsImpl;

import core.DecoratorTestSummary;
import core.TestSummary;

import java.util.*;

public class PluginWithTimer extends DecoratorTestSummary {
    public PluginWithTimer(TestSummary s) {
        super(s);
        initTimer();
    }
    @Override
    public TestSummary update(Map<String, Boolean> m) {
        return super.ts.update(m);
    }
    private void initTimer(){
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("Hola");
                update(randomTest());
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
