package tester;

import kernel.BitMap;
import kernel.GrafoNoDirigido;

public class Main {
    public static void main(String[] args)  {
        System.out.println("Test: Encendido de bits");
        BitMap b = new BitMap(8);
        b.On(0);
        System.out.println(b);
        b.On(1);
        System.out.println(b);
        b.On(2);
        System.out.println(b);
        b.On(3);
        System.out.println(b);
        b.On(4);
        System.out.println(b);
        b.On(5);
        System.out.println(b);
        b.On(6);
        System.out.println(b);
        b.On(7);
        System.out.println(b);
        b.On(8);
        System.out.println(b);

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
        System.out.println("8. "+g.esunCamino(new int[]{8, 6}));
    }
}
