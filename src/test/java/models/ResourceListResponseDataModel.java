package models;

import lombok.Data;

@Data
public class ResourceListResponseDataModel {
    private int id;
    private String name;
    private int year;
    private String color;
    private String pantone_value;
}
