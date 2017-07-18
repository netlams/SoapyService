package objects;

import interfaces.GasolineFueled;

public class GasolineFueledImp extends Car implements GasolineFueled {
	public GasolineFueledImp() {
		super();
	}

	@Override
	public boolean fuelGas(char g) {
		if (g == 'R') {
			this.fuelAmount+=GasolineFueled.REGULAR_GAS;
		}
		else {
			this.fuelAmount+=GasolineFueled.SUPER_GAS;
		}
		return true;
	}
}