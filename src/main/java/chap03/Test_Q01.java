package chap03;

public class Test_Q01 {

	public static void main(String[] args) {
		int sum = 0;
		int cnt =1;
		while(true) {
			sum += cnt;
			if(sum>=1000){
				break;
			}
			cnt ++;
		}
		System.out.println("최초로 1000이상이 되게 하는 자연수는 "+cnt);
		System.out.println("1에서 "+cnt+"까지의 합은 : "+sum);
		

	}

}
