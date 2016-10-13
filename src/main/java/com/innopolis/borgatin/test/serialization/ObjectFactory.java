package com.innopolis.borgatin.test.serialization;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.namespace.QName;

/**
 * Created by innopolis on 12.10.16.
 */
@XmlRegistry
public class ObjectFactory {
    private final static QName Q_NAME = new QName(XMLConstants.NULL_NS_URI,"data");

    @XmlElementDecl(name = "dataObj")
    private JAXBElement<DataObject> createData(DataObject value){
        return new JAXBElement<DataObject>(Q_NAME, DataObject.class,null,value);
    }

}

