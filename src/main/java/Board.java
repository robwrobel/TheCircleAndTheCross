import java.util.ArrayList;
import java.util.List;

public class Board {
    public int maxColNo;
    public int maxRowNo;
    public int noOfElements;

    List<Field> fieldList = new ArrayList<>();

    public Field getField(int id) {
        return fieldList.get(id);
    }

    public String toString() {

        StringBuilder sb = new StringBuilder();

        int id = 0;
        for (int row = 0; row < maxRowNo; row++) {
            for (int col = 0; col < maxColNo; col++) {
                sb.append(toFieldFormat(getField(id).toString()));
                id++;
            }
            sb.append("\n");
        }

        return sb.toString();
    }

    private String toFieldFormat(String field) {
        final int finalStringLength = 4;
        int idLength = field.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < finalStringLength - idLength; i++) {
            sb.append(" ");
        }
        sb.append(field);
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
