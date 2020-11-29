import javax.swing.table.AbstractTableModel;
import java.util.Vector;

public class MatHangModel extends AbstractTableModel {
    private Vector<String> columnNames;
    private Vector<MatHang> matHangs;

    public MatHangModel(Vector<String> columnNames, Vector<MatHang> matHangs) {
        this.columnNames = columnNames;
        this.matHangs = matHangs;
    }

    @Override
    public int getRowCount() {
        return matHangs.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex){
            case 0: return matHangs.get(rowIndex).getMaMh();
            case 1: return matHangs.get(rowIndex).getTenMh();
            case 2: return matHangs.get(rowIndex).getNhomMh();
            case 3: return matHangs.get(rowIndex).getGia();
        }
        return null;
    }
}
