package chap13.pra;

import java.util.ArrayList;
import java.util.List;

public class StreamParallel {
	public static void main(String[] args) {
		
		List<Integer> list = new ArrayList<Integer>();
		
		for(int i=0; i<100; i++) {
			list.add(i);
		}
		long start = System.nanoTime();
		list.stream().forEach(x->{
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		});
		
		long end = System.nanoTime();
		System.out.println((end-start));
		
		list.stream().parallel().forEach(x->{
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
				// TODO: handle exception
			}
		});
		end = System.nanoTime();
		System.out.println((end-start));
	
		
	}
}
