package test;

import kernel.BitMap;
import kernel.Grafo;

public class Main {
    public static void main(String[] args)  {
        /*System.out.println("Test select");
        BitMap bm = new BitMap(8);
        bm.On(0);
        bm.On(2);
        bm.On(4);
        bm.On(5);
        bm.On(7);
        for (int i = 0; i <= 9; i++) {
            System.out.println(bm);
            System.out.println("cantidad de unos de 0 a "+i+": "+bm.Rank(i));
        }

        int[] conex = {
                1,2,
                2,3,
                2,4,
                4,5
        };
        Grafo g = new Grafo(5, conex );


        g.vecinos(0);
        g.vecinos(1);
        g.vecinos(2);
        g.vecinos(3);
        g.vecinos(4);
        g.vecinos(5);
        g.vecinos(6);*/

        BitMap bitmap = new BitMap(16);

        // Encendemos manualmente algunos bits
        bitmap.On(1);
        bitmap.On(3);
        bitmap.On(4);
        bitmap.On(7);
        bitmap.On(15);

        System.out.println("Bitmap visual:");
        System.out.println(bitmap.toString());

        // Test de Select
        System.out.println("Select(1) = " + bitmap.Select(1)); // Esperado: 1
        System.out.println("Select(2) = " + bitmap.Select(2)); // Esperado: 3
        System.out.println("Select(3) = " + bitmap.Select(3)); // Esperado: 4
        System.out.println("Select(4) = " + bitmap.Select(4)); // Esperado: 7
        System.out.println("Select(5) = " + bitmap.Select(5)); // Esperado: 15
        System.out.println("Select(6) = " + bitmap.Select(6)); // Esperado: -1
        System.out.println("Select(0) = " + bitmap.Select(0)); // Esperado: -1
        System.out.println("Select(-3) = " + bitmap.Select(-3)); // Esperado: -1
        System.out.println("Select(100) = " + bitmap.Select(100)); // Esperado: -1


        /*System.out.println("\n--- Test Grafo grande (40 nodos) ---");

        int[] relacionesGrandes = {
                1, 2, 2, 3, 3, 4, 4, 5,
                5, 6, 6, 7, 7, 8, 8, 9,
                9, 10, 10, 1,   // ciclo grande

                11, 12, 12, 13, 13, 14, // cadena lineal
                15, 16, 16, 17,
                17, 18, 18, 19, 19, 20, // otra cadena

                21, 22, 21, 23, 23, 24, // bifurcación
                25, 26, 26, 27, 27, 28, 28, 25, // ciclo

                29, 30, 30, 31,
                32, 33, 33, 34, 34, 35,
                36, 37, 37, 38,

                // algunos nodos sin conexión: 39, 40
        };

        GrafoNoDirigido gGrande = new GrafoNoDirigido(40, relacionesGrandes);

// Ver vecinos de todos los nodos
        System.out.println("\n--- Vecinos de los 40 nodos ---");
        for (int i = 1; i <= 40; i++) {
            gGrande.vecinos(i);
        }

// Pruebas de caminos
        System.out.println("\n--- Caminos en el grafo grande ---");
        System.out.println("1. "+gGrande.esunCamino(new int[]{1, 2, 3, 4, 5}));
        System.out.println("2. "+gGrande.esunCamino(new int[]{10, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10})); // ciclo
        System.out.println("3. "+gGrande.esunCamino(new int[]{11, 12, 13, 14}));
        System.out.println("4. "+gGrande.esunCamino(new int[]{21, 22}));
        System.out.println("5. "+gGrande.esunCamino(new int[]{21, 23, 24}));
        System.out.println("6. "+gGrande.esunCamino(new int[]{25, 26, 27, 28, 25}));
        System.out.println("7. "+gGrande.esunCamino(new int[]{39, 1}));  // nodo aislado
        System.out.println("8. "+gGrande.esunCamino(new int[]{1, 40}));  // nodo aislado
        System.out.println("9. "+gGrande.esunCamino(new int[]{}));
        System.out.println("10. "+gGrande.esunCamino(new int[]{1}));

        // Test: Creación de un grafo dado <A,V>
        int[] relaciones = {
                1, 2,
                2, 4,
                4, 10,
                10, 3,
                3, 1,
                8, 9,
                9, 6,
                6, 5,
                5, 7
        };
        GrafoNoDirigido g = new GrafoNoDirigido(10, relaciones);

        System.out.println("\nTest: Preguntar por los vecinos de cada nodo");
        for (int i = 0; i <= 11; i++) {
            g.vecinos(i);
        }

        System.out.println("\nTest: Probar distintos casos de vecinos");
        System.out.println("1. "+g.esunCamino(new int[]{1, 2, 11}));
        System.out.println("2. "+g.esunCamino(new int[]{1, 2, 1, 2, 4}));
        System.out.println("3. "+g.esunCamino(new int[]{1, 8}));
        System.out.println("4. "+g.esunCamino(new int[]{2, 3}));
        System.out.println("5. "+g.esunCamino(new int[]{1, 2, 4, 10, 3, 1, 2}));
        System.out.println("6. "+g.esunCamino(new int[]{}));         // vacío
        System.out.println("7. "+g.esunCamino(new int[]{5}));        // solo un nodo
        System.out.println("8. "+g.esunCamino(new int[]{8, 6}));*/
    }
}
