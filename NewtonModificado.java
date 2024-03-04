package com.mycompany.newtonmodificado;
import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author josue
 */
public class NewtonModificado {
    
    static Scanner leer = new Scanner(System.in);
    static ArrayList<Double> evaluaciones = new ArrayList<>();
    static ArrayList<Double> errores = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("Ingrese el valor inicial: " );
        double inicio = leer.nextDouble(); // 3
        iterar(inicio);
        mostrar();
    }
    
    public static double funcion(double x){
        return  3*Math.pow(x,2) - Math.pow(Math.E, x) + 7; // 3x^2 - e^x + 7
    }
    
    public static double primeraDerivada(double x) {
        return 6*x - Math.pow(Math.E, x); // 6x−e^x
    }
    
    public static double segundaDerivada(double x) {
        return 6-Math.pow(Math.E, x); // 6x
    }
    
    public static void iterar(double inicio) {
        
        double tolerancia = 0.001;
        double errorRelativo = 1;
        double numerador;
        double denominador;
        double resultado;
        
        
        while (errorRelativo > tolerancia) {
            errorRelativo = 0;
            numerador = funcion(inicio) * primeraDerivada(inicio);
            denominador = Math.pow(primeraDerivada(inicio), 2) - funcion(inicio) * segundaDerivada(inicio);
            resultado = inicio  - (numerador / denominador);
            errorRelativo = Math.abs(resultado - inicio);
            inicio = resultado;
            evaluaciones.add(resultado);
            errores.add(errorRelativo);
        }
    }
    
    public static void mostrar() {
        System.out.println("\nIteracion\tEvaluacion\t\tError relativo");
        for(int i = 0; i< evaluaciones.size(); i++) {
            System.out.println((i+1) + "\t\t" + evaluaciones.get(i) + "\t" + errores.get(i));
        }
    }
 
}


