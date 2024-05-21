package chap06;

import java.util.Scanner;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

public class Class_Q01 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int idx = 0;

		Friend[] fris = new Friend[5];
		fris[idx++] = new Friend("이",60,"010-111-1111");
		fris[idx++] = Friend.builder()
				.name("한")
				.age(25)
				.address("경북")
				.build();
		fris[idx++] = Friend.builder()
				.name("dl")
				.age(205)
				.address("경기도")
				.build();
		
		for(int i=0; i<idx; i++) {
			System.out.println(fris[i]);
		}
		do {
			System.out.print("신상을 알고 싶은 사람 이름 입력ㄱ");
			String in = sc.next();
			
			if("0".equals(in)) {
				System.out.println("종료");
				break;
			} else {
				for (Friend f : fris) {
					if(f.getName().equals(in)) {
						System.out.println(f.toString()+"\n");
					}
				}
			}
			
		} while(true);
		
	}
}
@Data
@AllArgsConstructor
@Builder

class Friend {
	private String name;
	private int age;
	private String address;
}