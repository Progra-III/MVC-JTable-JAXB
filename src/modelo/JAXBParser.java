package modelo;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileOutputStream;

public class JAXBParser {
    public void marshall(Object o, String s) {
        try {
            //Creando el contexto JAXB
            JAXBContext context = JAXBContext.newInstance(o.getClass());
            //se crea el objeto para realizar el marshaller
            Marshaller marshalObj = context.createMarshaller();
            // se configura la propiedad para mostrar el XML en el formato de salida
            marshalObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
            marshalObj.marshal(o, new FileOutputStream(s));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Object unmarshall(Object ref, String s) {
        Object o = null;
        try {
            //se obtiene el archivo XML para leer
            File file = new File(s);
            //Creando el contexto JAXB
            JAXBContext context = JAXBContext.newInstance(ref.getClass());
            //se crea el objeto para realizar el marshaller
            Unmarshaller unmarshalObj = context.createUnmarshaller();
            //llamando el metodo unmarshall
            o = unmarshalObj.unmarshal(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return o;
    }
}
