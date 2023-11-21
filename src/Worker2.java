public class Worker2 implements Runnable {

    private final Object resource1;

    private final Object resource2;

    public Worker2(Object resource1, Object resource2) {
        this.resource1 = resource1;
        this.resource2 = resource2;
    }

    @Override
    public void run() {
        System.out.println("Start thread Worker2");

        System.out.println("Worker 2 waiting resource2");
        synchronized (resource2) {
            System.out.println("Worker 2 blocked resource2");
            System.out.println("Worker 2 waiting resource1");
            synchronized (resource1) {
                System.out.println("Worker 2 blocked resource1");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        System.out.println("End thread Worker2");
    }
}
