package entity;

public class User {

	private String name;
	private String nickName;
	private int age;
	public String school;
	
	public  int addAge(Integer num){
		age += num;
		return age;
	}
	
	public String getName() {
		return name;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public String toString(){
		return new StringBuilder()
					.append("( name=")
					.append(this.name)
					.append(" nickName=")
					.append(this.nickName)
					.append(" age=")
					.append(this.age)
					.append(" school=")
					.append(this.school)
					.append(")")
					.toString();				
	}
	
}
