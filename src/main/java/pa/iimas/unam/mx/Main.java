package pa.iimas.unam.mx;

import pa.iimas.unam.mx.model.MagicBoard;

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Cuadros Magicos");
        System.out.println("Elge un numero para probar los cuadros magicos:");
        System.out.print(">");
        int val = 1;
        int val2 = 1;
        try {
            val = s.nextInt();
            System.out.println("Presiona 1 si se desea pausa despues de encontrar resultado, Default [No]");
            System.out.println("1. Si");
            System.out.print(">");
            val2 = s.nextInt();

        } catch (Exception e){
            System.out.println("Opcion Invalida");
            System.exit(0);
        }

        MagicBoard mb = new MagicBoard(val);
        Backtracking bt = new Backtracking(mb);
        bt.setWait((1==val2));
        System.out.println("Numero Magico: "+mb.getMagicValue());
        bt.backtrack(mb.getBoard()[0][0], mb.getPossibleValues(),mb.getBoard());
    }
}
