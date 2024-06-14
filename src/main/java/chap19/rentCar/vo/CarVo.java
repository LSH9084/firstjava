package chap19.rentCar.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Builder
@AllArgsConstructor
@Data
@NoArgsConstructor

public class CarVo {
	private String car_num;
	private String car_name;
	private String car_color;
	private int car_size;
	private String car_made;
}
