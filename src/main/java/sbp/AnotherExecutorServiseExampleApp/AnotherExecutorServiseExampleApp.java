package sbp.AnotherExecutorServiseExampleApp;

import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.*;

public class AnotherExecutorServiseExampleApp {

    private List<Callable<Boolean>> taskCollection;
    private int nThreads;

    /**
     * Получаем коллекцию с персонажем и количество потоков
     * @param taskCollection
     * @param nThreads
     */
    public AnotherExecutorServiseExampleApp(List<Callable<Boolean>> taskCollection, int nThreads) {
        this.taskCollection = taskCollection;
        this.nThreads = nThreads;
    }

    /**
     * Добавляем персонажа в таблицу в новом потоке
     * @return
     */
    public boolean ExecutorService() {
        ExecutorService executorService = Executors.newFixedThreadPool(nThreads);
        try {

            List<Future<Boolean>> futureList = executorService.invokeAll(taskCollection);

            for (int a = 0; a < futureList.size(); a++) {
                futureList.get(a).get();
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return true;
    }


}






