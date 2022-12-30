import java.awt.*;


public class ArrayPointList implements PointList {
    private Point [] arr;
    private int actual_size ;
    private int cursor ;


    public ArrayPointList() {
        this.arr = new Point[MAX_SIZE];
        actual_size = 0;
        cursor = -1 ;


    }

    public ArrayPointList(int size) {
        this.arr = new Point[size];
        actual_size = 0;
    }


    @Override
    public void append(Point newPoint) {
        if(!isFull()){
            arr[actual_size] = new Point(newPoint);
            actual_size++;
            cursor = actual_size-1;
        }

    }

    @Override
    public void clear() {
        cursor = -1;
        actual_size = 0;
    }

    @Override
    public boolean isEmpty() {
        return actual_size == 0;
    }

    @Override
    public boolean isFull() {
        return actual_size == arr.length ;
    }

    @Override
    public boolean goToBeginning() {
        if(!isEmpty()) {
            cursor = 0;
            return true;
        }
        return false;
    }

    @Override
    public boolean goToEnd() {
        if(!isEmpty()) {
            cursor = actual_size-1 ;
            return true;
        }
        return false;
    }

    @Override
    public boolean goToNext() {
        if( (cursor < actual_size-1) ){
            cursor ++;
            return true;
        }
        return false;
    }

    @Override
    public boolean goToPrior() {
        if( (actual_size !=0) && (cursor>0) ){
            cursor --;
            return true;
        }
        return false;

    }

    @Override
    public Point getCursor() {
        if(isEmpty() ) return null;
        return new Point(arr[cursor]);
    }
}
