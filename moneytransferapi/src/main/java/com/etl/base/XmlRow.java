package com.etl.base;
import java.util.ArrayList;
public class XmlRow {
	public ArrayList<String> cellList = new ArrayList<String>();

    @Override
    public String toString() {
        return cellList.toString();
    }
}
