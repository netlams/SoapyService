package objects;

import interfaces.ElectricFueled;

public class ElectricFueledImp extends Car implements ElectricFueled {
	public ElectricFueledImp() {
		super();
	}

	@Override
	public boolean chargeEnergy() {
		
		this.fuelAmount+=1.0;
		return true;
	}
}