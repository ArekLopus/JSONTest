package binding.serializers_deserializers;

public class Dog extends Pet {
    
	private Boolean barking;
	
	public Dog() {
		super();
	}
	
	public Dog(String name, int age, Boolean furry, Boolean barking) {
		super(name, age, furry);
		this.barking = barking;
	}

	public Boolean getBarking() {
		return barking;
	}

	public void setBarking(Boolean barking) {
		this.barking = barking;
	}

	@Override
	public String toString() {
		return "Cat [barking=" + barking + ", toString()=" + super.toString() + "]";
	}
    
}
