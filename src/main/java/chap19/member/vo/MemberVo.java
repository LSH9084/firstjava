package chap19.member.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class MemberVo {
	private String Id;
	private String ps;
	private String name;
	private String address;
	private String p_number;
//	private static String checkId;
}
