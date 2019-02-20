package binding.serializers_deserializers;

public class Cat extends Pet {
    
	private Boolean cuddly;
	
	public Cat() {
		super();
	}
	
	public Cat(String name, int age, Boolean furry, Boolean cuddly) {
		super(name, age, furry);
		this.cuddly = cuddly;
	}

	public Boolean getCuddly() {
		return cuddly;
	}

	public void setCuddly(Boolean cuddly) {
		this.cuddly = cuddly;
	}

	@Override
	public String toString() {
		return "Cat [cuddly=" + cuddly + ", toString()=" + super.toString() + "]";
	}
    
}
