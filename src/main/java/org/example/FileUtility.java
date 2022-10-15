package org.example;

import java.io.*;

public class FileUtility {
    public static byte[] readBytes(String fileWay) throws IOException {
           File file = new File(fileWay);
           byte[] array = new byte[(int) file.length()];
           FileInputStream fis = new FileInputStream(file);
           BufferedInputStream bis=new BufferedInputStream(fis);
            //read file into bytes[]
            bis.read(array);
            bis.close();

            return array;
        }

    public static void writeBytes(String fileName, byte[] data) throws IOException {
        //File file=new File(fileName);
        FileOutputStream fop = new FileOutputStream(fileName);
        BufferedOutputStream bop=new BufferedOutputStream(fop);
        //get the content the bytes
        bop.write(data);
        bop.flush();//emeliyyati tesdiqleyir
        bop.close();
    }

}
