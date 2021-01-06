package hello;
import java.util.ArrayList;

public class ClassConnector{
    private int ClassID;
    private String ClassName;
    private String SubjectName;
    private int SubjectID;
    
    public ClassConnector(String cn, int cID, String sn, int sID){
        ClassID = cID;
        ClassName = cn;
        SubjectName = sn;
        SubjectID = sID;
    }

    public ClassConnector(String cn, int cID, int sID){
        ClassID = cID;
        ClassName = cn;
        SubjectID = sID;
    }

    public int getClassID(){
        return ClassID;
    }

    public String getClassName(){
        return ClassName;
    }

    public int getSubjectID(){
        return SubjectID;
    }

    public String getSubjectName() {
        return SubjectName;
    }

    public void setClassID(int cID){
        ClassID = cID;
    }

    public void setClassName(String cn){
        ClassName = cn;
    }

    public void setSubjectID(int sID){
        SubjectID = sID;
    }

    public void setSubjectName(String sn){
        SubjectName = sn;
    }

}
