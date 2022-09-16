package com.wow.testcode.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by arthur.hw on 2017/5/26.
 */
public class DiskIO {

    public static void main(String[] args) throws Exception {
        DiskIO io = new DiskIO();
        io.readFile("/Users/ali/10_python/get-pip.py");

//        io.writeFile("/Users/ali/10_python/test.py","#coding UTF-8");
    }

    public List<String> readFile(String filePath) throws Exception {
        // 创建字节输入流
        FileInputStream fi = new FileInputStream(filePath);

        // 字节输入流向字符输入流转换
        InputStreamReader ir = new InputStreamReader(fi, "UTF-8");

        // 从InputStreamReader中读取到BufferedReader，实现高效的字符行读取
        BufferedReader br = new BufferedReader(ir);

        List<String> readLines = new ArrayList<>();
        String line = "";
        while ((line = br.readLine()) != null) {
            readLines.add(line);
        }

        br.close();
        ir.close();
        fi.close();

        return readLines;
    }

    public void writeFile(String filePath,String content) throws Exception {

        File file = new File(filePath);

        if (!file.exists())
            file.createNewFile();

        FileOutputStream fo = new FileOutputStream(file, true);

        OutputStreamWriter ow = new OutputStreamWriter(fo, "UTF-8");

        BufferedWriter bw = new BufferedWriter(ow);

        bw.write(content);
        bw.flush();
        bw.close();
        ow.close();
        fo.close();
    }
}
