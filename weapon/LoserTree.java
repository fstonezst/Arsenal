public class LoserTree<T extends Comparable>
{
    private int[] tree;
    private T[] data;
    public LoserTree(T[] data)
    {
        tree = new int[data.length+1];
        this.data = data;
        build();
    }
    public static void main(String[] args)
    {

    }
    public void build(){
        for (int i = 0;i <tree.length;++i)
        {
            tree[i] = -1;
        }
        for (int i = data.length-1;i>=0;++i)
            adjust(i);
    }
    public void adjust(int i)
    {
        int victor = i;
        int prent = (i+tree.length)/2;
        int temp;
        while(prent>0)
        {
            if (data[victor].compareTo(data[tree[prent]]) > 0 || tree[prent] == -1)
            {
                temp = tree[prent];
                tree[prent] = victor;
                victor = temp;
            }
            prent/=2;
            if (victor == -1)
                break;
        }
        tree[0] = victor;
    }
    public T getWiner()
    {
        return data[tree[0]];
    }
}
