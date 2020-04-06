package JavaEveryDayPractice47;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

/**
 * @author:wangxue
 * @date:2020/3/19 10:51
 */
class FileRecord{
    String name;
    String page;
    int count;

    public FileRecord(String name, String page) {
        this.name = name;
        this.page = page;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FileRecord that = (FileRecord) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(page, that.page);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, page);
    }

    @Override
    public String toString() {
        String s=name;
        if(name.length()>16){
            s=s.substring(name.length()-16);
        }
        return s+" "+page+" "+count;
    }
}
public class Main1 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        List<FileRecord> list=new ArrayList<>();
        while(scanner.hasNext()){
            String s=scanner.next();
            int index=s.lastIndexOf("\\");
            String name=s.substring(index+1);
            String page=scanner.next();
            FileRecord fileRecord=new FileRecord(name,page);
            int count=0;
            if(list.contains(fileRecord)){
                int index1=0;
                for(int i=0;i<list.size();i++){
                    if(list.get(i).equals(fileRecord)){
                        count=list.get(i).count;
                        index1=i;
                        break;
                    }
                }
                list.remove(index1);
            }
            fileRecord.count=++count;
            list.add(fileRecord);
        }
        if(list.size()<=8){
            for(FileRecord fr:list){
                System.out.println(fr);
            }
        }else{
            for(int i=list.size()-8;i<list.size();i++){
                System.out.println(list.get(i));
            }
        }
    }
}
