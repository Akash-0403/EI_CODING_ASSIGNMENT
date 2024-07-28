import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class Scheduler {
    private Timer timer;

    public Scheduler() {
        timer = new Timer();
    }

    public void scheduleTask(Runnable task, long delay, TimeUnit unit) {
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                task.run();
            }
        }, unit.toMillis(delay));
    }

    public void shutdown() {
        timer.cancel();
    }
}
