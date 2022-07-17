package com.ll.exam.dataInput;

import java.util.Map;
import java.util.Scanner;

public abstract class Datainput {
    Scanner sc;
    Map<String, String> params;
    abstract Map<String, String> run();
}
