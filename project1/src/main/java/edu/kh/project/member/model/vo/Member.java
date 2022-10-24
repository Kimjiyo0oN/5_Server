package edu.kh.project.member.model.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor  // *기본생성자
@AllArgsConstructor // 매개변수 
@Getter 			// *모든 필드의 Getter
@Setter             // *모든 필드의 Setter
@ToString 			// toString() 오버라이딩
public class Member {
	/*
	 * CREATE TABLE "MEMBER" ( "MEMBER_NO" NUMBER NOT NULL, "MEMBER_EMAIL"
	 * VARCHAR2(50) NOT NULL, "MEMBER_PW" VARCHAR2(100) NOT NULL, "MEMBER_NICKNAME"
	 * VARCHAR2(30)NOT NULL, "MEMBER_TEL" CHAR(11) NOT NULL, "MEMBER_ADDRESS"
	 * VARCHAR2(300) NULL, "PROFILE_IMG" VARCHAR2(300) NULL, "ENROLL_DATE" DATE
	 * DEFAULT SYSDATE NOT NULL, "MEMBER_DEL_FL" CHAR(1) DEFAULT 'N' NOT NULL,
	 * "AUTHORITY" NUMBER DEFAULT 1 NOT NULL );
	 */
	private int memberNo;
	private String memberPw;
	private String memberTel;
	private String memberEmail;
	private String memberNickname;
	private String memberAddress;
	private String profileImage;
	private String enrollDate;
	private String memberDeleteFlag;
	private int authority;
}
