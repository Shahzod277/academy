package uz.jurayev.academy.hemis_api;

import uz.jurayev.academy.rest.StudentInfoDto;

@lombok.Data
public class Data {

	private String code;
	private StudentInfoDto studentInfo;
	private Boolean success;
}
