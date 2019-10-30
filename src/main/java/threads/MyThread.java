package threads;

public class MyThread implements Runnable {

	int number = 0;

	@Override
	public void run() {
		doStuff();
	}

	public void doStuff() {
		go();
	}

	public void go() {
		doMore();
	}

	public synchronized void increment() {
		int temp = number;
		number = temp + 1;
	}

	public void doMore() {
		System.out.println("New thread!");
		for (int i = 0; i < 100; ++i) {
			increment();
			System.out.println("Inside thread! " + number);
		}
	}

	public static void main(String[] args) {
		while (true) {
			MyThread th = new MyThread();
			Thread t = new Thread(th);
			t.start();
			System.out.println("Continuing with main!");
			for (int i = 0; i < 100; ++i) {
				th.increment();
				System.out.println("Inside main! " + th.number);
			}
		}
	}

}
