package com.ll.exam.response;

public class ResponseAdd extends Response {
    int findId;

    public ResponseAdd(boolean isSuc, int num) {
        this.isSuccess = isSuc;
        this.findId = num;
    }

    @Override
    public void message() {
        System.out.println(findId+"번 명언이 등록되었습니다.");
    }
}
