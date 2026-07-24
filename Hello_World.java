import java.util.*;

class Hello_World {
	public static void main (String[] args){
		Scanner sc = new Scanner(System.in);
		String make = sc.nextLine();
		byte gear = sc.nextByte();
		double engine_size = sc.nextDouble();

		short speed = (short)(gear*20);

		System.out.println("The make of the car is:"+ make);
		System.out.println("The speed of the car is:"+ speed);
		System.out.println("The size of the engine is:"+ engine_size);

		if(engine_size < 1.3){
			System.out.println("The engine of this car is not powerful.");
		}
		else{
			System.out.println("The engine of this car is powerful.");
		}

		switch(gear){
			case 1:
				System.out.println("The speed of the car should be less than 10 mph");
				break;
			case 2:
				System.out.println("The speed of the car should be less than 20 mph");
				break;
			case 3:
				System.out.println("The speed of the car should be less than 30 mph");
				break;
			case 4:
				System.out.println("The speed of the car should be less than 40 mph");
				break;
			case 5:
				System.out.println("The speed of the car should be less than 50 mph");
				break;
			case 6:
				System.out.println("The speed of the car should be less than 60 mph");
				break;
			default:
				System.out.println("Go die fool");
		}

		sc.close();
	}
}