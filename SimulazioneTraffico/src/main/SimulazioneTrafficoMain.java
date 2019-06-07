package main;

public class SimulazioneTrafficoMain {
	public static void main(String[] args) {
		Strada strada=new Strada(4,10);
		System.out.println(strada);
		strada.avanza();
		System.out.println(strada);
	}
}
