package interfaces;

public interface GasolineFueled {
	public static final double REGULAR_GAS = 1.0;
	public static final double SUPER_GAS = 0.8;

	public boolean fuelGas(char g);
}