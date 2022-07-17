package com.ll.exam;

import com.ll.exam.dataInput.DataAdd;
import com.ll.exam.dataInput.DataModify;
import com.ll.exam.response.*;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class WiseSayingController {
    private Scanner sc;
    private WiseSayingService wiseSayingService;

    public WiseSayingController(Scanner sc) {
        this.sc = sc;
        wiseSayingService = new WiseSayingService();
    }

    public Response write(Rq rq) {
        DataAdd dataAdd = new DataAdd(sc);
        Map<String, String> params= dataAdd.run();
        int findId = wiseSayingService.write(params.get("content"), params.get("author"));

        Response r = new ResponseAdd(true, findId);
        return r;
    }

    public Response list(Rq rq) {

        List<WiseSaying> wiseSayings = wiseSayingService.findAll();

        Response r = new ResponseList(true, wiseSayings);
        return r;
    }

    public Response modify(Rq rq) {
        int id = rq.getIntParam("id", 0);

        if (id == 0) {
            Response r = new ResponseModify(false,id);
            return r;
        }

        WiseSaying wiseSaying = wiseSayingService.findById(id);

        if (wiseSaying == null) {
            Response r = new ResponseModify(false,id);

            return r;
        }

        DataModify dataModify = new DataModify(sc,wiseSaying);
        Map<String, String> params = dataModify.run();

        wiseSayingService.modify(id, params.get("content"), params.get("author"));

        Response r = new ResponseModify(true,id);
        return r;
    }

    public Response remove(Rq rq) {
        int id = rq.getIntParam("id", 0);

        if (id == 0) {
            Response r = new ResponseRemove(false,id);
            return r;
        }

        WiseSaying wiseSaying = wiseSayingService.findById(id);

        if (wiseSaying == null) {
            Response r = new ResponseRemove(false,id);
            return r;
        }

        wiseSayingService.remove(wiseSaying.getId());

        Response r = new ResponseRemove(true,id);
        return r;
    }

    public void build(Rq rq) {
        wiseSayingService.dumpToJson();
    }
}