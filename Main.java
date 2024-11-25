import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// Step 2: Declare and initialize variables for file input
		ArrayList<Plant> plants = new ArrayList<>();
		String fileName = "Forage.csv";

		// Step 2: Connect input stream to file
		try (FileInputStream fileStream = new FileInputStream(fileName);
			 Scanner fileScanner = new Scanner(fileStream)) {

			// Step 2: Create loop to read through the whole file
			while (fileScanner.hasNextLine()) {
				String line = fileScanner.nextLine();
				try {
					// Step 3: Build Plant objects and store into ArrayList
					Plant plant = new Plant(line);
					plants.add(plant);
				} catch (IllegalArgumentException e) {
					System.err.println("Skipping invalid line: " + line);
				}
			}
		} catch (FileNotFoundException e) {
			System.err.println("File not found: " + fileName);
		} catch (IOException e) {
			System.err.println("An error occurred: " + e.getMessage());
		}

		// Step 3: Print contents of ArrayList
		for (Plant plant : plants) {
			System.out.println(plant);
			System.out.println();
		}
	}
}