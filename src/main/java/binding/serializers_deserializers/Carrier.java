package binding.serializers_deserializers;

import javax.json.bind.annotation.JsonbCreator;

public class Carrier<A extends Pet> {
    public enum TYPE {
        BAG, CRATE, TROLLEY
    }

    private TYPE carrierType;
    private A carriedPet;

    @JsonbCreator
    public Carrier(TYPE carrierType, A carriedPet) {
        this.carrierType = carrierType;
        this.carriedPet = carriedPet;
    }
    
    
    
	public TYPE getCarrierType() {
		return carrierType;
	}

	public void setCarrierType(TYPE carrierType) {
		this.carrierType = carrierType;
	}

	public A getCarriedPet() {
		return carriedPet;
	}

	public void setCarriedPet(A carriedPet) {
		this.carriedPet = carriedPet;
	}
    
}