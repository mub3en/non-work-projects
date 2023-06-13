//  GrazingMammals.java
interface RuminantTester {
	// Add your code here
	void testIfRuminant();

	void testHasMultipleStomachs();
}

abstract class Mammal {
	// Add your code here

	public void nursesYoung() {
		String className = this.getClass().getSimpleName();
		System.out.println("I am a " + className + ". I am nursing.");
	}
}

abstract class GrazingMammal extends Mammal implements RuminantTester {
	// Add your solution here
	

	public void grazes() {
		String className = this.getClass().getSimpleName();
		System.out.println("I am a " + className + ". I am grazing.");
	}

	@Override
	public void testIfRuminant() {
		String className = this.getClass().getName();
		if (this instanceof Ruminant)
			System.out.println("I am a " + className + ". I am a Ruminant.");
		else
			System.out.println("I am a " + className + ". I am not a Ruminant.");
	}

	@Override
	public void testHasMultipleStomachs() {
		String className = this.getClass().getName();
		if (this instanceof Ruminant)
			System.out.println("I am a " + className + ". I have multiple stomachs.");
		else
			System.out.println("I am a " + className + ". I do not have multiple stomachs.");
	}

}

abstract class Ruminant extends GrazingMammal {
	// Add your code here
	public void chewsCud() {
		String className = this.getClass().getSimpleName();
		System.out.println("I am a " + className + ". I am chewing cud.");
	}
}

class Cow extends Ruminant {
}

class Goat extends Ruminant {
}

class Horse extends GrazingMammal {
}


public class TestingMammals {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cow cow = new Cow();
        cow.nursesYoung(); 
        cow.grazes(); 
        cow.chewsCud();
        cow.testIfRuminant();
        cow.testHasMultipleStomachs();
        System.out.println("\n"); 
        Goat goat = new Goat();
        goat.nursesYoung(); 
        goat.grazes(); 
        goat.chewsCud();
        goat.testIfRuminant();
        goat.testHasMultipleStomachs();
        System.out.println("\n"); 
        Horse horse  = new Horse();
        horse.nursesYoung(); 
        horse.grazes(); 
        horse.testIfRuminant();
        horse.testHasMultipleStomachs();
        

	}

}
