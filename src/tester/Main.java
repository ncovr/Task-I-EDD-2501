package tester;

import kernel.BitMap;
import kernel.GrafoNoDirigido;

public class Main {
    public static void main(String[] args)  {
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

        // Preguntar por los vecinos de cada nodo
        for (int i = 1; i <= 10; i++) {
            System.out.print("Vecinos de " + i + ": ");
            g.vecinos(i);
        }

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
