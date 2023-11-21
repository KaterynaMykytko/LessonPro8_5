public class Main {
    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i < 20; i++) {

            Object resource1 = new Object();
            Object resource2 = new Object();
            Thread thread1 = new Thread(new Worker1(resource1, resource2));
            Thread thread2 = new Thread(new Worker2(resource1, resource2));

            thread1.start();
            thread2.start();

            thread1.join();
            thread2.join();

        }
    }
}