package com.ll.exam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WiseSayingController {
    private Scanner sc;
    private int wiseSayingsLastId;
    private List<WiseSaying> wiseSayings;

    public WiseSayingController(Scanner sc) {
        wiseSayingsLastId = 0;
        wiseSayings = new ArrayList<>();
        this.sc = sc;
    }

    public void write(Rq rq) {
        int id = ++wiseSayingsLastId;
        System.out.print("명언 : ");
        String content = sc.nextLine();
        System.out.print("작가 : ");
        String author = sc.nextLine();

        wiseSayings.add(new WiseSaying(id, content, author));

        System.out.printf("%d번 명언이 등록되었습니다.\n", id);
    }

    public void list(Rq rq) {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");

        for (int i = wiseSayings.size() - 1; i >= 0; i--) {
            WiseSaying wiseSaying = wiseSayings.get(i);

            System.out.printf("%d / %s / %s\n", wiseSaying.id, wiseSaying.author, wiseSaying.content);
        }
    }

    public void modify(Rq rq) {
        int id = rq.getIntParam("id", 0);

        if (id == 0) {
            System.out.println("번호를 입력해주세요.");
            return;
        }

        WiseSaying wiseSaying = findById(id);

        if (wiseSaying == null) {
            System.out.printf("%d번 명언은 존재하지 않습니다.\n", id);
            return;
        }

        System.out.printf("명언(기존) : %s\n", wiseSaying.content);
        System.out.print("명언 : ");
        String content = sc.nextLine();

        System.out.printf("작가(기존) : %s\n", wiseSaying.author);
        System.out.print("작가 : ");
        String author = sc.nextLine();

        wiseSaying.content = content;
        wiseSaying.author = author;
    }

    public void remove(Rq rq) {
        int id = rq.getIntParam("id", 0);

        if (id == 0) {
            System.out.println("번호를 입력해주세요.");
            return;
        }

        WiseSaying wiseSaying = findById(id);

        if (wiseSaying == null) {
            System.out.printf("%d번 명언은 존재하지 않습니다.\n", id);
            return;
        }

        wiseSayings.remove(wiseSaying);

        System.out.printf("%d번 명언이 삭제되었습니다.\n", id);
    }

    private WiseSaying findById(int id) {
        for (WiseSaying wiseSaying : wiseSayings) {
            if (wiseSaying.id == id) {
                return wiseSaying;
            }
        }

        return null;
    }
}