package com.thread;

public class Thread1 extends Thread {

	private Object lock = new Object();
	private int row;
	private String symbol;

	public Thread1(Object lock, int row, String symbol) {
		super();
		this.lock = lock;
		this.row = row;
		this.symbol = symbol;
	}

	public void run() {
		int i;
		synchronized (lock) {
			for (i = 0; i < row; i++) {
				lock.notify();
				for (int j = row; j >= i; j--) {
					System.out.print(" ");
				}

				for (int k = 0; k <= i; k++) {
					System.out.print(symbol + " ");
				}
				System.out.println();
				try {
					Thread.sleep(500);
					lock.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

}