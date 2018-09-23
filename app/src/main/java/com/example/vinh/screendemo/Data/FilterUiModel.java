package com.example.vinh.screendemo.Data;

/**
 * Created by Vinh on 9/23/2018.
 */

public class FilterUiModel {
    private String name;
    private int icon;
    private boolean isSelect;

    public FilterUiModel(String name, int icon) {
        this.name = name;
        this.icon = icon;
    }

    public FilterUiModel(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public boolean isSelect() {
        return isSelect;
    }

    public void setSelect(boolean select) {
        isSelect = select;
    }
}
