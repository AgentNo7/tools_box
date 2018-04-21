package com.xinverse.pojo;

import java.util.List;

public class ShuDu {

    private List<String> shudu;

    private Integer[][] data;

    public ShuDu(){
    }

    public ShuDu(List<String> shudu) {
        this.shudu = shudu;
    }

    private int isValid(String num) {
        if (num == null || num.length() == 0) return 0;
        if (num.length() > 1) return -1;
        char n = num.charAt(0);
        if (n > '9' || n < '0') return -1;
        return Integer.parseInt(num);
    }

    public Integer[][] getData() {
        if (data != null) {
            return data;
        }
        data = new Integer[9][9];
        int size = shudu.size();
        for (int i = 0; i < size; i++) {
            int num = isValid(shudu.get(i));
            if (num == -1) {
                data = null;
                break;
            }
            data[i / 9][i % 9] = num;
        }
        return data;
    }

    public List<String> getShudu() {
        return shudu;
    }

    public void setShudu(List<String> shudu) {
        this.shudu = shudu;
    }
}
