package com.ll.exam.dataInput;

import com.ll.exam.WiseSaying;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DataModify extends Datainput{

    WiseSaying wiseSaying;

    public DataModify(Scanner sc, WiseSaying wiseSaying) {
        this.sc =sc;
        this.wiseSaying = wiseSaying;
        this.params = new HashMap<>();
    }

    @Override
    public Map<String, String> run() {
        System.out.println("명언(기존) : "+ wiseSaying.getContent());
        System.out.print("명언 : ");
        String content = sc.nextLine();
        params.put("content",content);

        System.out.println("작가(기존) : "+ wiseSaying.getAuthor());
        System.out.print("작가 : ");
        String author = sc.nextLine();
        params.put("author",author);

        return params;
    }
}
