import java.util.ArrayList;
import java.util.List;

public class Board {
    public int maxColNo;
    public int maxRowNo;
    public int noOfElements;

    List<Field> fieldList = new ArrayList<>();


    public Board() {
        initialize();
    }


    public Field getField(int id) {
        return fieldList.get(id);
    }

    public String toString() {

        StringBuilder sb = new StringBuilder();

        int id = 0;

        for (int col = 0; col < maxColNo; col++) {
            for (int row = 0; col < maxRowNo; col++) {
                sb.append(toFieldFormat(id));
                id++;
            }
            sb.append("\n");
        }

        return sb.toString();
    }

    private String toFieldFormat(int id) {
        final int finalStringLength = 5;
        int idLength = String.valueOf(id).length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < finalStringLength - idLength; i++) {
            sb.append(" ");
        }
        sb.append(id);
        return sb.toString();
    }


    public void setMaxColumnNo(int maxColNo) {
        this.maxColNo = maxColNo;
    }

    public void setMaxRowNo(int maxRowNo) {
        this.maxRowNo = maxRowNo;
    }

    public void initialize() {
        noOfElements = maxColNo * maxRowNo;
        for (int i = 0; i < noOfElements; i++) {
            fieldList.add(new Field(i));
        }
    }
}
