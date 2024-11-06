package models;

import lombok.Data;

@Data
public class ResourceListResponseModel {

    private ResourceListResponseDataModel data;
    private ResourceListResponseSupportModel support;

}
