package org.adsp.utils;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

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
}
