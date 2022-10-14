package edu.kh.jsp.model.vo;

public class Person {
	private String name; 
	private int age; //캡슐화 직접적인 접근을 막기위해
	private String address;
	
	public Person() {} // 기본생성자 
	
	
	public Person(String name, int age, String address) {
		super();
		this.name = name;
		this.age = age;
		this.address = address;
	}


	// getter/ setter 
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	public int getAge() {
		return age;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAddress() {
		return address;
	}
	
	// Object.toString() 오버라이딩
	@Override
	public String toString() {
		return name + " / " + age + " / " + address;
	}
	
}
