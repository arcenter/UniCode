// Code by arcenter
// https://github.com/arcenter/BPDC/

class Element {

	private int atomicNumber;
	private String name, chemicalSymbol, classs;
	private double weight;

	Element(int atomicNumber, String name, String chemicalSymbol, String classs, double weight) {
		this.atomicNumber = atomicNumber;
		this.name = name;
		this.chemicalSymbol = chemicalSymbol;
		this.classs = classs;
		this.weight = weight;
	}

	public void display() {
		System.out.printf("Atomic Number = %d\nName of the Element = %s\nChemical Symbol = %s\nClass = %s\nAtomic Weight = %f\n\n", atomicNumber, name, chemicalSymbol, classs, weight);
	}

	public double getWeight() {
		return weight;
	}

}

public class L3Q1
{
	public static void main(String[] args) {

		Element sodium = new Element(11, "Sodium", "Na", "Alkali Metal", 29.9898);
		Element oxygen = new Element(8, "Oxygen", "O", "NonMetal", 15.999);
		Element nitrogen = new Element(7, "Nitrogen", "N", "NonMetal", 14.007);
		
		Element elements[] = {sodium, oxygen, nitrogen};
		
		System.out.println("Displaying all Elements;\n");
		for (Element temp : elements) {
			temp.display();
		}
		
		System.out.println("Displaying elements with atomic weight greater than 15;\n");
		for (Element temp : elements) {
			if (temp.getWeight() > 15)
		        	temp.display();
		}
	}
}

// Code by arcenter
// https://github.com/arcenter/BPDC/