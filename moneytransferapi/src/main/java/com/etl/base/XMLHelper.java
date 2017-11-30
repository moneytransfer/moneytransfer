package com.etl.base;
import org.w3c.dom.*;
public class XMLHelper {

	public static String getXMLNodeValue(String tag, Element element) 
	{
		String sReturn = "";
		if(element.getElementsByTagName(tag) != null)
		{
			if(element.getElementsByTagName(tag).item(0) != null &&  element.getElementsByTagName(tag).item(0).getChildNodes() != null)
			{
				NodeList nodes = element.getElementsByTagName(tag).item(0).getChildNodes();
				Node node = (Node) nodes.item(0);
				if(node != null)
				{
					sReturn = node.getNodeValue();
				}
			}
		}
		return sReturn;
	}
}
