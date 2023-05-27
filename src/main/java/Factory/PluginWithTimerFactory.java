package Factory;

import core.Factory;
import core.TestSummary;
import pluginsImpl.PluginWithTimer;

public class PluginWithTimerFactory implements Factory {
    @Override
    public TestSummary createTS(TestSummary ts, String us, String url) {
        TestSummary testSummary = new PluginWithTimer(ts);
        return testSummary;
    }
}
