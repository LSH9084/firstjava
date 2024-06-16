package chap19.res.vo;

import java.time.LocalDate;

import chap19.member.vo.MemberVo;
import chap19.rentCar.vo.CarVo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class ResVo {
	private String rent_num;
	private LocalDate rent_day;
	private LocalDate rent_start;
	private LocalDate rent_end;
	private String rent_car_num;
	private String rent_id;
//	private MemberVo memVo;
//	private CarVo carVo;
	
	
	public ResVo (String a, LocalDate b, LocalDate c) {
		this.rent_num = a;
		this.rent_start = b;
		this.rent_end = c;
	}

}
