package ua.academy.lgs1;



public class Game implements  Comparable<Game>{
		private String name;
		private Integer yearOfRelease;
		
		public Game(String name, int yearOfRelease) {
			this.name=name;
			this.yearOfRelease=yearOfRelease;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getYearOfRelease() {
			return yearOfRelease;
		}

		public void setYearOfRelease(int yearOfRelease) {
			this.yearOfRelease = yearOfRelease;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((name == null) ? 0 : name.hashCode());
			result = prime * result + yearOfRelease;
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
			Game other = (Game) obj;
			if (name == null) {
				if (other.name != null)
					return false;
			} else if (!name.equals(other.name))
				return false;
			if (yearOfRelease != other.yearOfRelease)
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "Game [name=" + name + ", yearOfRelease=" + yearOfRelease + "]";
		}
		@Override
		public int compareTo(Game o) {
			return this.yearOfRelease.compareTo(o.getYearOfRelease());
		}
	}


