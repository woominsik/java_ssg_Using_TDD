package com.ll.exam;

import com.ll.exam.response.Response;

import java.util.List;
import java.util.Scanner;

public class App {
    public static String mode = "prod";
    private Scanner sc;

    public App(Scanner sc) {
        this.sc = sc;
    }

    public static String getBaseDir() {
        return mode + "_data";
    }

    public void run() {
        System.out.println("== 명언 SSG ==");
        WiseSayingController wiseSayingController = new WiseSayingController(sc);

        while (true) {
            System.out.print("명령) ");
            String cmd = sc.nextLine().trim();
            Rq rq = new Rq(cmd);
            boolean isEnd = false;

            switch (rq.getPath()) {
                case "등록":
                    Response r = wiseSayingController.write(rq);
                    r.message();
                    break;
                case "목록":
                    Response r1 = wiseSayingController.list(rq);
                    r1.message();
                    break;
                case "삭제":
                    Response r2 = wiseSayingController.remove(rq);
                    r2.message();
                    break;
                case "수정":
                    Response r3 = wiseSayingController.modify(rq);
                    r3.message();
                    break;
                case "빌드":
                    wiseSayingController.build(rq);
                    break ;
                case "종료":
                    isEnd = true;
                    break;
            }
            if(isEnd){
                break;
            }
        }
    }
}