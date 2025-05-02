package kernel;

/**
 * El recorrido se hace de izquierda a derecha
 */

public class BitMap {
    private int[] b;

    public BitMap(int size) {
        if (size >= 0) {
            b = new int[(int) Math.ceil(size / 32.0)];
        }
    }

    // Métodos obligatorios --------------------------------------------------------------------------------------------

    /**
     * Enciende el bit de la posición i del kernel.BitMap
     */
    public void On(int i) {
        int index = i / 32; // Posición del bit en el BitMap
        int temp = b[index]; // int a operar
        i = i % 32;
        int m = 0x00000001 << i; // Máscara
        b[index] = temp | m;
    }

    /**
     * Apaga el bit de la posición i del kernel.BitMap
     */
    public void Off(int i) {
        int index = i / 32; // Posición del bit en el BitMap
        int temp = b[index]; // int a operar
        i = i % 32;
        int m = 0x00000001 << i; // Máscara
        b[index] = temp & ~m;
    }

    /**
     * Retorna el valor de la posición i
     */
    public byte Access(int i) {
        int index = i / 32;
        int temp = b[index];
        i %= 32;
        int m = 0x00000001 << i;

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

    // en el for esta seteado en 8 para ver solo 8 bits. pero deberian ser 32
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < b.length; i++) { // Recorre el BitMap
            int m = 0x80000000;
            for (int j = 0; j < 32; j++) { // Recorre cada bit del int
                if (j % 4 == 0) s.append(" ");
                if ((b[i] & m) == 0) s.append("0");
                else s.append("1");
                m >>>= 1;
            }
            if (b.length > 1) s.append("\n");
        }
        return s.toString();
    }
}
