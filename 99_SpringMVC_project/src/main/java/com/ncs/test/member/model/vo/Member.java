package com.ncs.test.member.model.vo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Member
{
	private String memberId;

	private String memberPwd;

	private String memberName;

	private Date memberEnrollDate;
}
