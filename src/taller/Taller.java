package taller;
import java.util.*;


public class Taller {
	public static int encontrarNoRepetido(int[] lista) {
		int tamaño=lista.length;
		Arrays.sort(lista);
		int cuenta=0;
		int aux=Integer.MIN_VALUE;
		int noRepe=Integer.MIN_VALUE;
		int pos=0;
		while(pos<tamaño) {
			if(lista[pos] == aux) {
				cuenta++;
			}
			else {
				if(cuenta == 1) {
					noRepe=aux;
					return noRepe;
				}
				else {
					aux=lista[pos];
					cuenta=1;
				}
				
			}
			
			pos++;
		}
		if(pos == tamaño-1) {
			noRepe=lista[pos];
		}
		
		
		
		return noRepe; 
	}
	public static boolean esPrimo(int num) {
		if(num == 0 || num == 1)
			return false;
		else if(num == 2)
			return true;
		else if(num % 2 == 0)
			return false;
		
		for (int i = 3; i<Math.sqrt(num); i+=2) {
			if(num % i == 0)
				return false;
		}
		
		
		return true;
	}
	public static void imprimirPrimos(int num) {
		
		int contador=1;
		int actual=0;
		while(contador <= num) {
			if(esPrimo(actual)) {
				System.out.print(actual +" ");
				contador++;
			}
			contador++;
			
			
			
			
		}
		
		
	}
	public static Character findNaughtyStep(String original, String modified) {
		char pasoX= 'a';
		if(modified == null) {
			return original.charAt(0);
		}
		if(original.length() > modified.length()) {
			int i=0;
			while(i<modified.length()) {
				if(original.charAt(i) != modified.charAt(i)) {
					pasoX=original.charAt(i);
					break;
				}
				i++;
					
			}
			if(i==modified.length()-1) {
				pasoX=original.charAt(original.length()-1);
			}
			
		}
		else if(original.length()<modified.length()) {
			int i=0;
			while(i<original.length()) {
				if(original.charAt(i) != modified.charAt(i)) {
					pasoX=original.charAt(i);
					break;
				}
				i++;
					
			}
			if(i==modified.length()-1) {
				pasoX=original.charAt(original.length()-1);
			}
			
		}
		return pasoX;
	}
	
	
	public static void crearArbol(String secuencia, int numPisos) {
		int pisoActual=1;
		int tamaño=secuencia.length();
		int charIndex=0;
		while(pisoActual <= numPisos) {
			for(int i=numPisos-pisoActual+1; i >= 1; i--) {
				System.out.print(" ");
			}
			for(int i=pisoActual; i > 0; i--) {
				if(charIndex == tamaño) {
					charIndex=0;
				}
				System.out.print(secuencia.charAt(charIndex)+ " ");
				charIndex++;
			}
			System.out.println();
			pisoActual++;
			
			
			
		}
		for(int i=0; i<numPisos; i++)
			System.out.print(" ");
		System.out.println("|");
	}
	public static int primerRepetido(int[] lista) {
		int repetido=-1;
		ArrayList<Integer> contados=new ArrayList<Integer>();
		for(int i=0; i<lista.length; i++) {
			if(contados.contains(lista[i])) {
				repetido=lista[i];
				break;
			}
			else {
				contados.add(lista[i]);
			}
		}
		return repetido;
		
		
	}
	

	

	public static void sumaDePali(long n) {
		int limite=1000;
		int counter = 0;
		long r = 0;
		boolean esPali =false;
		while(n<=Integer.MAX_VALUE   && !esPali && counter <= limite) {
			r = reversar(n);
			n = n+r;
			if(esPalindromo(n) && n>100) {
				esPali = true;
			}
			counter++;
		}
		if(n> Integer.MAX_VALUE) {
			System.out.println("Error, palindromo no encontrado");
		}else {
			System.out.println("Resultado: "+n);
			System.out.println("Sumas: "+ counter);
		}
		
	}
	public static long reversar(long n) {
		long numeRever = 0;
		while (n > 0) {
			numeRever = numeRever * 10 + n % 10;
			n = n / 10;
		}
		return numeRever;
	}
	public static boolean esPalindromo(long n) {
		return (reversar(n) == n);
	}

	
	
	
	
	public static void main(String[] args) {
		int[] array= {3,3,3,5,5,5,7,7,7,2,4,1,1,4};
		int[] array2= {2,1,3,5,3,2};
		System.out.println(encontrarNoRepetido(array));
		System.out.println(esPrimo(47));
		System.out.println(esPrimo(3001));
		imprimirPrimos(10);
		System.out.println();
		crearArbol("!#$%&/()=", 20);
		System.out.println(primerRepetido(array2));
		System.out.println(findNaughtyStep("abcde","abcdef"));
		sumaDePali(4);
		
		
		
	}

}
