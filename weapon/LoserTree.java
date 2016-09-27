import java.util.*;
public class LoserTree<T extends Comparable>
{
    private int[] tree;
    private T[] data;
    public LoserTree(T[] data)
    {
        tree = new int[data.length];
        this.data = data;
        build();
    }
    public static void main(String[] args)
    {
        Random ra = new Random();
        Integer data[] = new Integer[4];
        for (int i =0;i < data.length; ++i)
        {
            data[i] = (int)ra.nextInt(10);
        }
        for (int i:data)
            System.out.print(i+" ");
        System.out.println();
        LoserTree<Integer> loserTree = new LoserTree<>(data);
        int[] result = new int[data.length];
        for (int i =0;i < data.length;++i)
        {
            result[i] = data[loserTree.getWiner()];
            data[loserTree.getWiner()] = Integer.MAX_VALUE;
            loserTree.adjust(loserTree.getWiner());
        }
        for (int r:result)
            System.out.print(r+" ");
    }
    public void build(){
        for (int i = 0;i <tree.length;++i)
        {
            tree[i] = -1;
        }
        for (int i = data.length-1;i>=0;--i)
            adjust(i);
    }
    public void adjust(int i)
    {
        int victor = i;
        int prent = (i+tree.length)/2;
        int temp;
        while(prent>0)
        {
//            if ( victor >=0 &&
                    if(tree[prent] == -1
                    || data[victor].compareTo(data[tree[prent]]) > 0)
//                        )
            {
                temp = tree[prent];
                tree[prent] = victor;
                victor = temp;
            }
            prent>>>=1;
            if (victor == -1)
                break;
        }
        tree[0] = victor;
    }
    public int getWiner()
    {
        return tree[0];
    }
}
