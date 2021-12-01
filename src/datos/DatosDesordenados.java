package datos;
import java.util.Arrays;
/**
 *
 * @author Noemí Lara Acono
 */
public class DatosDesordenados {
    // Atributos
    private int[] valores; 
    private int limiteSuperior; 
    private int size; 

    public DatosDesordenados(int limite, int size) {
        this.valores = new int[size];
        this.limiteSuperior = limite;
        this.size = size;
    }
    
    public void agregarDato(int valor){
        valores[size]= valor;
        size++;
    }
    
    public int getDato(int posicion){
        return valores[posicion];
    }
    
    public void generarValores(){
        for (int i=0; i < valores.length; i++){
            double aleatorio = Math.random() * limiteSuperior;
            valores[i] = (int) aleatorio + 1;
        }
    }
    
    public int getSize(){
        return size; 
    }
    
    public int getCapacidad(){
        return valores.length;
    }
    
    public int getLimiteSuperior(){
        return limiteSuperior;
    }
    
    
    public int[] getValores(){
        return valores;
    } 
    
    public int[] getCopiaValores(){
        int [] copia = new int[size];
        System.arraycopy(valores, 0, copia, 0, size);
        return copia;
    }
    
    
   
     public DatosOrdenados algoritmoSort(){
        
        // obtener una copia de los datos desordenados
        int [] arreglo = this.getCopiaValores();
        
        // agregar algoritmo de ordenación
        
        // devolver los datos ordenados
        return new DatosOrdenados(arreglo);
    }
    
    public DatosOrdenados bubbleSort(){
        int [] arreglo = this.getCopiaValores();
        int n = arreglo.length;
        int cont = 0;
        int ci = 0;
        for (int i=0; i < n-1; i++){
            for (int j=0; j < n-i-1; j++){
                cont++;
                if (arreglo[j] > arreglo[j+1]){
                    // intercambiar: swap
                    ci++;
                    int temporal = arreglo[j];
                    arreglo[j] = arreglo[j+1];
                    arreglo[j+1] = temporal;
                }
            }
        }
        System.out.println("BS-comparaciones = " + cont);
        System.out.println("BS-intercambios = " + ci);
        return new DatosOrdenados(arreglo);
    }
    
       
    
    public DatosOrdenados insertSort(){
         // obtener una copia de los datos desordenados
        int [] a = this.getCopiaValores();
        
	int i, j, aux; 
	int cont=0; 
	for ( i = 1; i < a.length; i++){
		j = i;
		aux = a[i];
		while (j >0 && aux < a[j-1]){
                   cont++;
                   a[j] = a[j-1];
                   j--; 
		}
		a[j] = aux; 
	}
        System.out.println("IS-comparaciones = " + cont);
	// devolver los datos ordenados
        return new DatosOrdenados(a);
    }
    
    public DatosOrdenados mergeSort(){
    int [] x = this.getCopiaValores();
	// Aquí va la llamada al método mergesort( arreglo, l, r)
	this.mergesort( x, 0, x.length - 1);
        System.out.println("MS-comparaciones = " + cm);
	return new DatosOrdenados(x);
    } // fin del método ordenacionMerge
    
   private void mergesort (int v[], int l, int r) {
		 int m = (r+l)/2; 
		 if (r > l) { 
                     cm++;
			 mergesort (v, l, m);
			 mergesort (v, m+1, r); 
			 merge (v, l, m, r); 
		 }
	}
    static int cm=0;
   private void merge (int v[], int l, int m, int r)
	{
	//Encuentra el tamaño de los sub-vectores para unirlos.
	  int n1 = m - l + 1;
	  int n2 = r - m;

	  //Vectores temporales.
	  int arrIzq[] = new int [n1];
	  int arrDer[] = new int [n2];

	  //Copia los datos a los arreglos temporales.
	  for (int i=0; i < n1; i++) {
              cm++;
		arrIzq[i] = v[l+i];
	  }
	  for (int j=0; j < n2; j++) {
              cm++;
		arrDer[j] = v[m + j + 1];
	  }
	  // Combinación (mezcla) de los dos arreglos:
	  int i = 0, j = 0;
	  int k = l;
	  while (i < n1 && j < n2) {//Ordenamiento.
                cm++;
		if (arrIzq[i] <= arrDer[j]) {
			v[k] = arrIzq[i];
			i++;
		} else {
			v[k] = arrDer[j];
			j++;
		}
		k++;
	  }//Fin del while.

	  /* Si quedan elementos por ordenar */
	  //Copiar los elementos restantes de arrIzq[].
	  while (i < n1) {
              cm++;
	    v[k] = arrIzq[i];
	    i++;
	    k++;
	  }
	  //Copiar los elementos restantes de arrDer[].
	  while (j < n2) {
              cm++;
	    v[k] = arrDer[j];
	    j++;
	    k++;
	  }
	}
    
   //Se agrega el metodo Burbuja ascendente
   /*-------------------------Inicio-------------------------*/
       public DatosOrdenados bubbleSortAscendente() {
        int[] arreglo = this.getCopiaValores();
        int n = arreglo.length;
        int cont = 0;
        int ci = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                cont++;
                if (arreglo[j] > arreglo[j + 1]) {
                    // intercambiar: swap
                    ci++;
                    int temporal = arreglo[j];
                    arreglo[j] = arreglo[j + 1];
                    arreglo[j + 1] = temporal;
                }
            }
        }
        System.out.println("BS-comparaciones = " + cont);
        System.out.println("BS-permutaciones = " + ci);

        return new DatosOrdenados(arreglo);
    }
   
   /*-------------------------Fin-------------------------*/
   
       
   //Se agregó quicksort y su metodo Ascendente
   /*-------------------------Inicio-------------------------*/
    static int cq = 0;
    static int pq = 0;
    static int pm = 0;
    
       public DatosOrdenados quickSortAscendente() {
        //arreglo a ordenar
        int[] o = this.getCopiaValores();

        //llamada al metodo de ordenamiento QuickSort
        //quickSort(o,0,o.length-1);
        this.quicksortAs(o, 0, o.length - 1);
        System.out.println("QS-comparaciones = " + cq);
        System.out.println("QS-permutaciones = " + pm);

        //metodo para imprimir el vctor ordenado
        return new DatosOrdenados(o);
    }

    private void quicksortAs(int v[], int l, int r) {
        int m = (r + l) / 2;
        if (r > l) {
            cq++;
            quicksortAs(v, l, m);
            quicksortAs(v, m + 1, r);
            quickAs(v, l, m, r);
        }
    }

    //static int cq = 0;
    //static int pq = 0;
    private void quickAs(int v[], int l, int m, int r) { //A IZQ DER
        int piv = v[l];                 //tomamos el primer elemento como pivote
        int i = l;                      //i realiza la búsqueda de izquierda a derecha
        int j = r;                      //j realiza la búsqueda de derecha a izquierda
        int aux;

        while (i < j) {                     // mientras no se crucen...
            while (v[i] <= piv && i < j) {    // busca un elemento mayor que pivote,
                i++;
            }
            while (v[j] > piv) {            //busca un elemento menor que pivote,
                j--;
            }
            if (i < j) {                   //si los encuentra y no se han cruzado...
                pm++;
                aux = v[i];              //los intercambia.
                v[i] = v[j];
                v[j] = aux;
            }
        }
        v[l] = v[j];                    //colocamos el pivote en su lugar de la forma [menores][pivote][mayores]
        v[j] = piv;
        if (l < j - 1) {                    // ordenamos mitad izquierda
            quickAs(v, l, m, j - 1);
        }
        if (j + 1 < r) {
            quickAs(v, j + 1, m, r);   // ordenamos mitad derecha
        }
    }
    /*-------------------------Fin-------------------------*/
    
    
    
    
    
    public static void shell(int A[]) {

        int salto, aux, i;
        boolean cambios;
  
        for (salto = A.length / 2; salto != 0; salto /= 2) {
            cambios = true;
            while (cambios) {   // Mientras se intercambie algún elemento                                         
                cambios = false;
                for (i = salto; i < A.length; i++)   // se da una pasada
                {
                    if (A[i - salto] > A[i]) {       // y si están desordenados
                        aux = A[i];                  // se reordenan
                        A[i] = A[i - salto];
                        A[i - salto] = aux;
                        cambios = true;              // y se marca como cambio.                                   
                    }
                }
            }
        }
}
    


/*
	public static void main(String[] args) {
		int arr[] = {53,3,542,748,14,214};
		radixSort(arr);
		System.out.println(Arrays.toString(arr));
	}
        */
	public static void radixSort(int[] arr) {
		int[][] bucket = new int[10][arr.length];
		int[] bucketOfElement = new int[10];
		int max=0;
		// Encuentra el elemento más grande en la matriz
		for(int i = 0 ; i < arr.length;i++) {
			if(arr[i]>max){
				max = arr[i];
			}
		}
		// Calcula el número de bits del elemento más grande
		int maxLength = (max+"").length();
		for(int m = 0,n=1;m<maxLength;m++,n*=10) {
			// Coloca los números en arr en los cubos correspondientes según sus unidades, decenas, centenas, etc.
			for(int i = 0 ; i < arr.length;i++) {
				int digit = arr[i]/n%10;
				// Asignar el valor de arr [i] a la matriz bidimensional en el depósito
				bucket[digit][bucketOfElement[digit]] = arr[i];
				bucketOfElement[digit]++;
			}
			int index = 0;
			// Leer los elementos en el depósito y reasignarlos a arr
			for(int j = 0;j<10;j++) {
				for(int k = 0 ; k<bucketOfElement[j];k++) {
					arr[index] = bucket[j][k];
					index++;
				}
				bucketOfElement[j]=0;// Borrar el número de elementos en cada uno
			}
	}
		
}
   
    @Override
    public String toString(){
        String cad = "Datos DESORDENADOS: ";
        for (int x : valores){
            cad += x + ", ";
        }
        return cad;
    }
    
    
    
}