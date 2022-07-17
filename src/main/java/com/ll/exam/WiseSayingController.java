package com.ll.exam;

import java.util.List;
import java.util.Scanner;

public class WiseSayingController {
    private Scanner sc;
    private WiseSayingService wiseSayingService;

    public WiseSayingController(Scanner sc) {
        this.sc = sc;
        wiseSayingService = new WiseSayingService();
    }

    public void write(Rq rq) {
        System.out.print("명언 : ");
        String content = sc.nextLine();
        System.out.print("작가 : ");
        String author = sc.nextLine();

        int findId = wiseSayingService.write(content, author);

        System.out.println(findId+"번 명언이 등록되었습니다.");
    }

    public void list(Rq rq) {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");

        List<WiseSaying> wiseSayings = wiseSayingService.findAll();

        for(WiseSaying wiseSaying : wiseSayings){
            System.out.println(wiseSaying.id + " / "+wiseSaying.author+ " / "+ wiseSaying.content);
        }
    }

    public void modify(Rq rq) {
        int id = rq.getIntParam("id", 0);

        if (id == 0) {
            System.out.println("번호를 입력해주세요.");
            return;
        }

        WiseSaying wiseSaying = wiseSayingService.findById(id);

        if (wiseSaying == null) {
            System.out.println(id+"번 명언은 존재하지 않습니다.");
            return;
        }

        System.out.println("명언(기존) : "+ wiseSaying.content);
        System.out.print("명언 : ");
        String content = sc.nextLine();

        System.out.println("작가(기존) : "+ wiseSaying.author);
        System.out.print("작가 : ");
        String author = sc.nextLine();

        wiseSayingService.modify(id, content, author);

        System.out.println(id+"번 명언이 수정되었습니다.\n");
    }

    public void remove(Rq rq) {
        int id = rq.getIntParam("id", 0);

        if (id == 0) {
            System.out.println("번호를 입력해주세요.");
            return;
        }

        WiseSaying wiseSaying = wiseSayingService.findById(id);

        if (wiseSaying == null) {
            System.out.println(id+"번 명언은 존재하지 않습니다.");
            return;
        }

        wiseSayingService.remove(wiseSaying.id);

        System.out.printf(id+"번 명언이 삭제되었습니다.");
    }

    public void build(Rq rq) {
        wiseSayingService.dumpToJson();
    }
}