import java.util.*;

interface Movable {
    void move(String newPos);
}

abstract class ChessPiece implements Movable {

    String name;
    String color;
    String curPos;

    public ChessPiece(String name, String color, String curPos) {
        this.name = name;
        this.color = color;
        this.curPos = curPos;
    }

}

class King extends ChessPiece {
    
    King(String color, String curPos) {
        super("King", color, curPos);
    }

    public void move(String newPos) {
        System.out.println("(Comp) : " + color + " King moving from " + curPos + " to " + newPos);
        curPos = newPos;
    }

}

class Queen extends ChessPiece {
    
    Queen(String color, String curPos) {
        super("Queen", color, curPos);
    }

    public void move(String newPos) {
        System.out.println("(Comp) : " + color + " Queen moving from " + curPos + " to " + newPos);
        curPos = newPos;
    }

}

class Pawn extends ChessPiece {
    
    Pawn(String color, String curPos) {
        super("Pawn", color, curPos);
    }

    public void move(String newPos) {
        System.out.println("(Comp) : " + color + " Pawn moving from " + curPos + " to " + newPos);
        curPos = newPos;
    }

}

public class L12Q1 {

    static void display(ArrayList<ChessPiece> board) {
        System.out.printf("(Comp) : There exists %d chess pieces (", board.size());
        int index;
        ChessPiece piece = null;
        ListIterator itr = board.listIterator();
        while(itr.hasNext()) {
            index = itr.nextIndex()+1;
            piece = (ChessPiece) itr.next();
            System.out.printf("%d : %s (%s) %s, ", index, piece.name, piece.color, piece.curPos);
        }
        System.out.println(")");
    }

    public static void main(String args[]) {

        ArrayList<ChessPiece> board = new ArrayList<ChessPiece>();

        board.add(new King("White", "a7"));
        board.add(new Queen("Black", "c2"));
        board.add(new Pawn("White", "b5"));

        int pieceToMove = -1;
        Scanner sc = new Scanner(System.in);

        do {
            
            display(board);

            System.out.println("(Comp) : Enter which piece to be moved, or press 0 to exit");
            pieceToMove = Integer.parseInt(sc.nextLine());

            if (pieceToMove > 0) {
                pieceToMove--;
                System.out.println("(Comp) : Enter new position for " + board.get(pieceToMove).name + " (" + board.get(pieceToMove).curPos + ")");
                board.get(pieceToMove).move(sc.nextLine());
            }

        } while(pieceToMove != 0);

        display(board);

        sc.close();

    }

}