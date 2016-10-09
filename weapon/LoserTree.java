import java.util.*;
public class LoserTree<T extends Comparable>
{
    private int[] tree;//败者树，存储失败者在data的index || LoserTree，store the index of loser in the data 
    private T[] data;//待排数据，即败者树叶子节点|| input data 
    public LoserTree(T[] data)
    {
        tree = new int[data.length];
        this.data = data;
        build();
    }
    public static void main(String[] args)
    {
        //生成初始数据
        Random ra = new Random();
        Integer data[] = new Integer[4];
        for (int i =0;i < data.length; ++i)
        {
            data[i] = (int)ra.nextInt(10);
        }
        for (int i:data)
            System.out.print(i+" ");
        System.out.println();
        
        //建立败者树
        LoserTree<Integer> loserTree = new LoserTree<>(data);
        
        //存储排序结果
        int[] result = new int[data.length];
        
        //依次输出胜利者
        for (int i =0;i < data.length;++i)
        {
            result[i] = data[loserTree.getWiner()]; //获取胜者
            data[loserTree.getWiner()] = Integer.MAX_VALUE;//用无穷大来取代胜者所在的节点
            
            loserTree.adjust(loserTree.getWiner());//调整胜者所在的节点
        }
        
        //输出结果
        for (int r:result)
            System.out.print(r+" ");
    }
    
    //初始化败者树
    public void build(){
    
        //初始化败者树节点为-1
        for (int i = 0;i <tree.length;++i)
        {
            tree[i] = -1;
        }
        
        //从败者树的节点开始，（即非叶子节点）依次调整每一个节点。
        for (int i = data.length-1;i>=0;--i)
            adjust(i);
    }
    
    
    public void adjust(int i)
    {
        //调整的算法为从一个结点开始，依次与其父结点比较，失败者存储在父节点，胜利者继续往上比。
        int victor = i;
        int prent = (i+tree.length)/2;//指向i的父结点
        int temp;//用于交换两个结点时的临时存储区
        
        while(prent>0)
        {
            if(tree[prent] == -1
                 || data[victor].compareTo(data[tree[prent]]) > 0)
            {
                //如果该节点为-1即未调整过，或者是与新的节点比较胜了就需要将 victor的下表存进败者树的这个结点
                temp = tree[prent];
                tree[prent] = victor;
                victor = temp;
            }
            prent>>>=1; //指向prent的父结点
            
            //如果victor为-1，没有需要比较的数了，则退出
            if (victor == -1)
                break;
        }
        //当prent为0时，则prent为胜者
        tree[0] = victor;
    }
    
    public int getWiner()
    {
        //获取胜者
        return tree[0];
    }
}
