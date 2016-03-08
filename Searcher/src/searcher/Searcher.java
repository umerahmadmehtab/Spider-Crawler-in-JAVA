package Searcher;

import java.util.*;
import java.io.*;

public class Searcher {

    public static void addFolder(File file, Collection< File> all) {
        File[] children = file.listFiles();
        if (children != null) {
            for (File child : children) {
                addFolder(child, all);
            }
        } else {
            all.add(file);
        }
    }

    public static void searchMap(HashMap MyFiles) throws IOException {

        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("Enter the keyword OR Press E to exit: ");
            String s = in.nextLine();
            if (s.equals("E")) {
                return;
            }

            //to traverse the map
            Set set = MyFiles.entrySet();
            Iterator i = set.iterator();

            while (i.hasNext()) {
                Map.Entry me = (Map.Entry) i.next();
                String val = (String) me.getValue();

                File file = new File(val);

                BufferedReader br = new BufferedReader(new FileReader(file));

                String line = null;
                while ((line = br.readLine()) != null) {
                    if (line.contains(s)) {
                        System.out.println("The string exists in file: " + " " + val);
                    }
                }

            }
        }
    }

    public static void PrintFiles(HashMap MyFiles) {

        Set set = MyFiles.entrySet();
        Iterator s = set.iterator();
        System.out.println("The Index mapping is: ");
        while (s.hasNext()) {
            Map.Entry me = (Map.Entry) s.next();
            System.out.print(me.getKey() + ": ");
            System.out.println(me.getValue());
        }

    }

    public static void main(String[] args) {
        Collection< File> all = new ArrayList<>();
        System.out.println("Enter the path of the directory:");
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        addFolder(new File(s), all);

        try {
            FileWriter fstream = null;
            System.out.println("Enter the name of the file:");
             String f = in.nextLine();
            fstream = new FileWriter(f);
            try (BufferedWriter out = new BufferedWriter(fstream)) {
                HashMap< String, String> MyFiles = new HashMap();

                for (File tested : all) {
                    String Fname = tested.getName();
                    String Fpath = tested.getPath();
                    out.write(Fname + "         " + Fpath);
                    out.newLine();
                    MyFiles.put(Fname, Fpath);
                }
                PrintFiles(MyFiles);
                searchMap(MyFiles);
            }
        } catch (IOException ex) {
        }

    }

}
