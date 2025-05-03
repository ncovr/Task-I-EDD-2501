package kernel;

/**
 * El recorrido se hace de izquierda a derecha
 */

public class BitMap {
    private int[] b;
    int size;

    public BitMap(int size) {
        if (size >= 0) {
            b = new int[(int) Math.ceil(size / 32.0)];
            this.size = size;
        }
    }

    // Métodos obligatorios --------------------------------------------------------------------------------------------

    /**
     * Enciende el bit de la posición i del kernel.BitMap
     */
    public void On(int i) {
        if(i < 0 || i >= size) return;
        int index = i / 32; // Posición del bit en el BitMap
        int temp = b[index]; // int a operar
        i = i % 32;
        int m = 0x80000000 >>> i;
        b[index] = temp | m;
    }

    /**
     * Apaga el bit de la posición i del kernel.BitMap
     */
    public void Off(int i) {
        if(i < 0 || i >= size) return;
        int index = i / 32; // Posición del bit en el BitMap
        int temp = b[index]; // int a operar
        i = i % 32;
        int m = 0x80000000 >>> i;
        b[index] = temp & ~m;
    }

    /**
     * Retorna el valor de la posición i
     */
    public byte Access(int i) {
        if(i < 0 || i >= size) return -1;
        int index = i / 32;
        int temp = b[index];
        i %= 32;
        int m = 0x80000000 >>> i;

        if ((temp & m) == 0) return 0;
        return 1;
    }

    /**
     * Retorna la cantidad de bits encendidos desde la posición 0 hasta i
     */
    int Rank(int i) {
        return -1;
    }

    /**
     * Retorna la posición hasta donde existen j bits en 1. Si la cantidad de bits en 1 es menor que j, se retorna -1
     */
    int Select(int j) {
        if (!(j >= 0 && j <= b.length)) return -1;
        return -1;
    }

    // Métodos extras --------------------------------------------------------------------------------------------------
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();

        for (int i = 0; i < b.length; i++) {
            int m = 0x80000000; int j = 0;
            do {
                if (j != 0 && j % 4 == 0) s.append(" ");
                if ((b[i] & m) == 0) s.append("0");
                else s.append("1");
                m >>>= 1;
                j++;
            } while (j < size);
            if (b.length > 1) s.append("\n");
        }
        return s.toString();
    }
}
