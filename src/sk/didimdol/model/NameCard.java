package sk.didimdol.model;

import java.io.Serializable;

public class NameCard implements Comparable<NameCard>, Serializable {

	private static final long serialVersionUID = 8214066939748840364L;
	private int id;
	private String name;
	private String email;
	private int age;
//	public NameCard() {
//		super();
//	}
	public NameCard(int id, String name, String email, int age) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.age = age;
	}
	public NameCard(String name, String email, int age) {
		super();
		this.name = name;
		this.email = email;
		this.age = age;
	}
	public NameCard(String name, int age) {
		this(name, null, age);
	}
	public NameCard() {
		this("����", 0);
		//System.out.println("3");
	} //NameCard card = new NameCard();�� ��������� �� ������ ���� ������?
	//23 -> 24 -> 17 -> 18 -> 10 -> 11,12,13,14,15 -> 19,20,21 -> 25
	
	public int compareTo(NameCard other) {
		return this.email.compareTo(other.getEmail());
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void printNameCardInfo() {
		System.out.println("[�̸�: " + name + "\t" +
							"�̸���: " + email + "\t" +
							"���� : " + age + "]");
	}
}
/*
1��� �� ������ �����Ϸ���
NameCard card = new NameCard();
card.name = "ȫ�浿";
card.email = "hong@hong.com";
card.age = 30;

vs.

NameCard card = new NameCard("ȫ�浿", "hong@hong.com", 30);

*/