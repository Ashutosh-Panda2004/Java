package world;
import java.io.*;
import java.util.Scanner;
public class FileExample {
    public void f1() throws IOException{
        int i;
        FileOutputStream fout;
        fout=new FileOutputStream("/Users/saurabhshukla/Documents/MySirG/Java/Java Programs/HelloWorld/files/myData.txt");
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter your company name");
        String name=sc.nextLine();
        for(i=0;i<name.length();i++)
            fout.write(name.charAt(i));
        fout.close();
        System.out.println("Data Stored in File");
    }
    public void f2() throws IOException{
        int i;
        FileOutputStream fout;
        fout=new FileOutputStream("/Users/saurabhshukla/Documents/MySirG/Java/Java Programs/HelloWorld/files/myData.txt",true);
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter your company name");
        String name=sc.nextLine();
        for(i=0;i<name.length();i++)
            fout.write(name.charAt(i));
        fout.close();
        System.out.println("Data Stored in File");
    }
    public void f3() throws IOException{
        int i;
        FileInputStream fin=new FileInputStream("/Users/saurabhshukla/Documents/MySirG/Java/Java Programs/HelloWorld/files/myData.txt");
        do{
            i=fin.read();
            if(i!=-1){
                System.out.print((char)i);
            }
        }while(i!=-1);
        fin.close();
    }
    public void f4() throws IOException{
        FileWriter file=new FileWriter("/Users/saurabhshukla/Documents/MySirG/Java/Java Programs/HelloWorld/files/file1.txt");
        BufferedWriter bf=new BufferedWriter(file);
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter your company name");
        String name=sc.nextLine();
        bf.write(name);
        bf.close();
    }
    public void f5() throws IOException{
        FileReader file=new FileReader("/Users/saurabhshukla/Documents/MySirG/Java/Java Programs/HelloWorld/files/file1.txt");
        BufferedReader bf=new BufferedReader(file);

        String s1=bf.readLine();
        bf.close();
        System.out.println("\""+s1+"\"");
    }
}
