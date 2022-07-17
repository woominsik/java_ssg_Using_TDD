package com.ll.exam.response;

import com.ll.exam.WiseSaying;
import com.ll.exam.WiseSayingController;

import java.util.List;

public class ResponseList extends Response{
    List<WiseSaying> wiseSayings;

    public ResponseList(boolean isSuc,List<WiseSaying> wiseSayings) {
        this.isSuccess = isSuc;
        this.wiseSayings = wiseSayings;
    }

    @Override
    public void message() {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");

        for(WiseSaying wiseSaying : wiseSayings){
            System.out.println(wiseSaying.getId() + " / "+wiseSaying.getAuthor()+ " / "+ wiseSaying.getContent());
        }
    }
}
