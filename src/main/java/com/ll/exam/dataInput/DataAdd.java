package com.ll.exam.dataInput;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DataAdd extends Datainput{

    public DataAdd(Scanner sc) {
        this.sc =sc;
        this.params = new HashMap<>();
    }

    @Override
    public Map<String, String> run() {
        System.out.print("명언 : ");
        String content = sc.nextLine();
        params.put("content",content);

        System.out.print("작가 : ");
        String author = sc.nextLine();
        params.put("author",author);

        return params;
    }
}
