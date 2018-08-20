package lang;

import java.util.Arrays;

public class ArrayTest {
    private String[] arrs;
    private int length;
    private int maxlength;

    public ArrayTest(){super();}
    public ArrayTest(int maxlength){
        super();
        arrs=new String[maxlength];
        this.length=0;
        this.maxlength=maxlength;
    }
    public void insert(String value){
        if (length==maxlength){
            maxlength *=2;
            arrs= Arrays.copyOf(arrs,maxlength);
        }
        arrs[length++]=value;
    }
    public int find(String value){
        int find =-1;
        for (int i=0;i<length;i++) {
            if (arrs[i].equals(value)){
                find=i;
                break;
            }
        }
        return find;
    }
    public boolean delete(String value){
        int find=find(value);
        if (find==-1)return false;
        for (int i=find;i<length;i++){
                arrs[i]=arrs[i+1];
        }
        arrs[--length]=null;
        return true;
    }
    public void display(){
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < arrs.length; i++) {
            sb.append(arrs[i]).append(" ");
        }
        System.out.println(sb.toString());
    }
    public static void main(String[] args) {
        ArrayTest highArray = new ArrayTest(5);
        highArray.insert("a");
        highArray.insert("b");
        highArray.insert("c");
        highArray.insert("d");
        highArray.insert("e");

        highArray.insert("g");
        highArray.display();

        int find = highArray.find("g");
        System.out.println(find);

		highArray.delete("g");
        highArray.display();
    }
}
