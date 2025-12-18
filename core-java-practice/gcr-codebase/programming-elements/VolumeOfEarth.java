

public class VolumeOfEarth {
	public static void main(String[] args) {
		double earthRadiusKm = 6378;
		double earthRadiusMiles = earthRadiusKm/1.6;
		double volumeKm = (4.0 / 3.0) * Math.PI * Math.pow(earthRadiusKm, 3); 
		double volumeMiles = (4.0 / 3.0) * Math.PI * Math.pow(earthRadiusMiles, 3); 
		System.out.println("Eath volume of earth in cubic kilometer is " + volumeKm + " and cublic miles is " + volumeMiles);
	}
}
