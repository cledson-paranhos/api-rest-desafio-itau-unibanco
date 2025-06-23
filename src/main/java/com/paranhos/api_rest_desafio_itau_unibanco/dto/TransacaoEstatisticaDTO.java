package com.paranhos.api_rest_desafio_itau_unibanco.dto;

public class TransacaoEstatisticaDTO {
    private Long count;
    private Double sum;
    private Double avg;
    private Double min;
    private Double max;

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public Double getSum() {
        return sum;
    }

    public void setSum(Double sum) {
        this.sum = sum;
    }

    public Double getAvg() {
        return avg;
    }

    public void setAvg(Double avg) {
        this.avg = avg;
    }

    public Double getMin() {
        return min;
    }

    public void setMin(Double min) {
        if (min.isInfinite()) {
            this.min = 0.0;
        } else {
            this.min = min;
        }
    }

    public Double getMax() {
        return max;
    }

    public void setMax(Double max) {
        if (max.isInfinite()) {
            this.max = 0.0;
        } else {
            this.max = max;
        }
    }
}
