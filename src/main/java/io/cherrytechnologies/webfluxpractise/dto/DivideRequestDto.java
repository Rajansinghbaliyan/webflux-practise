package io.cherrytechnologies.webfluxpractise.dto;

public class DivideRequestDto {
    private int first;
    private int second;

    public DivideRequestDto(int first, int second) {
        this.first = first;
        this.second = second;
    }

    public int getFirst() {
        return first;
    }

    public void setFirst(int first) {
        this.first = first;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
    }

    @Override
    public String toString() {
        return "DivideRequestDto{" +
                "first=" + first +
                ", second=" + second +
                '}';
    }
}
