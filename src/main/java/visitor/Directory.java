package visitor;

import java.util.ArrayList;
import java.util.List;

public class Directory implements FileSystemElement {
    private String name;
    private List<FileSystemElement> children = new ArrayList<>();

    public Directory(String name) {
        this.name = name;
    }

    public void accept(FileSystemVisitor visitor) {
        for (FileSystemElement child : children) {
            //visitor is accepted to "inspect" the childelement
            child.accept(visitor);
        }
    }

    public String getName() {
        return name;
    }


    public void addChild(FileSystemElement child) {
        children.add(child);
    }



}