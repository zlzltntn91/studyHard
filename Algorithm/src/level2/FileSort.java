package level2;

import java.util.Arrays;
import java.util.List;

public class FileSort {

    String [] files1 = {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"};
    String [] files2 = {"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"};

    public String fileSort(String[] files){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < files.length; i++) {
        }


        String [] sortList = {};
        System.out.println(Arrays.toString(sortList));
        return Arrays.toString(sortList);
    }

    public static void main (String[] args) {

        FileSort fs = new FileSort();
        fs.fileSort(fs.files1);

    }
}
