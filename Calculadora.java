/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora;

/**
 *
 * @author memol
 */
public class Calculadora {
    
        /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         Lista lista1=new Lista();
         Lista lista2=new Lista();
         Lista resultado=new Lista();
        int a=2234,b=1678;
        int n;
        do{
           n=a%10;
           a=a/10;
           lista1.insertar(n);
        }while(a!=0);
        lista1.Imprimir();
        do{
           n=b%10;
           b=b/10;
           lista2.insertar(n);
        }while(b!=0);
        lista2.Imprimir();
        System.out.print("Suma: ");
        resultado.suma(lista1, lista2);
        System.out.print("Resta: ");
        resultado.resta(lista1, lista2);
        System.out.print("Multiplicación: ");
        resultado.Multiplicacion(lista1, lista2);
    }
}
