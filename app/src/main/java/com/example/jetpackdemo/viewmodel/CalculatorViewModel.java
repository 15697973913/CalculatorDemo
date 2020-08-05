package com.example.jetpackdemo.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CalculatorViewModel extends ViewModel {
    /**
     * 第一个输入的数
     */
    private MutableLiveData<Double> oneNumber = new MutableLiveData<>(0.0);

    /**
     * 第二个输入的数
     */
    private MutableLiveData<Double> towNumber = new MutableLiveData<>(0.0);


    /**
     * 运算符   1：加  2：减  3：乘  4：除  5:等于
     */
    private int operator = -1;

    public void setValue(double value) {
        if (operator == -1) {
            oneNumber.setValue(oneNumber.getValue() * 10 + value);
        } else {
            towNumber.setValue(towNumber.getValue() * 10 + value);
        }
    }

    public double getOneNumber() {
        if (oneNumber == null) {
            oneNumber = new MutableLiveData<>(0.0);
        }
        return oneNumber.getValue();
    }

    /**
     * 求出结果
     * operator   1：加  2：减  3：乘  4：除  5：等于
     */
    public void outResults(int operator) {
        switch (this.operator) {
            case -1:
                this.operator = operator;
                break;
            case 1:
                oneNumber.setValue(oneNumber.getValue() + towNumber.getValue());
                this.operator = -1;
                break;
            case 2:
                oneNumber.setValue(oneNumber.getValue() - towNumber.getValue());
                this.operator = -1;
                break;
            case 3:
                oneNumber.setValue(oneNumber.getValue() * towNumber.getValue());

                this.operator = -1;
                break;
            case 4:
                if (oneNumber.getValue() != 0) {
                    oneNumber.setValue(oneNumber.getValue() / towNumber.getValue());
                }
                this.operator = -1;
                break;
            case 5:
                if (oneNumber.getValue() != 0 & towNumber.getValue() != 0) {
                    outResults(this.operator);
                }
                break;
        }
    }

    /**
     * 删除
     */
    public void delete() {
        oneNumber.setValue(0.0);
        towNumber.setValue(0.0);
        operator = -1;
    }

}
