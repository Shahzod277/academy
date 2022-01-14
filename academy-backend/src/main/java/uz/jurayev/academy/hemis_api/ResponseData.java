package uz.jurayev.academy.hemis_api;

import uz.jurayev.academy.rest.StudentInfoDto;

public class ResponseData {
	private String code;
	private StudentInfoDto studentInfo;
	private Boolean success;

	public void setCode(String code){
		this.code = code;
	}

	public String getCode(){
		return code;
	}

	public void setData(StudentInfoDto studentInfo){
		this.studentInfo = studentInfo;
	}

	public StudentInfoDto getData(){
		return studentInfo;
	}

	public void setSuccess(Boolean success){
		this.success = success;
	}

	public Boolean isSuccess(){
		return success;
	}
}
