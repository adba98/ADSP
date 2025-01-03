package org.adsp.utils;

import java.io.*;
import java.util.Vector;

public class FileUtil {
    public void writeToFile(String fileName, String dataLine, boolean isAppendMode, boolean isNewLine) {
        if (isNewLine) {
            dataLine = "\n" + dataLine;
        }
        try {
            DataOutputStream dos = new DataOutputStream(new FileOutputStream(fileName, isAppendMode));
            dos.writeBytes(dataLine);
            dos.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public Vector<String> fileToVector(String fileName) {
        Vector<String> v = new Vector<>();
        String inputLine;
        try {
            File inFile = new File(fileName);
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(inFile)));
            while ((inputLine = br.readLine()) != null) {
                v.addElement(inputLine.trim());
            }
            br.close();
        } catch (IOException ignored) {
        }
        return (v);
    }
}
