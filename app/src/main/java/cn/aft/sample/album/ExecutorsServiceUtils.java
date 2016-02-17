package cn.aft.sample.album;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import cn.aft.tools.Predictor;

public class ExecutorsServiceUtils {

    private static final int MAX_EXECUTE_AMOUNT = 1;

    private static ExecutorService service = Executors.newFixedThreadPool(MAX_EXECUTE_AMOUNT);

    private static Set<Object> tagSet = new HashSet<Object>();

    /**
     * Execute nothing when tag is null
     *
     * @param tag flag the execute entity to avoid execute double
     */
    public static void startExecutorThread(Runnable entity, Object tag) {
        if (Predictor.isNull(entity) || Predictor.isNull(tag)) {
            return;
        }
        if (service.isShutdown()) {
            service = Executors.newFixedThreadPool(MAX_EXECUTE_AMOUNT);
        }
        if (tagSet.add(tag)) {
            service.execute(entity);
        }
    }

    /**
     * Invoke when execute entity finished
     */
    public static void removeExecuteEntity(Object tag) {
        tagSet.remove(tag);
    }

    public static void stopAllExecutors() {
        service.shutdown();
    }
}
