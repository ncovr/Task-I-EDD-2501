package kernel;

public class GrafoNoDirigido {
    BitMap[] g;
    int size;

    public GrafoNoDirigido(int n, int[] relaciones) {
        g = new BitMap[n + 1];
        size = n;
        for (int i = 0; i < relaciones.length - 1; i += 2) {
            int a = relaciones[i];
            int b = relaciones[i + 1];
            if (a <= 0 || b <= 0 || a == b || a > n || b > n) continue;
            relacionar(a, b, size);
        }
    }

    private void relacionar(int a, int b, int n) {
        if (g[a] == null) g[a] = new BitMap(n);
        if (g[b] == null) g[b] = new BitMap(n);
        g[a].On(b);
        g[b].On(a);
    }

    public void vecinos(int i) {
        if (i < 1 || i > size) {
            System.out.println("Error al buscar vecinos de " + i + ": Nodo inexistente");
            return;
        }

        if (g[i] == null) {
            System.out.println("Error al buscar vecinos de " + i + ": No tiene vecinos");
            return;
        }

        StringBuilder s = new StringBuilder();
        int[] vecinos = getVecinos(i);
        for (int j = 0; j < vecinos.length; j++) {
            if (vecinos[j] == 1) s.append(j + " ");
        }
        System.out.println("Vecinos de " + i + ": " + s);
    }

    private int[] getVecinos(int i) {
        if (g[i] == null) return null;

        int[] vecinos = new int[size + 1];
        for (int c = 1; c <= size; c++) {
            if (g[i].Access(c) == 1) vecinos[c]++;
        }
        return vecinos;
    }

    public boolean esunCamino(int[] secuencia) {
        for (int i = 0; i < secuencia.length - 1; i++) {
            int a = secuencia[i];
            int b = secuencia[i + 1];
            if (a > size || b > size || a < 1 || b < 1) return false;
            if (g[a] == null || g[b] == null) return false;
            if (g[a].Access(b) == 0) return false;
        }

        return true;
    }

}
