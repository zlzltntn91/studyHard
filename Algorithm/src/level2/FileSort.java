package level2;

import org.omg.Messaging.SyncScopeHelper;

import java.util.*;

public class FileSort {

    String [] files1 = {"img12test56.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"};
    String [] files2 = {"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"};

    public String fileSort(String[] files){

        StringBuilder sb = new StringBuilder();
        String fileNameTemp = "";
        int firstNum;
        int stringNum;
        int firstNumberIdx;
        int lastNumberIdx;

        LinkedList<Integer> que = new LinkedList<>();

        for (int i = 0; i < files.length; i++) {
            int pi = -1;
            fileNameTemp = files[i];
            for (int j = 0; j < fileNameTemp.length(); j++) {

                    char c = fileNameTemp.charAt(j);


                    String s = c+"";
                    try{
                        pi = Integer.parseInt(s);
                        firstNum = fileNameTemp.indexOf(s);
                        que.offer(firstNum);
                    }catch(NumberFormatException e){
                        stringNum = fileNameTemp.indexOf(s);
                        if(pi != -1){
                            break;
                        }
                }
            }
            firstNumberIdx = que.peekFirst();
            lastNumberIdx = que.peekLast();

            String tttt = fileNameTemp.substring(firstNumberIdx, lastNumberIdx+1);
            System.out.println(Integer.parseInt(tttt));
        }

        String [] sortList = {};
        System.out.println(Arrays.toString(sortList));
        Arrays.sort(files);
        System.out.println(Arrays.toString(files));
        return Arrays.toString(sortList);
    }

    public static void main (String[] args) {

        FileSort fs = new FileSort();
        fs.fileSort(fs.files1);
        fs.fileSort(fs.files2);

    }
}
