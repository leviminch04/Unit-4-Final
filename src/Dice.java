public class Dice {
    int faceNum;
    int value;
    public Dice(int faceNum)
    {
        this.faceNum = faceNum;
    }

    public void roll()
    {
        value = (int) (Math.random()*faceNum) + 1;
    }
    public String toString()
    {
        String result = "";
        result += value;
        return result;
    }

}
