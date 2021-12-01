
package programas;

import datos.DatosDesordenados;
import datos.DatosOrdenados;
import javax.swing.JOptionPane;


public class TestOrdenamiento {

   
    
    public static void main(String[] args) {
        
        DatosDesordenados m;
        //DatosOrdenados datosOrd;
        int n, s; 
        long t, t1, t2;
        
        n = Integer.parseInt(JOptionPane.showInputDialog(
                "¿Cuántos datos son?"));
        s = Integer.parseInt(JOptionPane.showInputDialog(
                "¿Cuál es el valor máximo?"));
        
        m = new DatosDesordenados(s, n);
        m.generarValores();
        System.out.println("" + m);
        //-----------------------------------------------
        System.out.println("");   
        t1 = System.nanoTime();   // start
            DatosOrdenados mob = m.bubbleSort();
            t2 = System.nanoTime();   // stop
            t= t2 - t1;
            System.out.println("n="+ n + " t=" + t + " ns. Burbuja=" + mob);
        //-----------------------------------------------
        System.out.println("");    
        t1 = System.nanoTime();   // start
            DatosOrdenados moi = m.insertSort();
            t2 = System.nanoTime();   // stop
            t = t2 - t1;
            System.out.println("n="+ n + " t=" + t + " ns. Inserción" + moi);
        //--------------------------------------------------
        System.out.println("");    
        t1 = System.nanoTime();   // start
            mob = m.bubbleSortAscendente();
            t2 = System.nanoTime();   // stop
            t = t2 - t1;
            System.out.println("n = "+ n + " t = " + t + "ns. Burbuja Ascendent): " + mob);
        //--------------------------------------------------
            System.out.println("");
            t1 = System.nanoTime();   // start
            mob = m.quickSortAscendente();
            t2 = System.nanoTime();   // stop
            t = t2 - t1;
            System.out.println("n = "+ n + " t = " + t + "ns. QuickSort Ascendete): " + mob);
        //--------------------------------------------------
        System.out.println("");
        t1 = System.nanoTime();   // start
            mob = m.radix( ); 
            t2 = System.nanoTime();   // stop
            t = t2 - t1;
            System.out.println("n = "+ n + " t = " + t + "ns. Radix Ascendete): " + mob);
        //--------------------------------------------------
            System.out.println("");
            t1 = System.nanoTime();   // start
            mob = m.shell();
            t2 = System.nanoTime();   // stop
            t = t2 - t1;
            System.out.println("n = "+ n + " t = " + t + "ns. ShellSort Ascendete): " + mob);
    }
    
    
}