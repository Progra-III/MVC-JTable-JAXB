package modelo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "empleados")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class ListaEmpleado {
    List<ModeloEmpleado> list;

    public ListaEmpleado(){list = new ArrayList<>();}

    public void  add(ModeloEmpleado emp){list.add(emp);}

    public ListaEmpleado(List<ModeloEmpleado> list){this.list = list;}

    @XmlElement(name = "empleado")
    public List<ModeloEmpleado> getList(){ return list;}

    public void setList(List<ModeloEmpleado> list){this.list = list;}
}
