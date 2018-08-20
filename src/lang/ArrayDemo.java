package lang;

import java.util.Arrays;

public class ArrayDemo {
    private String[] arrs;
    private int length;
    private int maxlength;

    public ArrayDemo(){super();}
    public ArrayDemo(int maxlength){
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
        int find = length;
        for (int i=0;i<length;i++) {
            if (arrs[i].compareTo(value)>0){
                find=i;
                break;
            }
        }
        if (find!=length){
            for (int i=length;i>find;i--){
                arrs[i]=arrs[i-1];
            }
        }
        length++;
        arrs[find]=value;
    }
    public int find(String value){
        int find =-1;
        int low =0;
        int heigth = length-1;
        while (true){
            if (low>heigth)break;
            int seach = (low+heigth)/2;
            if (value.compareTo(arrs[seach])>0){
                low=seach+1;
            }else if(value.compareTo(arrs[seach])<0){
                heigth=seach-1;
            }else{
                find = seach;
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
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arrs.length; i++) {
            sb.append(arrs[i]).append(" ");
        }
        System.out.println(sb.toString());
    }
    public static void main(String[] args) {
        ArrayDemo highArray = new ArrayDemo(5);
        highArray.insert("a");
        highArray.insert("b");
        highArray.insert("c");
        highArray.insert("d");
        highArray.insert("e");
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
