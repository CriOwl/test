package Automata;

import java.io.*;
import java.util.Scanner;

public class Maquina_Expe {
    public String alfabeto = "5-10-25-50-100- ";
    public String productos = "Chicle,Chifle,Papas,Chocolate,Dorito";
    public int error = -10,
            chicle = 200,
            chifle = 250,
            papas = 500,
            chocolate = 750,
            dorito = 1000,
            matriz_Transicion[][] = {
                    { 1, 2, 5, 10, 20, error, error },
                    { 2, 3, 6, 11, error, error, error },
                    { 3, 4, 7, 12, error, chicle, chicle },
                    { 4, 5, 8, 13, error, error, error },
                    { 5, 6, 9, 14, error, error, error },
                    { 6, 7, 10, 15, error, chifle, chifle },
                    { 7, 8, 11, 16, error, error, error },
                    { 8, 9, 12, 17, error, error, error },
                    { 9, 10, 13, 18, error, error, error },
                    { 10, 11, 14, 19, error, error, error },
                    { 11, 12, 15, 20, error, papas, papas },
                    { 12, 13, 16, error, error, error, error },
                    { 13, 14, 17, error, error, error, error },
                    { 14, 15, 18, error, error, error, error },
                    { 15, 16, 19, error, error, error, error },
                    { 16, 17, 20, error, error, chocolate, chocolate },
                    { 17, 18, error, error, error, error, error },
                    { 18, 19, error, error, error, error, error },
                    { 19, 20, error, error, error, error, error },
                    { 20, error, error, error, error, error, error },
                    { error, error, error, error, error, dorito, dorito }
            };
    public String text_completo;
    public String monedas_usadas;
    
    public String leer_archivo() {
        String texto = "";
        try {
            BufferedReader bf = new BufferedReader(new FileReader("src\\sources\\monedas.txt"));
            String entrada;
            String temp = "";
            while ((entrada = bf.readLine()) != null) {
                temp = temp + entrada+" ";
            }
            texto = temp;
            bf.close();
        } catch (Exception e) {
            System.out.println(" Error al leer el archivo: ");
        }
        return texto;
    }

    public int comparar_Alfabeto(String moneda) {
        Scanner getAlfabeto = new Scanner(alfabeto).useDelimiter("-");
        for (int indice = 0; getAlfabeto.hasNext(); indice++) {
            if (getAlfabeto.next().equals(moneda)) {
                return indice;
            }
        }
        return -1;
    }

    public void separar_texto() {
        text_completo = leer_archivo();
        Scanner separador = new Scanner(text_completo).useDelimiter(" ");
        while (separador.hasNext()) {
            monedas_usadas = separador.next();
            validar_monedas(monedas_usadas);
        }
    }

    public void validar_monedas(String monedas_usad) {
        monedas_usad = monedas_usad + " ";
        Scanner monedas_introducidas = new Scanner(monedas_usad).useDelimiter("-");
        int q = 0;
        for (int indice = 0; monedas_introducidas.hasNext();) {
            int indice_matriz_columnas = comparar_Alfabeto(monedas_introducidas.next());
            if (indice_matriz_columnas < 0 || matriz_Transicion[q][indice_matriz_columnas] == error) {
                break;
            }
            q = matriz_Transicion[q][indice_matriz_columnas];
        }
        switch (q) {
            case 200: {System.out.println("Chicle"); break; }
            case 250: {System.out.println("Chifle");break; }
            case 500: { System.out.println("Papas"); break; }
            case 750: {System.out.println("Chocolate");break;}
            case 1000: {System.out.println("Dorito");break;}
            default:
                System.out.println("Te devuelvo el dinero");
        }

    }
}