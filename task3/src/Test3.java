import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.File;
import java.io.FileWriter;
import java.nio.file.Path;


public class Test3 {
    public static void main(String[] args) throws IOException {
        ArrayList<String> values= new ArrayList<>();

        Path path1 = Paths.get(args[1]);
        Scanner scanner = new Scanner(path1);

        String val = "";
        while (scanner.hasNextLine()){
            val = val + scanner.nextLine();
        }
        Pattern pattern1 = Pattern.compile("id\": (.*?),");
        Matcher matcher1 = pattern1.matcher(val);
        Pattern pattern2 = Pattern.compile("value\": (.*?)}");
        Matcher matcher2 = pattern2.matcher(val);
        int a=0;
        while (matcher1.find()&&matcher2.find()){
            int start1=matcher1.start();
            int end1=matcher1.end();
            int start2=matcher2.start();
            int end2=matcher2.end();
            values.add (val.substring(start1,end1) + val.substring(start2,end2));
            a=a+1;
        }
        String report = "";
        Path path2 = Paths.get(args[0]);
        Scanner scan2 = new Scanner(path2);
        int b =0;
        while (scan2.hasNextLine()){
            String Case2 = scan2.nextLine();
            if(b!=0){
                report = report + "\n" + Case2;
            }
            else {
                report = report +  Case2;
            }
            b = b+1;
        }
        Pattern pattern3 = Pattern.compile("id\": (.+?),");
        Matcher matcher3 = pattern3.matcher(report);
        Pattern pattern4 = Pattern.compile("value\": \"\"");
        Matcher matcher4 = pattern4.matcher(report);
        ArrayList<String> toRep= new ArrayList<>();
        ArrayList<String> rep= new ArrayList<>();

        int c =0;
        while (matcher3.find()){
            int start3=matcher3.start();
            int end3=matcher3.end();
            String id = report.substring(start3,end3);
            int d = 0;
            while (d < a){
                if(values.get(d).contains(id)){
                    String res = "";
                    Pattern pattern5 = Pattern.compile("value\": \"(.*?)\"");
                    Matcher matcher5 = pattern5.matcher(values.get(d));
                    matcher5.find();
                    int start4=matcher5.start();
                    int end4=matcher5.end();
                    res = values.get(d).substring(start4+8,end4);

                    matcher4.find();
                    int start5=matcher4.start();
                    int end5=matcher4.end();

                    String toReplace = report.substring(start3,end5);
                    toRep.add(toReplace);

                    String replace = toReplace.replace("\"\"",res);
                    rep.add(replace);

                    c=c+1;
                }
                d = d+1;
            }
        }
        int i = 0;
        while (i<c){
            report = report.replace(toRep.get(i),rep.get(i));
            i=i+1;
        }
        File file = new File("report.json");
        file.createNewFile();
        FileWriter writer = new FileWriter(file);
        writer.write(report);
        writer.flush();
    }
}