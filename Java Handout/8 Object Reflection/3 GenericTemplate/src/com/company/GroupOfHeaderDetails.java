package com.company;
import java.lang.reflect.*;

public class GroupOfHeaderDetails<THeader, TDetail> {

    private THeader[] headers;
    private TDetail[] details;
    private Class<?> headerClass;
    private Class<?> detailClass;

    public GroupOfHeaderDetails(THeader[] headers, TDetail[] details) {
        this.headers = headers;
        this.details = details;
        this.headerClass = this.headers.getClass().getComponentType();
        this.detailClass = this.details.getClass().getComponentType();
    }

    public void innerJoin() throws Exception{
        for(THeader header : headers){
            for(TDetail detail : details){
                Integer headerId = (Integer) headerClass.getDeclaredMethod("getId").invoke(header);
                Integer foreignKeyId = (Integer) detailClass.getDeclaredMethod("getHeaderId").invoke(detail);
                if(headerId == foreignKeyId){
                    String headerName = headerClass.getDeclaredMethod("getName").invoke(header).toString();
                    String detailName = detailClass.getDeclaredMethod("getName").invoke(detail).toString();
                    System.out.printf("Header Name: %s, Detail Name: %s\n", headerName, detailName);
                }
            }
        }
    }
}
