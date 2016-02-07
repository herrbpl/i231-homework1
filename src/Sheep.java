import java.util.Arrays;

public class Sheep {
	/**
	 * Olgu massiivis juhuslikult läbisegi sikud (goat) ja lambad (sheep).
	 * Koostage võimalikult kiire meetod, mis järjestaks massiivi ümber nii, et
	 * kõik sikud oleksid massiivi alguses ja kõik lambad lõpus. Arvestage ka
	 * piirjuhtumiga, et kõik loomad on üht sorti.
	 * 
	 * An array contains sheep and goats in random order. Write a possibly fast
	 * method to rearrange the array, so that all goats are at the beginning and
	 * all sheep are at the end of the array. Consider the case when all animals
	 * are the same kind.
	 * 
	 * @author siimaus
	 *
	 */

	enum Animal {
		//sheep, goat
		goat, sheep
	};

	public static void main(String[] param) {
		// for debugging
		System.out.println("Aloha!");
		Animal[] animals = new Sheep.Animal[1000000];
		long t0 = System.currentTimeMillis();
		Sheep.reorder(animals);
		long t1 = System.currentTimeMillis();
		int delta = (int) (t1 - t0);

		System.out.println("Time spent: " + delta + " ms");
		
	}

	public static void reorder(Animal[] animals) {
		// TODO!!! Your program here

		int goatCounter = -1;

		int j = 0;

		for (int i = 0; i < (animals.length / 2) + (animals.length % 2); i++) {
			j = animals.length - i - 1;
			Animal a = animals[i];
			Animal b = animals[j];
									
			if (a == Sheep.Animal.goat) {
				goatCounter++;				
			} 

			if (i != j) {
				if (b == Sheep.Animal.goat) {
					goatCounter++;
				} 
			}
		}
		
		//reorder. As there is no need to retain information about original stuff, 
		// we just reinitialize array with correct values
		for (int i = 0; i < animals.length; i++) {
			if (i<=goatCounter) {
				animals[i] = Sheep.Animal.goat;
			} else {
				animals[i] = Sheep.Animal.sheep;
			}
		}
				

	}
	/**
	 * 
	 * @param data
	 * @param left
	 * @param right
	 * @author Mohammad (Rameen) Mohammadi 
	 * @see <a href="http://www.cs.oswego.edu/~mohammad/classes/csc241/samples/sort/Quicksort.txt"> http://www.cs.oswego.edu/~mohammad/classes/csc241/samples/sort/Quicksort.txt </a>
	 */
	public static void Quicksort (Animal data[],int left,int right) {
		   int i,j;
		   Animal mid, tmp;

		   i = left;
		   j = right;
		   mid = data[(left + right)/2];
		   do {
		        while(data[i].compareTo(mid) < 0)
		           i++;
		       while(mid.compareTo(data[j]) < 0)
		           j--;
		       if (i <= j) {
		           tmp = data[i];
		           data[i] = data[j];
		           data[j] = tmp;
		           i++;
		           j--;
		       }
		   } while (i <= j);
		   if (left < j) Quicksort(data,left,j);
		   if (i < right) Quicksort(data,i,right);
		}

	
}
