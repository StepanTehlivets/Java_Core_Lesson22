package ua.academy.lgs;

public class Deputy {
	private String surname;
	private String name;
	private int age;
	private boolean briber;
	private int bribeSize;

	public Deputy(String surname, String name, int age, boolean briber) {
		super();
		this.surname = surname;
		this.name = name;
		this.age = age;
		this.briber = briber;
	}

	public Deputy(String surname, String name) {
		super();
		this.surname = surname;
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Boolean isBriber() {
		return briber;
	}

	public void setBriber(boolean briber) {
		this.briber = briber;
	}

	public int getBribeSize() {
		return bribeSize;
	}

	public void setBribeSize(int bribeSize) {
		this.bribeSize = bribeSize;
	}

	@Override
	public String toString() {
		return "Deputy [surname=" + surname + ", name=" + name + ", age=" + age + ", briber=" + briber + ", bribeSize=" + bribeSize +"]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + bribeSize;
		result = prime * result + (briber ? 1231 : 1237);
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((surname == null) ? 0 : surname.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Deputy other = (Deputy) obj;
		if (age != other.age)
			return false;
		if (bribeSize != other.bribeSize)
			return false;
		if (briber != other.briber)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (surname == null) {
			if (other.surname != null)
				return false;
		} else if (!surname.equals(other.surname))
			return false;
		return true;
	}

	public void giveBribe(int bribeSize) {
		if (!briber) {
			System.out.println("Deputy doesn't take bribes");
		} else {
			if (bribeSize > 5000) {
				System.out.println("Police arrest him");
			} else {
				this.bribeSize = bribeSize;
			}

		}

	}
}

interface DeputyFactory {
	Deputy createDeputy(String surname, String name, int age, boolean briber);
}
