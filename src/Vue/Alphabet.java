package Vue;

public class Alphabet {
	
	private String[] alphabet;
	
	public Alphabet(){
		alphabet = new String[26];
		alphabet[1] = "A";
		alphabet[2] = "B";
		alphabet[3] = "C";
		alphabet[4] = "D";
		alphabet[5] = "E";
		alphabet[6] = "F";
		alphabet[7] = "G";
		alphabet[8] = "H";
		alphabet[9] = "I";
		alphabet[10] = "J";
		
	}

	public String[] getAlphabet() {
		return alphabet;
	}

	public void setAlphabet(String[] alphabet) {
		this.alphabet = alphabet;
	}

}
