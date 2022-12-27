package io.cherrytechnologies.webfluxpractise.dto;

import java.util.Date;

public class ResponseDto<T> {
    private Date date = new Date();
    private T output;

    public ResponseDto(T output) {
        this.output = output;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Object getOutput() {
        return output;
    }

    public void setOutput(T output) {
        this.output = output;
    }

    @Override
    public String toString() {
        return "ResponseDto{" +
                "date=" + date +
                ", output=" + output +
                '}';
    }
}
