/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;
import java.util.Scanner;

/**
 *
 * @author ekt
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        int numero;
        int diferencia;
        int rango;
        
        int valorUno;
        int valorDos;
        
        Scanner EntradaTecladoInt = new Scanner(System.in);
        
        System.out.printf("\n\nNumero: ");
        numero = EntradaTecladoInt.nextInt();
        System.out.printf("Rangos: ");
        rango = EntradaTecladoInt.nextInt();
        
        diferencia = numero/rango;
        int ListaRangos[] = new int[numero];
        
        System.out.printf("La diferencia es igual a: " + diferencia + "\n\n");
        
        for (int i = 1; i<=rango;i++){
            ListaRangos[i] = i * diferencia;
            System.out.printf(i + " rango es: " + (ListaRangos[i] - diferencia + 1) + " hasta: " + ListaRangos[i] + "\n");
            valorUno = (ListaRangos[i] - diferencia + 1);
            valorDos = ListaRangos[i];
       }
    }
}