package hello;
import java.util.ArrayList;

public class ClassConnector{
    private int ClassID;
    private String ClassName;
    private String SubjectName;
    private int SubjectID;
    private String linkName;
    private int linkID;
    
    public ClassConnector(String cn, int cID, String sn, int sID, String ln, int lID){
        ClassID = cID;
        ClassName = cn;
        SubjectName = sn;
        SubjectID = sID;
        linkName = ln;
        linkID = lID;
    }

    public ClassConnector(String cn, int cID, int sID){
        ClassID = cID;
        ClassName = cn;
        SubjectID = sID;
    }

    public ClassConnector(int cID, String ln, int lID){
        ClassID = cID;
        linkName = ln;
        linkID = lID;
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

    public String getLinkName() {return linkName;}

    public int getLinkID() {return linkID;}

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

    public void setLinkName(String ln) { linkName = ln;}

    public void setLinkID(int lID) {linkID = lID;}


}
