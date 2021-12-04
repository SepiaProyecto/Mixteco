package mx.curso.mixteco;

public class Aleatorio {

	public static void main(String[] args) {
		String[] ordenadas = {"OK", "XD", "XD4"};
        boolean[] impresas = new boolean[ordenadas.length];
 
 
        for(int i = 0; i < ordenadas.length;){
            int posicion = (int)(Math.random() * ordenadas.length);
            if(!impresas[posicion]){
                impresas[posicion] = true;
                String valor=ordenadas[posicion];
                System.out.println(valor);
                i++;
            }
        }
	}

}
