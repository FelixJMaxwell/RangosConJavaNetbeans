/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;
import java.util.Scanner;
import java.io.*;
import java.net.*;

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
        int Socket;
        int valorUno;
        int valorDos;
        String mensajePalServerUno="";
        String mensajeString="";
        String dirIP;
        Scanner EntradaTecladoInt = new Scanner(System.in);
        Scanner EntradaTecladoString = new Scanner(System.in);
        
        //Esta parte del programa solo sirve para manejar Strings
        String nuevaCadena = "";
        int newCadena;
        System.out.printf("Cadena: ");
        nuevaCadena = EntradaTecladoString.nextLine();
        
        newCadena = nuevaCadena.indexOf("/");
        
        //System.out.printf("Valor de / es: " + newCadena);
        String Palabras="";
        String PalabrasDos="";
        String listaPalabras;
        String ListaPalabras[] = new String[newCadena];
        String listaPalabrasDos;
        String ListaPalabrasDos[] = new String[newCadena];
        for(int contador = 0; contador<=(nuevaCadena.indexOf("/") - 1); contador++){
            System.out.printf("\n" + contador + ": " + nuevaCadena.charAt(contador));
            listaPalabras = String.valueOf(nuevaCadena.charAt(contador));
            ListaPalabras [contador] = listaPalabras;
        }
        
        for(int contador = (nuevaCadena.indexOf("/")+1); contador<=(nuevaCadena.length() - 1); contador++){
            System.out.printf("\n" + contador + ": " + nuevaCadena.charAt(contador));
            listaPalabrasDos = String.valueOf(nuevaCadena.charAt(contador));
            //System.out.printf("\tlistaPalabrasDos: " + listaPalabrasDos);
            ListaPalabrasDos[contador-contador] = listaPalabrasDos;
        }
        
        for(int i=0;i<=(ListaPalabras.length - 1); i++){
            Palabras = Palabras + ListaPalabras[i];
            //System.out.printf("\nListaPalabras: " + ListaPalabras[i]);
        }
        System.out.printf("\nPalabras: " + Palabras);
        
        for(int e=0; e<=(ListaPalabrasDos.length - 1); e++){
            PalabrasDos = PalabrasDos + ListaPalabrasDos[e];
        }
        System.out.printf("\nPalabrasDos: " + PalabrasDos);
        
        System.out.printf("\nValores: " + Palabras + " a " + PalabrasDos);
        System.out.println();
        //Termina la parte del programa para manejar strings
        
        System.out.printf("Numero: ");
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
            
            //Esta parte del programa sirve pa manejar conexiones a un servidor mediante sockets
            mensajePalServerUno =  String.valueOf(valorUno);
            
            mensajeString = String.valueOf(valorUno) + "/" + String.valueOf(valorDos);
            byte []datos = new byte[256];   
            
            System.out.printf("\nEscriba la direccion IP: ");
            dirIP = EntradaTecladoString.nextLine();
            System.out.printf("\nCual es el socket a conectar: ");
            Socket = EntradaTecladoInt.nextInt();
            
            Socket socket = new Socket(dirIP, Socket);
            DataInputStream din = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            
            dos.write(mensajeString.getBytes());
            dos.flush();
            din.read(datos,0,datos.length);
            String message = new String(datos);
            
            System.out.println();
            din.close();
            dos.close();
            socket.close();
            //Termina la parte de los sockets
        }
    }
}