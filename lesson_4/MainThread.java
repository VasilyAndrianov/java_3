package lesson_4;

public class MainThread {
    private static char s =  'A';
    static Object synch =  new Object();

    public static void main(String[] args) {
        new Thread(new printSymbol('A', 'B')).start();
        new Thread(new printSymbol('B', 'C')).start();
        new Thread(new printSymbol('C', 'A')).start();
    }

    static class printSymbol implements Runnable {
        private char currentSymbol;
        private char nextSymbol;

        public printSymbol(char currentSymbol, char nextSymbol) {
            this.currentSymbol = currentSymbol;
            this.nextSymbol = nextSymbol;
        }

        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                synchronized (synch) {
                    try {
                        while (s != currentSymbol)
                            synch.wait();
                        System.out.print(currentSymbol);
                        s = nextSymbol;
                        synch.notifyAll();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        }
    }

}
