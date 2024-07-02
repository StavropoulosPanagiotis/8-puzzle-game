public class Cell
{
    int row = 0;
    int value = 0;
    int collumn = 0;
    boolean isEmpty;

    //constructor
    public Cell(int row, int collumn, int value, boolean isEmpty)
    {   
        this.row = row;
        this.collumn = collumn;
        this.value = value;
        this.isEmpty = isEmpty;
    }

    //getters
    public int getRow()
    {
        return this.row;
    }

    public int getCollumn()
    {
        return this.collumn;
    }

    public int getValue()
    {
        return this.value;
    }

    public boolean getIsEmpty()
    {
        return this.isEmpty;
    }

    //setters
    public void setRow(int newRow)
    {
        this.row = newRow;
    }

    public void setCollumn(int newCollumn)
    {
        this.collumn = newCollumn;
    }

    public void setValue(int newValue)
    {
        this.value = newValue;
    }

    public void setIsEmpty(boolean newIsEmpty)
    {
        this.isEmpty = newIsEmpty;
    }
}